package com.example.lutemon;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {

    TextView attack;
    TextView defence;
    TextView health;
    TextView experience;
    TextView name;
    ImageView image;

    TextView wins;
    TextView losses;

    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        attack = itemView.findViewById(R.id.txtAttack);
        defence = itemView.findViewById(R.id.txtDefence);
        health = itemView.findViewById((R.id.txtLife));
        experience = itemView.findViewById(R.id.txtExp);
        name = itemView.findViewById(R.id.txtName);
        image = itemView.findViewById(R.id.imgView);
        wins = itemView.findViewById(R.id.txtWins);
        losses = itemView.findViewById(R.id.txtLosses);
    }
}
