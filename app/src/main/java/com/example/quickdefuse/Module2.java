package com.example.quickdefuse;

import static android.view.View.GONE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

public class Module2 extends AppCompatActivity {

    private float x1, x2, y1, y2;
    private Button button;
    private CheckBox textAbort;
    private CheckBox textHold;
    private CheckBox textDetonate;

    private ImageButton increaseBatteryNumber;
    private ImageButton decreaseBatteryNumber;

    private CheckBox CARIndicator;
    private CheckBox FRKIndicator;

    private CheckBox buttonRed;
    private CheckBox buttonYellow;
    private CheckBox buttonBlue;

    private CheckBox buttonWhite;

    private TextView solution;

    private TextView numberOfBatteries;

    private TextView additionalInformation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module2);
        linkComponents();
        solution.setVisibility(View.INVISIBLE);
        additionalInformation.setVisibility(View.INVISIBLE);

        increaseBatteryNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBatteriesNumber();
            }
        });

        decreaseBatteryNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reduceBatteriesNumber();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSolution();
                solution.setVisibility(View.VISIBLE);
                if(solution.getText().equals("HOLD"))
                    additionalInformation.setVisibility(View.VISIBLE);
            }
        });

        //Boja gumba
        buttonRed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonBlue.setChecked(false);
                    buttonYellow.setChecked(false);
                    buttonWhite.setChecked(false);
                    setSolution();
                    button.setBackgroundColor(Color.RED);
                }
            }
        });
        buttonBlue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonRed.setChecked(false);
                    buttonYellow.setChecked(false);
                    buttonWhite.setChecked(false);
                    setSolution();
                    button.setBackgroundColor(Color.CYAN);
                }
            }
        });

        buttonYellow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonBlue.setChecked(false);
                    buttonRed.setChecked(false);
                    buttonWhite.setChecked(false);
                    setSolution();
                    button.setBackgroundColor(Color.YELLOW);
                }
            }
        });

        buttonWhite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonBlue.setChecked(false);
                    buttonYellow.setChecked(false);
                    buttonRed.setChecked(false);
                    setSolution();
                    button.setBackgroundColor(Color.WHITE);
                }
            }
        });

        //Tekst na gumbu

        textHold.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textDetonate.setChecked(false);
                    textAbort.setChecked(false);
                    setSolution();
                    button.setText("Hold");
                }
            }
        });

        textDetonate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textHold.setChecked(false);
                    textAbort.setChecked(false);
                    setSolution();
                    button.setText("Detonate");
                }
            }
        });


        textAbort.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textDetonate.setChecked(false);
                    textHold.setChecked(false);
                    setSolution();
                    button.setText("Abort");
                }
            }
        });

        //Indikatori
        FRKIndicator.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setSolution();
                }
            }
        });

        CARIndicator.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setSolution();
                }
            }
        });
    }

    public void linkComponents(){
        button = findViewById(R.id.button);
        textAbort = findViewById(R.id.checkBoxAbort);
        textDetonate = findViewById(R.id.checkBoxDetonate);
        textHold = findViewById(R.id.checkBoxHold);
        CARIndicator = findViewById(R.id.checkBox4);
        FRKIndicator = findViewById(R.id.checkBox5);
        buttonRed = findViewById(R.id.checkBoxRed);
        buttonWhite = findViewById(R.id.checkBoxWhite);
        buttonBlue = findViewById(R.id.checkBoxBlue);
        buttonYellow = findViewById(R.id.checkBoxYellow);
        solution = findViewById(R.id.text_solve);
        numberOfBatteries = findViewById(R.id.text_wires_number);
        additionalInformation = findViewById(R.id.hold_info);
        increaseBatteryNumber = findViewById(R.id.addBatteryCount);
        decreaseBatteryNumber = findViewById(R.id.reduceBatteryCount);
    }

    public void addBatteriesNumber() {
        setSolution();
        int batteries = 0;

        if(numberOfBatteries.getText().equals("3+"))
            batteries = 4;
        else
            batteries = Integer.parseInt(numberOfBatteries.getText().toString());

        batteries++;

        if (batteries > 4)
            batteries = 0;

        if(batteries>3)
            numberOfBatteries.setText("3+");
        else
            numberOfBatteries.setText("" + batteries);
    }

    public void reduceBatteriesNumber() {
        setSolution();
        int batteries = 0;

        if(numberOfBatteries.getText().equals("3+"))
            batteries = 4;
        else
            batteries = Integer.parseInt(numberOfBatteries.getText().toString());

        batteries--;

        if (batteries < 0)
            batteries = 4;

        if(batteries>3)
            numberOfBatteries.setText("3+");
        else
            numberOfBatteries.setText("" + batteries);
    }

    public void setSolution(){

        int batteries = 0;
        if(numberOfBatteries.getText().equals("3+"))
            batteries = 4;
        else
            batteries = Integer.parseInt(numberOfBatteries.getText().toString());

        if(buttonBlue.isChecked() && textAbort.isChecked()){
            solution.setText("HOLD");
        } else if (batteries>1 && textDetonate.isChecked()) {
            solution.setText("PRESS");
        } else if (buttonWhite.isChecked() && CARIndicator.isChecked()) {
            solution.setText("HOLD");
        } else if (batteries>2 && FRKIndicator.isChecked()) {
            solution.setText("PRESS");
        } else if (buttonYellow.isChecked()) {
            solution.setText("HOLD");
        } else if (buttonRed.isChecked() && textHold.isChecked()) {
            solution.setText("PRESS");
        }else {
            solution.setText("HOLD");
        }
        solution.setVisibility(GONE);
        additionalInformation.setVisibility(GONE);
    }
    public boolean onTouchEvent(MotionEvent touchevent){
        switch(touchevent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1= touchevent.getX();
                y1= touchevent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2= touchevent.getX();
                y2= touchevent.getY();
                if(x1<x2){
                    Intent i = new Intent(Module2.this, MainActivity.class);
                    startActivity(i);
                }
                //break;
                if(x1>x2){
                    Intent i = new Intent(Module2.this, Module3.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }

}