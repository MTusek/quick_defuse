package com.example.quickdefuse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Module6 extends AppCompatActivity {

    private float x1,x2, y1,y2;

    //Broj sa velikog ekrana
    private ImageButton nextNumber;
    private ImageButton previousNumber;

    private TextView number;


    //Informacija koju korisnik mora dati
    private TextView info;

    //Informacija o poziciji broja
    private TextView numberPosition;
    private ImageButton numberPositionNext;
    private ImageButton numberPositionPrevious;

    //Informacija o broju određene pozicije
    private TextView numberOption;
    private ImageButton numberOptionNext;
    private ImageButton numberOptionPrevious;

    //Rješenje n-tog koraka
    private TextView stepSolve;

    private ImageButton nextStep;

    private TextView currentStep;

    private int n, nV, nP, nS;

    private int[] positions = new int[6];
    private int[] values = new int[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module6);
        linkComponents();
        setDescription();
        //updateNumbers();
        nextNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNextNumber();
                setStepSolve();
                setDescription();
            }
        });

        previousNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPreviousNumber();
                setStepSolve();
            }
        });

        numberOptionNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNextNumberOption();
                setDescription();
            }
        });

        numberOptionPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPreviousNumberOption();
                setDescription();
            }
        });

        numberPositionPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPreviousNumberPosition();
                setDescription();
            }
        });

        numberPositionNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNextNumberPositon();
                setDescription();
            }
        });

        nextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNextStep();
                setStepSolve();
            }
        });

    }

    private void linkComponents() {
        previousNumber = findViewById(R.id.previousNumber);
        nextNumber = findViewById(R.id.nextNumber);
        number = findViewById(R.id.textNumber);
        n = 1;

        info = findViewById(R.id.text_information);

        numberPosition = findViewById(R.id.textNumber2);
        numberPositionNext = findViewById(R.id.nextNumber2);
        numberPositionPrevious = findViewById(R.id.previousNumber2);
        nP = 2;

        numberOption = findViewById(R.id.textNumber1);
        numberOptionNext = findViewById(R.id.nextNumber1);
        numberOptionPrevious = findViewById(R.id.previousNumber1);
        nV = 1;

        stepSolve = findViewById(R.id.step_instruction);
        nextStep = findViewById(R.id.nextStep);
        currentStep = findViewById(R.id.textStep);
        nS = 1;

        setNumberPosition();
        setNumberValue();
    }

    private void setPreviousNumber() {
        n--;
        if (n < 1)
            n = 4;
        number.setText("" + n);
        setNumberValue();
        setNumberPosition();
    }

    private void setNextNumber() {
        n++;
        if (n > 4)
            n = 1;
        number.setText("" + n);
        setNumberValue();
        setNumberPosition();
    }

    private void setNextNumberOption() {
        nV++;
        if (nV > 4)
            nV = 1;
        setNumberValue();
    }

    private void setPreviousNumberOption() {
        nV--;
        if (nV < 1)
            nV = 4;
        setNumberValue();
    }

    private void setPreviousNumberPosition() {
        nP--;
        if (nP < 1)
            nP = 4;
        setNumberPosition();
    }

    private void setNextNumberPositon() {
        nP++;
        if (nP > 4)
            nP = 1;
        setNumberPosition();
    }
    private void setNumberPosition(){
        numberPosition.setText(""+nP);
    }

    private void setNumberValue(){
        numberOption.setText("" + nV);
    }


    private void setNextStep() {
        nS++;
        setStepSolve();
        //updateNumbers();
        if (nS > 5)
            nS = 1;
        switch (nS) {
            case 1:
                currentStep.setText("STEP 1");
                break;
            case 2:
                currentStep.setText("STEP 2");
                break;
            case 3:
                currentStep.setText("STEP 3");
                break;
            case 4:
                currentStep.setText("STEP 4");
                break;
            case 5:
                currentStep.setText("STEP 5");
                break;
        }
    }

    private void setStepSolve() {
        n = Integer.parseInt(number.getText().toString());
        if (currentStep.getText().equals("STEP 1")) {
            switch (n) {
                case 1:
                    stepSolve.setText("Press button on position 2");
                    nP=2;
                    break;
                case 2:
                    stepSolve.setText("Press button on position 2");
                    nP=2;
                    break;
                case 3:
                    stepSolve.setText("Press button on position 3");
                    nP=3;
                    break;
                case 4:
                    stepSolve.setText("Press button on position 4");
                    nP=4;
                    break;
            }
        }
        if (currentStep.getText().equals("STEP 2")) {
            switch (n) {
                case 1:
                    stepSolve.setText("Press button number 4");
                    nV=4;
                    break;
                case 2:
                    stepSolve.setText("Press button on position P1");
                    break;
                case 3:
                    stepSolve.setText("Press button on position 1");
                    nP=1;
                    break;
                case 4:
                    stepSolve.setText("Press button on position P1");
                    break;
            }
        }

        if (currentStep.getText().equals("STEP 3")) {
            switch (n) {
                case 1:
                    stepSolve.setText("Press button number N2");
                    break;
                case 2:
                    stepSolve.setText("Press button number N1");
                    break;
                case 3:
                    stepSolve.setText("Press button on position 3");
                    nP=3;
                    break;
                case 4:
                    stepSolve.setText("Press button number 4");
                    nV=4;
                    break;
            }
        }

        if (currentStep.getText().equals("STEP 4")) {
            switch (n) {
                case 1:
                    stepSolve.setText("Press button on position P1");
                    break;
                case 2:
                    stepSolve.setText("Press button on position 1");
                    nP=1;
                    break;
                case 3:
                    stepSolve.setText("Press button on position P2");
                    break;
                case 4:
                    stepSolve.setText("Press button on position P2");
                    break;
            }
        }

        if (currentStep.getText().equals("STEP 5")) {
            switch (n) {
                case 1:
                    stepSolve.setText("Press button number N1");
                    break;
                case 2:
                    stepSolve.setText("Press button number N2");
                    break;
                case 3:
                    stepSolve.setText("Press button number N3");
                    break;
                case 4:
                    stepSolve.setText("Press button number N4");
                    break;
            }
        }

        updateInstructions();
    }
    private void setDescription() {
        info.setText("Button number " + nV + " is on position " + nP);
        setNumberValue();
        setNumberPosition();
       storeToMemory();
    }
    private void storeToMemory() {
        if (currentStep.getText().equals("STEP 1")) {
            positions[1] = nP;
            values[1] = nV;
        }
        if (currentStep.getText().equals("STEP 2")) {
            positions[2] = nP;
            values[2] = nV;
        }
        if (currentStep.getText().equals("STEP 3")) {
            positions[3] = nP;
            values[3] = nV;
        }
        if (currentStep.getText().equals("STEP 4")) {
            positions[4] = nP;
            values[4] = nV;
        }
        if (currentStep.getText().equals("STEP 5")) {
            positions[5] = nP;
            values[5] = nV;
        }
    }

    private void updateInstructions(){
        if(stepSolve.getText().equals("Press button on position P1")){
            stepSolve.setText("Press button on position "+positions[1]);
            nP=positions[1];
        }
        if(stepSolve.getText().equals("Press button on position P2")){
            stepSolve.setText("Press button on position "+positions[2]);
            nP=positions[2];
        }
        if(stepSolve.getText().equals("Press button number N1")){
            stepSolve.setText("Press button number "+values[1]);
            nV=values[1];
        }
        if(stepSolve.getText().equals("Press button number N2")){
            stepSolve.setText("Press button number "+values[2]);
            nV=values[2];
        }
        if(stepSolve.getText().equals("Press button number N3")){
            stepSolve.setText("Press button number "+values[3]);
            nV=values[3];
        }
        if(stepSolve.getText().equals("Press button number N4")){
            stepSolve.setText("Press button number "+values[4]);
            nV=values[4];
        }
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
                    Intent i = new Intent(Module6.this, Module5.class);
                    startActivity(i);
                }
                if(x1>x2){
                    Intent i = new Intent(Module6.this, Module7.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}
