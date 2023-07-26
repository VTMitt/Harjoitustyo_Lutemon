package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.lutemon.fragments.FragmentManager;

public class ManageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);

        Fragment fragment;
        fragment = new FragmentManager();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentManage,fragment).commit();

    }


}