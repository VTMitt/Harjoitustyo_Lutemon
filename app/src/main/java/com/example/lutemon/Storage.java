package com.example.lutemon;

import android.content.Context;

import com.example.lutemon.storages.HomeStorage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Storage {
    protected ArrayList<Lutemon> lutemons = new ArrayList<Lutemon>();

    private static Storage storage = null;

    protected Storage(){

    }

    public static Storage getInstanceOf(){
        if(storage == null){
            storage = new Storage();
        }
        return storage;
    }

    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }

    public Lutemon getLutemon(int id){
        return lutemons.get(id);
    }

    public void loadLutemons(Context context){
        ObjectInputStream lutemonReader = null;
        try {
            lutemonReader = new ObjectInputStream(context.openFileInput("lutemonVault.data"));
            lutemons = (ArrayList<Lutemon>) lutemonReader.readObject();
            lutemonReader.close();
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
        }
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

    public void setLutemons(ArrayList<Lutemon> lutemons) {
        this.lutemons = lutemons;
    }

    public Lutemon getLutemonById(String id){ // Gets Lutemon by its random id
        for (Lutemon lutemon: lutemons) {
            if(lutemon.getId().equals(id) ){
                return lutemon;
            }
        }
        return lutemons.get(0);
    }

    public void removeLutemon(int id){
        lutemons.remove(id);
    }

    public void removeLutemonByName(String name){
        int i = 0;
        for (Lutemon lutemon: lutemons) {
            if(lutemon.getName().equals(name) ){
                lutemons.remove(i);
                break;
            }
            i++;
        }
    }
}
