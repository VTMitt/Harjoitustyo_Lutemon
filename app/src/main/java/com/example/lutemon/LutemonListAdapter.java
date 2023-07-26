package com.example.lutemon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonListAdapter extends RecyclerView.Adapter<LutemonViewHolder> {
    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<Lutemon>();

    public LutemonListAdapter(Context context, ArrayList<Lutemon> lutemons){
        this.context = context;
        this.lutemons = lutemons;
    }


    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {
        holder.attack.setText("Attack: " + lutemons.get(position).getAttack());
        holder.defence.setText("Defence: " + lutemons.get(position).getDefence());
        holder.name.setText("" +lutemons.get(position).getName());
        holder.health.setText("Health: " + lutemons.get(position).getHealth());
        holder.experience.setText("Exp: " + lutemons.get(position).getExperience());
        holder.wins.setText("Wins: " + lutemons.get(position).getWins());
        holder.losses.setText("Losses: " + lutemons.get(position).getLosses());
        holder.image.setImageResource(lutemons.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
