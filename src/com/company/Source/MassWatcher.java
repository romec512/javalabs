package com.company.Source;

import java.util.Observable;
import java.util.Observer;

public class MassWatcher implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Обращение к массиву");
        LogUtility.getInstance().log("Обращение к массиву");
    }
}
