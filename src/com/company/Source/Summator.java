package com.company.Source;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Observable;

public class Summator extends Observable implements EvenSummator, OddSummator {
    public int [] mass;
    private LogUtility logUtility;
    public Summator(int []args){
        addObserver(new ConsoleWatcher());
        Translator translator = new Translator(args);
        mass = translator.getMass();
        logUtility = LogUtility.getInstance();
    }

    @Override
    public int getEvenSumm() throws ExceptionSize, ExceptionMissingNum, ExceptionNumLess {
        this.isSizeSatisfactory();
        this.isNumMissing();
        this.isNumsLess();
        int summ = 0;
        for(int i = 0; i < mass.length; i++){
            if(mass[i] % 2 == 0){
                summ += mass[i];
            }
        }
        System.out.println("Сумма четных: " + summ);
        logUtility.log("Сумма четных: " + summ);
        setChanged(); // Изменяет состояние
        notifyObservers();
        return summ;
    }

    @Override
    public int getOddSumm() throws ExceptionSize, ExceptionMissingNum, ExceptionNumLess {
        this.isSizeSatisfactory();
        this.isNumMissing();
        this.isNumsLess();
        int summ = 0;
        for(int i = 0; i < mass.length; i++){
            if(mass[i] % 2 != 0){
                summ += mass[i];
            }
        }
        System.out.println("Сумма нечетных: " + summ);
        logUtility.log("Сумма нечетных: " + summ);
        setChanged(); // Изменяет состояние
        notifyObservers();
        return summ;
    }

    private void isSizeSatisfactory() throws ExceptionSize {
        if(this.mass.length < MASS_SIZE){
            throw new ExceptionSize(MASS_SIZE);
        }
    }

    private void isNumMissing() throws ExceptionMissingNum{
        for(int i = 0; i < mass.length; i++){
            if(mass[i] == EXPECTED_NUM){
                return;
            }
        }
        throw new ExceptionMissingNum(EXPECTED_NUM);
    }

    private void isNumsLess() throws ExceptionNumLess {
        for(int i = 0; i < mass.length; i++){
            if(mass[i] < MIN_ELEMENT){
                throw new ExceptionNumLess(i, MIN_ELEMENT);
            }
        }
    }

    public static int getResult(String expression){
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        int result = -32000;
        try {
            result =  Integer.parseInt(engine.eval(expression).toString());
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return result;
    }
}
