package com.company;


import com.company.Source.ExceptionSize;
import com.company.Source.Summator;

public class Main {

    public static void main(String[] args) {
        int sumEven = 0, sumOdd = 0;
        int [] mass = new int[args.length];
        for(int i = 0; i < args.length; i++){
            mass[i] = Integer.parseInt(args[i]);
        }
        Summator summator = new Summator(mass);
        try{
            sumEven = summator.getEvenSumm();
            sumOdd = summator.getOddSumm();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Сумма четных : " + sumEven + "\nСумма нечетных : " + sumOdd);
    }
}
