package com.example.lutemon.types;

import com.example.lutemon.Lutemon;
import com.example.lutemon.R;

public class White extends Lutemon {
    public White(){
        this.name = "White";
        this.color = "White";
        this.attack = 5;
        this.defence = 2;
        this.experience = 0;
        this.health = 20;
        this.max_health = 20;
        this.wins = 0;
        this.losses = 0;
        this.trainingDays = 0;
        this.level = 1;
        this.image = R.drawable.baseline_icecream_24;
    }

}
