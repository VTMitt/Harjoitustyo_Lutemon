package com.example.lutemon.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lutemon.Lutemon;
import com.example.lutemon.LutemonListAdapter;
import com.example.lutemon.R;
import com.example.lutemon.Storage;
import com.example.lutemon.storages.BattleStorage;
import com.example.lutemon.storages.HomeStorage;
import com.example.lutemon.storages.TrainingStorage;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FragmentList extends Fragment { //The point of this is to show lutemons in rv

    protected RecyclerView recyclerView;
    protected Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ArrayList<Lutemon> lutemons = new ArrayList<Lutemon>();
        for (Lutemon lutemon: HomeStorage.getInstanceOf().getLutemons()) {
            lutemons.add(lutemon);
        }
        for (Lutemon lutemon: TrainingStorage.getInstanceOf().getLutemons()) {
            lutemons.add(lutemon);
        }
        for (Lutemon lutemon: BattleStorage.getInstanceOf().getLutemons()) {
            lutemons.add(lutemon);
        }
        context = view.getContext();
        recyclerView = view.findViewById(R.id.rvList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new LutemonListAdapter(context, lutemons));
        return view;
    }
}