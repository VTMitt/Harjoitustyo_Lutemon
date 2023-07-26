package com.example.lutemon.fragments.trainings;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.lutemon.Lutemon;
import com.example.lutemon.R;
import com.example.lutemon.Storage;
import com.example.lutemon.storages.TrainingStorage;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FragmentRun extends Fragment {
    protected TextView countDown;
    protected Button btnRun;
    protected TextView informRun;

    protected RadioGroup radioGroup;

    protected static final long total_time = 3000; //How long running takes
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
        View view = inflater.inflate(R.layout.fragment_run, container, false);
        if (getArguments() != null) {
            String lutemonId = getArguments().getString("varsId");
            Lutemon lutemon = TrainingStorage.getInstanceOf().getLutemonById(lutemonId);
            countDown = view.findViewById(R.id.txtRunCountDown);
            informRun = view.findViewById(R.id.txtInformRun);
            //radioGroup = view.findViewById(R.id.rgLutemonTrain);
            btnRun = view.findViewById(R.id.btnRun);
            btnRun.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    CountDownTimer countDownTimer; // Learned CountDownTimer from: https://www.youtube.com/watch?v=MDuGwI6P-X8
                    countDownTimer = new CountDownTimer(timeLeft,1000) {
                        @Override
                        public void onTick(long l) {
                            timeLeft = l;
                            String timeLeftString = String.valueOf((int)timeLeft/1000);
                            countDown.setText(timeLeftString); //Shows time left to user
                        }

                        @Override
                        public void onFinish() {
                            countDown.setText("Lutemon gained 1 experience point");
                            lutemon.setExperience(lutemon.getExperience() + 1);
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