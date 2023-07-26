package com.example.lutemon.storages;

import com.example.lutemon.Storage;

public class TrainingStorage extends Storage {
    private static TrainingStorage storage = null;
    private TrainingStorage(){

    }
    public static TrainingStorage getInstanceOf(){
        if(storage == null){
            storage = new TrainingStorage();
        }
        return storage;
    }
}
