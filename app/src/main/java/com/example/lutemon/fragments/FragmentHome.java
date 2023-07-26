package com.example.lutemon.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lutemon.CreateLutemonActivity;
import com.example.lutemon.Lutemon;
import com.example.lutemon.LutemonListAdapter;
import com.example.lutemon.ManageActivity;
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
public class FragmentHome extends Fragment {

    protected Context context;
    protected RecyclerView recyclerView;


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
        View view =inflater.inflate(R.layout.fragment_home, container, false);
        context = view.getContext();
        Button btnCreate = view.findViewById(R.id.btnCreateLutemon);
        Button btnLoad = view.findViewById(R.id.btnLoadLutemon);
        Button btnSave = view.findViewById(R.id.btnSaveLutemon);
        ImageView imgList = view.findViewById(R.id.imgList);
        Button btnManage = view.findViewById(R.id.btnManage);

        btnManage.setOnClickListener(new View.OnClickListener() { //Opens activity that allows lutemons to be moved from one Storage to another.
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ManageActivity.class);
                startActivity(intent);
            }
        });

        imgList.setOnClickListener(new View.OnClickListener() { //opens fragment in home that shows lutemons in rv
            @Override
            public void onClick(View view) {
                if(Storage.getInstanceOf().getLutemons().size() != 0) {
                    Fragment fragment;
                    fragment = new FragmentList();
                    getParentFragmentManager().beginTransaction().replace(R.id.frameList, fragment).commit();
                }
            }
        });


        btnCreate.setOnClickListener(new View.OnClickListener() { //Moves to activity where lutemons are created
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CreateLutemonActivity.class);
                /* Learned this from: https://www.youtube.com/watch?v=TY-2Cx4IW9A
                * */
                startActivity(intent);

            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() { //loads saved lutemons to HomeStorage
            @Override
            public void onClick(View view) {
                HomeStorage.getInstanceOf().loadLutemons(context);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {//Saves all lutemons
            @Override
            public void onClick(View view) {
                HomeStorage.getInstanceOf().saveAllLutemons(context,TrainingStorage.getInstanceOf().getLutemons(), BattleStorage.getInstanceOf().getLutemons());
            }
        });


        return view;
    }


}

