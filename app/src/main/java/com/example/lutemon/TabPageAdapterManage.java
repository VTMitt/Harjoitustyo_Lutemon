package com.example.lutemon;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.lutemon.fragments.lutemonsIn.FragmentLutemonsBattle;
import com.example.lutemon.fragments.lutemonsIn.FragmentLutemonsHome;
import com.example.lutemon.fragments.lutemonsIn.FragmentLutemonsTraining;

public class TabPageAdapterManage extends FragmentStateAdapter {
    public TabPageAdapterManage(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public TabPageAdapterManage(@NonNull Fragment fragment) {
        super(fragment);
    }

    public TabPageAdapterManage(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;
        if(position == 0){
            fragment = new FragmentLutemonsHome();

        } else if(position == 1){
            fragment = new FragmentLutemonsTraining();
        } else{
            fragment = new FragmentLutemonsBattle();
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
