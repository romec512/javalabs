package com.company.Source;

import sun.rmi.runtime.Log;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LogUtility {
    private static LogUtility instance;
    private String filename;
    public LogUtility(String _filename){
        filename = _filename;
    }
    public static LogUtility getInstance(String _filename){
        if(instance == null){
            instance = new LogUtility(_filename);
        }
        return instance;
    }

    public static LogUtility getInstance(){
        if(instance == null){
            instance = new LogUtility("log.txt");
        }
        return instance;
    }

    public void log(String message){
        message += "\n";
        try {
            File file = new File(filename);
            if(!file.exists()){
                file.createNewFile();
            }
            Files.write(Paths.get(filename), message.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл.\n" + e.getMessage());
        }
    }
}
