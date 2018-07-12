package com.hy.designpatterns.observer;

import java.util.Observable;

public class DataChange extends Observable {
    private static DataChange instance = null;

    public static DataChange getInstance() {
        if (null == instance) {
            instance = new DataChange();
        }
        return instance;
    }

    public void notifyDataChange(Data data) {
        setChanged();
        notifyObservers(data);
    }
}
