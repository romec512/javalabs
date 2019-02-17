package com.company;


public class Main {

    public static void main(String[] args) {
        int sumEven = 0, sumOdd = 0;
        for(int i = 0; i < args.length; i++){
            int value = Integer.parseInt(args[i]);
            if(value % 2 == 0){
                sumEven += value;
            } else {
                sumOdd += value;
            }
        }
        System.out.println("Сумма четных : " + sumEven + "\nСумма нечетных : " + sumOdd);
    }
}
