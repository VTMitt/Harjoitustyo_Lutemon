package com.example.lutemon.storages;

import com.example.lutemon.Lutemon;
import com.example.lutemon.Storage;

import java.util.ArrayList;

public class BattleStorage extends Storage {
    private static BattleStorage storage = null;
    private BattleStorage(){

    }
    public static BattleStorage getInstanceOf(){
        if(storage == null){
            storage = new BattleStorage();
        }
        return storage;
    }
}
