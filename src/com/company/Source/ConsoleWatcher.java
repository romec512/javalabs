package com.company.Source;

import java.util.Observable;
import java.util.Observer;

public class ConsoleWatcher implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Вывод в консоль");
        LogUtility.getInstance().log("Вывод в консоль");
    }
}
