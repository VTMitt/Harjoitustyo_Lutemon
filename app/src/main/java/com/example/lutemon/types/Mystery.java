package com.example.lutemon.types;

import com.example.lutemon.Lutemon;
import com.example.lutemon.R;

public class Mystery extends Lutemon {
    public Mystery(){
        this.name = "Mystery";
        this.color = "Mystery";
        this.attack = 5;
        this.defence = 2;
        this.experience = 0;
        this.health = 20;
        this.max_health = 20;
        this.level = 1;
        this.wins = 0;
        this.losses = 0;
        this.image = R.drawable.baseline_grade_24;
    }
}
