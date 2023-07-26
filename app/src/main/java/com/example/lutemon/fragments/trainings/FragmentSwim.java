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
public class FragmentSwim extends Fragment {
    TextView countDown;
    Button btnSwim;
    TextView informSwim;
    protected static final long total_time = 10000; //How long swimming takes
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
        View view = inflater.inflate(R.layout.fragment_swim, container, false);
        if (getArguments() != null) {
            String lutemonId = getArguments().getString("varsId");
            Lutemon lutemon = TrainingStorage.getInstanceOf().getLutemonById(lutemonId);
            countDown = view.findViewById(R.id.txtSwimCountDown);
            informSwim = view.findViewById(R.id.txtInformSwim);
            btnSwim = view.findViewById(R.id.btnSwim);
            btnSwim.setOnClickListener(new View.OnClickListener() {
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
                            //After training
                            countDown.setText("Lutemon gained 5 experience point");
                            lutemon.setExperience(lutemon.getExperience() + 5);
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