package com.company.Source;

public class Summator implements EvenSummator, OddSummator {
    public int [] mass;
    public Summator(int[] _mass){
        this.mass = _mass;
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
}
