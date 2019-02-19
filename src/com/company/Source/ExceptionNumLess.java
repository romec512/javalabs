package com.company.Source;

public class ExceptionNumLess extends Exception {
    private String message = "В массиве присутствует элемент меньше ";
    public ExceptionNumLess(int position, int element){
        message += element + ", позиция " + position;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
