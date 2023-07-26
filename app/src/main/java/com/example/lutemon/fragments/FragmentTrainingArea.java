package com.example.lutemon.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Trace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lutemon.Lutemon;
import com.example.lutemon.R;
import com.example.lutemon.Storage;
import com.example.lutemon.fragments.trainings.FragmentBike;
import com.example.lutemon.fragments.trainings.FragmentRun;
import com.example.lutemon.fragments.trainings.FragmentSwim;
import com.example.lutemon.storages.TrainingStorage;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FragmentTrainingArea extends Fragment {
    Context context;
    ImageView imgRun;
    ImageView imgBike;
    ImageView imgSwim;



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
        View view = inflater.inflate(R.layout.fragment_training_area, container, false);
        context = view.getContext();
        RadioGroup radioGroup = view.findViewById(R.id.rgLutemonTrain);
        radioGroup.removeAllViews();
        ArrayList<Lutemon> lutemons = new ArrayList<Lutemon>();
        lutemons = TrainingStorage.getInstanceOf().getLutemons();
        RadioButton newRB;
        int i = 0;
        for (Lutemon lutemon: lutemons) {
            newRB = new RadioButton(context);
            newRB.setText(lutemon.getName());
            newRB.setId(i);
            radioGroup.addView(newRB);
            i++;
        }

        imgRun = view.findViewById(R.id.imgRun);
        imgBike = view.findViewById(R.id.imgBike);
        imgSwim = view.findViewById(R.id.imgSwim);

        imgRun.setOnClickListener(new View.OnClickListener() { //Starts FragmentRun
            @Override
            public void onClick(View view) {
                Lutemon lutemon = TrainingStorage.getInstanceOf().getLutemon(radioGroup.getCheckedRadioButtonId());
                Bundle vars = new Bundle();
                vars.putString("varsId",lutemon.getId()); //Puts lutemons id into Bundle
                Fragment fragment;
                fragment = new FragmentRun();
                fragment.setArguments(vars);
                getParentFragmentManager().beginTransaction().replace(R.id.frameActivity,fragment).commit();
            }
        });

        imgBike.setOnClickListener(new View.OnClickListener() { //Starts FragmentBike
            @Override
            public void onClick(View view) {
                Lutemon lutemon = TrainingStorage.getInstanceOf().getLutemon(radioGroup.getCheckedRadioButtonId());
                Bundle vars = new Bundle();
                vars.putString("varsId",lutemon.getId()); //Puts lutemons id into Bundle
                Fragment fragment;
                fragment = new FragmentBike();
                fragment.setArguments(vars);
                getParentFragmentManager().beginTransaction().replace(R.id.frameActivity,fragment).commit();

            }
        });

        imgSwim.setOnClickListener(new View.OnClickListener() { //Starts FragmentSwim
            @Override
            public void onClick(View view) {
                Lutemon lutemon = TrainingStorage.getInstanceOf().getLutemon(radioGroup.getCheckedRadioButtonId());
                Bundle vars = new Bundle();
                vars.putString("varsId",lutemon.getId()); //Puts lutemons id into Bundle
                Fragment fragment;
                fragment = new FragmentSwim();
                fragment.setArguments(vars);
                getParentFragmentManager().beginTransaction().replace(R.id.frameActivity,fragment).commit();
            }
        });


        return view;
    }
}