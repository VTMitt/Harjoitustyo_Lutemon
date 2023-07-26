package com.example.lutemon.storages;

import android.content.Context;

import com.example.lutemon.Lutemon;
import com.example.lutemon.Storage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class HomeStorage extends Storage {
    private static HomeStorage storage = null;
    private HomeStorage(){

    }
    public static HomeStorage getInstanceOf(){
        if(storage == null){
            storage = new HomeStorage();
        }
        return storage;
    }
    public void saveAllLutemons(Context context, ArrayList<Lutemon> lutemons1, ArrayList<Lutemon> lutemons2){
        try {
            ObjectOutputStream lutemonWriter = new ObjectOutputStream(context.openFileOutput("lutemonVault.data",Context.MODE_PRIVATE));
            ArrayList<Lutemon> lutemons3 = new ArrayList<Lutemon>();
            lutemons3 = lutemons; // Adds lutemons from HomeStorage to new list
            for (Lutemon lutemon: lutemons1) { //Adds lutemons from TrainingStorage to new list
                lutemons3.add(lutemon);
            }
            for (Lutemon lutemon: lutemons2) { //Adds lutemons from BattleStorage to new list
                lutemons3.add(lutemon);
            }
            lutemonWriter.writeObject(lutemons3); //Saves new list
            lutemonWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
