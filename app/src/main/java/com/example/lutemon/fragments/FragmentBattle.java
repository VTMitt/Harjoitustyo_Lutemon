package com.example.lutemon.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.lutemon.Expression;
import com.example.lutemon.Lutemon;
import com.example.lutemon.R;
import com.example.lutemon.Storage;
import com.example.lutemon.storages.BattleStorage;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FragmentBattle extends Fragment {
    protected static final long total_time = 60000;
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
        View view = inflater.inflate(R.layout.fragment_battle, container, false);
        if (getArguments() != null) {
            String lutemon1Id = getArguments().getString("vars1Id"); // Getting and Lutemons
            String lutemon2Id = getArguments().getString("vars2Id");
            Lutemon battler1 = BattleStorage.getInstanceOf().getLutemonById(lutemon1Id);
            Lutemon battler2 = BattleStorage.getInstanceOf().getLutemonById(lutemon2Id);
            TextView battle = view.findViewById(R.id.txtBattle); //Getting stuff for battle frame
            TextView prop = view.findViewById(R.id.txtProp);
            ImageView imgShield = view.findViewById(R.id.imgShield);
            ImageView imgBattler1 = view.findViewById(R.id.imgBattler1);
            ImageView imgBattler2 = view.findViewById(R.id.imgBattler2);
            imgBattler1.setImageResource(battler1.getImage());
            imgBattler2.setImageResource(battler2.getImage());
            ImageView imgExpression1 = view.findViewById(R.id.imgExpression1);
            ImageView imgExpression2 = view.findViewById(R.id.imgExpression2);
            Expression expression = new Expression();

            imgShield.setOnClickListener(new View.OnClickListener() { // The battle
                @Override
                public void onClick(View view) {

                    CountDownTimer countDownTimer;
                    countDownTimer = new CountDownTimer(timeLeft,3000) {
                        int attacker = 0; // Determines which Lutemon will strike;
                        int emotion1 = 0;
                        int emotion2 = 0;
                        String stringProp = ""; //This will show more clearly what happens
                        int fullAttack; // Entire attack power, depends on attacker's attack with randomness and defenders defense;
                        @Override
                        public void onTick(long l) {
                            timeLeft = l;
                            if(attacker == 0){
                                battle.append(1 + ": " +battler1.listOfStats() + "\n"); // Lists stats to battle log
                                battle.append(2 + ": " + battler2.listOfStats() + "\n");
                                battle.append(battler1.getColor() + " (" + battler1.getName() + ")" + " attacks " +
                                        battler2.getColor() + "(" + battler2.getName() + ")\n");
                                fullAttack = battler1.getAttack()*(int)(Math.random()*3); //Calculates attack power
                                if(fullAttack - battler2.getDefence() < 0){
                                    fullAttack = battler2.getDefence();
                                    emotion1 = expression.getNeutral();
                                    emotion2 = expression.randomHappy();
                                    stringProp = "Miss!";
                                } else{ //Lutemon wont heal if its defence is greater than opponents attack. This means attack misses
                                    emotion1 = expression.randomHappy();
                                    emotion2 = expression.randomSad();
                                    stringProp = "Strike!";
                                }
                                battler2.setHealth(battler2.getHealth() + battler2.getDefence() - fullAttack);
                                imgExpression2.setImageResource(emotion2); // Shows expressions
                                imgExpression1.setImageResource(emotion1);
                                prop.setText(stringProp); //Shows clearly what happened
                                attacker = 1; // Changes attacker
                                if(battler2.getHealth() > 0){
                                    battle.append(battler2.getColor() + "(" + battler2.getName() + ") manages to escape death\n");
                                } else{
                                    battle.append(battler2.getColor() + "(" + battler2.getName() + ") faints\n");
                                    battler2.setHealth(0);
                                    battler1.setWins(battler1.getWins() + 1);
                                    battler2.setLosses(battler2.getLosses() + 1);
                                    battler1.setExperience(battler1.getExperience() + 10);
                                    battler1.checkIncrease();
                                    stringProp = "Knock-out!";
                                    prop.setText(stringProp);

                                    cancel();
                                }


                            } else{
                                battle.append(2 + ": " + battler2.listOfStats() + "\n");

                                battle.append(1 + ": " + battler1.listOfStats() + "\n");

                                battle.append(battler2.getColor() + " (" + battler2.getName() + ")" + " attacks " +
                                        battler1.getColor() + "(" + battler1.getName() + ")\n");
                                fullAttack = battler1.getAttack()*(int)(Math.random()*3);
                                if(fullAttack - battler2.getDefence() < 0){
                                    fullAttack = battler2.getDefence();
                                    emotion1 = expression.randomHappy();
                                    emotion2 = expression.getNeutral();
                                    stringProp = "Miss!";
                                } else{
                                    emotion1 = expression.randomSad();
                                    emotion2 = expression.randomHappy();
                                    stringProp = "Strike!";
                                }
                                battler1.setHealth(battler1.getHealth() + battler1.getDefence() - fullAttack);
                                attacker = 0;
                                imgExpression1.setImageResource(emotion1);
                                imgExpression2.setImageResource(emotion2);
                                prop.setText(stringProp);
                                if(battler1.getHealth() > 0){
                                    battle.append(battler1.getColor() + "(" + battler1.getName() + ") manages to escape death\n");
                                } else{
                                    battle.append(battler1.getColor() + "(" + battler1.getName() + ") faints\n");
                                    battler1.setHealth(0);
                                    battler2.setWins(battler2.getWins() + 1);
                                    battler2.setExperience(battler2.getExperience() + 10);
                                    battler1.setLosses(battler1.getLosses() + 1);
                                    battler1.checkIncrease();
                                    stringProp = "Knock-out!";
                                    prop.setText(stringProp);

                                    cancel();
                                }

                            }
                        }

                        @Override
                        public void onFinish() {
                            battle.append("Draw");
                            timeLeft = total_time;

                        }
                    }.start();
                }
            });
    }


        return view;
    }
}