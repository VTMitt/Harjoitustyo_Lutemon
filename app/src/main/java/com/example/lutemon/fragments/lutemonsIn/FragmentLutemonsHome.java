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
import com.example.lutemon.storages.BattleStorage;
import com.example.lutemon.storages.HomeStorage;
import com.example.lutemon.storages.TrainingStorage;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */

//This fragment allows user to move lutemons from HomeStorage to other Storages.
public class FragmentLutemonsHome extends Fragment {
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
        View view = inflater.inflate(R.layout.fragment_lutemons_home, container, false);
        context = view.getContext();
        RadioGroup radioGroup = view.findViewById(R.id.rgLutemonsInHome);
        radioGroup.removeAllViews();
        ArrayList<Lutemon> lutemons = new ArrayList<Lutemon>();
        lutemons = HomeStorage.getInstanceOf().getLutemons();
        RadioButton newRB;
        int i = 0;
        for (Lutemon lutemon: lutemons) { //Sets id and name for new RadioButton
            newRB = new RadioButton(context);
            newRB.setText(lutemon.getName());
            newRB.setId(i + 200);
            radioGroup.addView(newRB);
            i++;
        }

        RadioGroup radioGroupMove = view.findViewById(R.id.rgLocations1);


        Button move = view.findViewById(R.id.btnMove1);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                Lutemon lutemon = HomeStorage.getInstanceOf().getLutemon(radioGroup.getCheckedRadioButtonId() - 200);
                if(radioGroupMove.getCheckedRadioButtonId() == R.id.rbHome1){

                } else if(radioGroupMove.getCheckedRadioButtonId() == R.id.rbTraining1){
                    HomeStorage.getInstanceOf().removeLutemonByName(lutemon.getName());
                    TrainingStorage.getInstanceOf().addLutemon(lutemon);
                    RadioButton radioButton = view.findViewById(radioGroup.getCheckedRadioButtonId());
                    radioButton.setVisibility(View.INVISIBLE);

                } else if(radioGroupMove.getCheckedRadioButtonId() == R.id.rbBattle1){
                    HomeStorage.getInstanceOf().removeLutemonByName(lutemon.getName());
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