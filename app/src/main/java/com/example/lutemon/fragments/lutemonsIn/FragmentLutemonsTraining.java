package com.example.lutemon.fragments.lutemonsIn;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lutemon.Lutemon;
import com.example.lutemon.MainActivity;
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
//This fragment allows user to move lutemons from TrainingStorage to other Storages.
public class FragmentLutemonsTraining extends Fragment {
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
        View view = inflater.inflate(R.layout.fragment_lutemons_training, container, false);
        context = view.getContext();
        RadioGroup radioGroup = view.findViewById(R.id.rgLutemonsInTraining);
        radioGroup.removeAllViews();
        ArrayList<Lutemon> lutemons = new ArrayList<Lutemon>();
        lutemons = TrainingStorage.getInstanceOf().getLutemons();
        RadioButton newRB;
        int i = 0;
        for (Lutemon lutemon: lutemons) { //Sets id and name for new RadioButton
            newRB = new RadioButton(context);
            newRB.setText(lutemon.getName());
            newRB.setId(i + 300);
            radioGroup.addView(newRB);
            i++;
        }
        RadioGroup radioGroupMove = view.findViewById(R.id.rgLocations2);

        Button move = view.findViewById(R.id.btnMove2);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                Lutemon lutemon = TrainingStorage.getInstanceOf().getLutemon(radioGroup.getCheckedRadioButtonId() - 300);
                //HomeStorage.getInstanceOf().removeLutemonById(lutemon.getId());
                if(radioGroupMove.getCheckedRadioButtonId() == R.id.rbHome2){
                    TrainingStorage.getInstanceOf().removeLutemonByName(lutemon.getName());
                    lutemon.setHealth(lutemon.getMax_health()); //When lutemon is moved to home it heals
                    HomeStorage.getInstanceOf().addLutemon(lutemon);
                    RadioButton radioButton = view.findViewById(radioGroup.getCheckedRadioButtonId());
                    radioButton.setVisibility(View.INVISIBLE);

                } else if(radioGroupMove.getCheckedRadioButtonId() == R.id.rbTraining2){

                } else if(radioGroupMove.getCheckedRadioButtonId() == R.id.rbBattle2){
                    TrainingStorage.getInstanceOf().removeLutemonByName(lutemon.getName());
                    BattleStorage.getInstanceOf().addLutemon(lutemon);
                    RadioButton radioButton = view.findViewById(radioGroup.getCheckedRadioButtonId());
                    radioButton.setVisibility(View.INVISIBLE);
                }
                Intent intent = new Intent(context, MainActivity.class); //Moves back to MainActivity in order to reload
                startActivity(intent);


            }

        });


        return view;
    }
}