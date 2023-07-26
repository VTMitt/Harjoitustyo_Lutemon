package com.example.lutemon.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lutemon.Lutemon;
import com.example.lutemon.R;
import com.example.lutemon.Storage;
import com.example.lutemon.storages.BattleStorage;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FragmentBattleArena extends Fragment {

    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    Context context;

    Button button;
    int rgSize;

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
        View view = inflater.inflate(R.layout.fragment_battle_arena, container, false);
        context = view.getContext();
        button = view.findViewById(R.id.btnBattle);
        radioGroup1 = view.findViewById(R.id.rgBattleArena1); //Two radioGroups that shows lutemons in a row
        radioGroup2 = view.findViewById(R.id.rgBattleArena2);
        radioGroup1.removeAllViews();
        radioGroup2.removeAllViews();
        ArrayList<Lutemon> lutemons = new ArrayList<Lutemon>();
        lutemons = BattleStorage.getInstanceOf().getLutemons();
        RadioButton newRB1;
        RadioButton newRB2;
        int i = 0;
        for (Lutemon lutemon: lutemons) {
            newRB1 = new RadioButton(context);
            newRB2 = new RadioButton(context);
            newRB1.setText(lutemon.getName());
            newRB1.setId(i + 1000);
            newRB2.setText(lutemon.getName());
            newRB2.setId(i + 10000);
            radioGroup1.addView(newRB1);
            radioGroup2.addView(newRB2);
            i++;
        }
        rgSize = i;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rgSize != 0) {
                    if((radioGroup1.getCheckedRadioButtonId() != -1) && (radioGroup2.getCheckedRadioButtonId() != -1) ) { // learned this here https://stackoverflow.com/questions/24992936/how-to-check-if-a-radiobutton-is-checked-in-a-radiogroup-in-android
                        Lutemon battler1 = BattleStorage.getInstanceOf().getLutemon(radioGroup1.getCheckedRadioButtonId() - 1_000);
                        Lutemon battler2 = BattleStorage.getInstanceOf().getLutemon(radioGroup2.getCheckedRadioButtonId() - 10_000);
                        System.out.println(battler1.getId());
                        System.out.println(battler2.getId());
                        Bundle vars = new Bundle();
                        vars.putString("vars1Id", battler1.getId());
                        vars.putString("vars2Id", battler2.getId());
                        Fragment fragment;
                        fragment = new FragmentBattle();
                        fragment.setArguments(vars); //Moves chosen lutemons to FragmentBattle
                        getParentFragmentManager().beginTransaction().replace(R.id.frameBattle, fragment).commit();
                    }
                }
            }
        });


        return view;
    }
}