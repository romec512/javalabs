package com.company.Source;

public class ExceptionSize extends Exception {
    private String message = "Размер массива не удовлетворяет требованиям. Кол-во элементов в массиве меньше ";
    public ExceptionSize(int massSize){
        this.message += massSize + ".";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
