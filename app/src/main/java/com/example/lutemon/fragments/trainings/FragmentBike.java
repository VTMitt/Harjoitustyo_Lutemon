package com.example.lutemon.fragments.trainings;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.lutemon.Lutemon;
import com.example.lutemon.R;
import com.example.lutemon.Storage;
import com.example.lutemon.storages.TrainingStorage;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FragmentBike extends Fragment {
    TextView countDown;
    Button btnBike;
    TextView informBike;
    protected static final long total_time = 5000; //How long biking takes
    protected long timeLeft = total_time;


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
        View view = inflater.inflate(R.layout.fragment_bike, container, false);
        if (getArguments() != null) {
            String lutemonId = getArguments().getString("varsId");
            Lutemon lutemon = TrainingStorage.getInstanceOf().getLutemonById(lutemonId);
            System.out.println(lutemon.getName());
            countDown = view.findViewById(R.id.txtBikeCountDown);
            informBike = view.findViewById(R.id.txtInformBike);
            btnBike = view.findViewById(R.id.btnBike);
            btnBike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    CountDownTimer countDownTimer;
                    countDownTimer = new CountDownTimer(timeLeft,1000) {
                        @Override
                        public void onTick(long l) {
                            timeLeft = l;
                            String timeLeftString = String.valueOf((int)timeLeft/1000);
                            countDown.setText(timeLeftString); //Shows time left to user
                        }

                        @Override
                        public void onFinish() {
                            countDown.setText("Lutemon gained 2 experience point");
                            lutemon.setExperience(lutemon.getExperience() + 2);
                            lutemon.checkIncrease();
                            timeLeft = total_time;
                        }
                    }.start();



                }
            });
        }
        return view;
    }
}