package com.company;


import com.company.Source.LogUtility;
import com.company.Source.Summator;
import sun.rmi.runtime.Log;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int sumEven = 0, sumOdd = 0;
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        String message = "Введите путь к файлу:";
        System.out.println(message);
        String filename = scanner.nextLine();
        LogUtility logUtility = LogUtility.getInstance(filename);
        logUtility.log(message);
        message = "Введите кол-во элементов массива:";
        System.out.println(message);
        logUtility.log(message);
        if(scanner.hasNextInt()){
            n = scanner.nextInt();
        }
        int [] mass = new int[n];
        for(int i = 0; i < n; i++){
            if(scanner.hasNextInt()) {
                mass[i] = scanner.nextInt();
            } else {
                mass[i] = 0;
            }
        }
        Summator summator = new Summator(mass);
        try{
            sumEven = summator.getEvenSumm();
            sumOdd = summator.getOddSumm();
        } catch (Exception e){
            System.out.println(e.getMessage());
            logUtility.log(e.getMessage());
        }
    }
}
