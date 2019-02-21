package com.company.Source;

import java.util.Observable;

public class Translator extends Observable {
    private int [] mass;
    public Translator(int[] args){
        mass = args;
    }

    public int[] getMass(){
        addObserver(new MassWatcher());
        setChanged();
        notifyObservers();
        return mass;
    }
}
