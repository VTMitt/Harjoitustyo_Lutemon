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
//This fragment allows user to move lutemons from BattleStorage to other Storages.
public class FragmentLutemonsBattle extends Fragment {
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
        View view = inflater.inflate(R.layout.fragment_lutemons_battle, container, false);
        context = view.getContext();
        RadioGroup radioGroup = view.findViewById(R.id.rgLutemonsInBattle);
        radioGroup.removeAllViews();
        ArrayList<Lutemon> lutemons = new ArrayList<Lutemon>();
        lutemons = BattleStorage.getInstanceOf().getLutemons();
        RadioButton newRB;
        int i = 0;
        for (Lutemon lutemon: lutemons) { //Sets id and name for new RadioButton
            newRB = new RadioButton(context);
            newRB.setText(lutemon.getName());
            newRB.setId(i + 400);
            radioGroup.addView(newRB);
            i++;
        }
        RadioGroup radioGroupMove = view.findViewById(R.id.rgLocations3);

        Button move = view.findViewById(R.id.btnMove3);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                Lutemon lutemon = BattleStorage.getInstanceOf().getLutemon(radioGroup.getCheckedRadioButtonId() - 400);
                if(radioGroupMove.getCheckedRadioButtonId() == R.id.rbHome3){
                    BattleStorage.getInstanceOf().removeLutemonByName(lutemon.getName());
                    lutemon.setHealth(lutemon.getMax_health()); //When lutemon is moved to home it heals
                    HomeStorage.getInstanceOf().addLutemon(lutemon);
                    RadioButton radioButton = view.findViewById(radioGroup.getCheckedRadioButtonId());
                    radioButton.setVisibility(View.INVISIBLE);

                } else if(radioGroupMove.getCheckedRadioButtonId() == R.id.rbTraining3){
                    BattleStorage.getInstanceOf().removeLutemonByName(lutemon.getName());
                    TrainingStorage.getInstanceOf().addLutemon(lutemon);
                    RadioButton radioButton = view.findViewById(radioGroup.getCheckedRadioButtonId());
                    radioButton.setVisibility(View.INVISIBLE);

                } else{

                }
                Intent intent = new Intent(context, MainActivity.class); //Moves back to MainActivity in order to reload
                startActivity(intent);
            }


        });
        return view;
    }
}