package com.company.Source;

public class ExceptionMissingNum extends Exception {
    private String message = "В массиве отсутствует элемент '";
    public ExceptionMissingNum(int num){
        this.message += num + "'.";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
