package com.example.lutemon;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.lutemon.fragments.FragmentBattleArena;
import com.example.lutemon.fragments.FragmentHome;
import com.example.lutemon.fragments.FragmentTrainingArea;

public class TabPagerAdapter extends FragmentStateAdapter {
    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public TabPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public TabPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;
        if(position == 0){
            fragment = new FragmentHome();
        } else if(position == 1){
            fragment = new FragmentTrainingArea();

        }else if(position == 2){
            fragment = new FragmentBattleArena();

        } else{
            fragment = new FragmentHome();

        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
