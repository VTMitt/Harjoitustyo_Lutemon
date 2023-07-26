package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lutemon.storages.HomeStorage;
import com.example.lutemon.types.Black;
import com.example.lutemon.types.Blue;
import com.example.lutemon.types.Green;
import com.example.lutemon.types.Mystery;
import com.example.lutemon.types.Red;
import com.example.lutemon.types.White;

public class CreateLutemonActivity extends AppCompatActivity {

    Context context;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_lutemon);
        name = findViewById(R.id.editName);
        context = this;
    }


    public void createLutemon(View view){
        RadioGroup radioGroup = findViewById(R.id.rgLutemons);
        String name1 = name.getText().toString();

        int idRandom = (int)(Math.random()*10000);
        String id = (name1 + " " + Integer.toString(idRandom)); //Creates random id for lutemon
        System.out.println(id);
        if(radioGroup.getCheckedRadioButtonId() == R.id.rbBlack){
            Black black = new Black();
            black.setName(name1);
            black.setId(id);
            Storage.getInstanceOf().addLutemon(black);
            HomeStorage.getInstanceOf().addLutemon(black);
        } else if(radioGroup.getCheckedRadioButtonId() == R.id.rbBlue){
            Blue blue = new Blue();
            blue.setName(name1);
            blue.setId(id);
            Storage.getInstanceOf().addLutemon(blue);
            HomeStorage.getInstanceOf().addLutemon(blue);
        } else if(radioGroup.getCheckedRadioButtonId() == R.id.rbRed){
            Red red = new Red();
            red.setName(name1);
            red.setId(id);
            Storage.getInstanceOf().addLutemon(red);
            HomeStorage.getInstanceOf().addLutemon(red);
        } else if(radioGroup.getCheckedRadioButtonId() == R.id.rbWhite){
            White white = new White();
            white.setName(name1);
            white.setId(id);
            Storage.getInstanceOf().addLutemon(white);
            HomeStorage.getInstanceOf().addLutemon(white);
        } else if(radioGroup.getCheckedRadioButtonId() == R.id.rbGreen){
            Green green = new Green();
            green.setName(name1);
            green.setId(id);
            Storage.getInstanceOf().addLutemon(green);
            HomeStorage.getInstanceOf().addLutemon(green);
        } else if(radioGroup.getCheckedRadioButtonId() == R.id.rbMystery){
            Mystery mystery = new Mystery();
            mystery.setName(name1);
            mystery.setId(id);
            Storage.getInstanceOf().addLutemon(mystery);
            HomeStorage.getInstanceOf().addLutemon(mystery);

        } else{
            Red red = new Red();
            red.setName(name1);
            red.setId(id);
            Storage.getInstanceOf().addLutemon(red);
            HomeStorage.getInstanceOf().addLutemon(red);
        }
        switchToMain();
    }

    public void switchToMain(){
        Intent intent = new Intent(context, MainActivity.class);
        startActivity(intent);

    }
}