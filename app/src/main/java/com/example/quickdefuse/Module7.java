package com.example.quickdefuse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Module7 extends AppCompatActivity {

    private ImageButton letterA, letterB, letterE, letterF, letterH, letterI, letterM, letterL, letterO, letterR, letterS, letterT, letterX, letterV;
    private TextView solution;
    private TextView word;

    private float x1, x2, y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module7);
        linkComponents();

        setSolution();
        letterS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                word.append("S");
                setSolution();
            }
        });
        letterB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                word.append("B");
                setSolution();
            }
        });

        letterE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                word.append("E");
                setSolution();
            }
        });


        letterF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                word.append("F");
                setSolution();
            }
        });

        letterH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             word.append("H");
             setSolution();
            }
        });

        letterI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                word.append("I");
                setSolution();
            }
        });

        letterL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                word.append("L");
                setSolution();
            }
        });


        letterM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 word.append("M");
                 setSolution();
            }
        });


        letterA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                word.append("A");
                setSolution();
            }
        });

        letterO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                word.append("O");
                setSolution();
            }
        });

        letterR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                word.append("R");
                setSolution();
            }
        });

        letterT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                word.append("T");
                setSolution();
            }
        });

        letterX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                word.append("X");
                setSolution();
            }
        });


        letterV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                word.append("V");
                setSolution();
            }
        });
    }

    private void linkComponents() {
        letterB = findViewById(R.id.imageButton);
        letterE = findViewById(R.id.imageButton2);
        letterF = findViewById(R.id.imageButton4);
        letterH = findViewById(R.id.imageButton3);
        letterI = findViewById(R.id.imageButton5);
        letterL = findViewById(R.id.imageButton6);
        letterM = findViewById(R.id.imageButton7);
        letterO = findViewById(R.id.imageButton8);
        letterR = findViewById(R.id.imageButton9);
        letterT = findViewById(R.id.imageButton11);
        letterX = findViewById(R.id.imageButton10);
        letterV = findViewById(R.id.imageButton12);
        letterS = findViewById(R.id.imageButton13);
        letterA = findViewById(R.id.imageButton14);

        solution = findViewById(R.id.textFinal);
        word = findViewById(R.id.letters);
    }
    private void setSolution(){
        if(word.getText().toString().length()>3){
            word.setText("");
            solution.setText("Try again");
        }
        switch(word.getText().toString()){
            case "BE":
                solution.setText("Answer on: 3.600 MHz");
                word.setText("");
                break;
            case "BI":
                solution.setText("Answer on: 3.552 MHz");
                word.setText("");
                break;
            case "BOM":
                solution.setText("Answer on: 3.565 MHz");
                word.setText("");
                break;
            case "BOX":
                solution.setText("Answer on: 3.535 MHz");
                word.setText("");
                break;
            case "BRE":
                solution.setText("Answer on: 3.572 MHz");
                word.setText("");
                break;
            case "BRI":
                solution.setText("Answer on: 3.575 MHz");
                word.setText("");
                break;
            case "FL":
                solution.setText("Answer on: 3.555 MHz");
                word.setText("");
                break;
            case "HA":
                solution.setText("Answer on: 3.515 MHz");
                word.setText("");
                break;
            case "LE":
                solution.setText("Answer on: 3.542 MHz");
                word.setText("");
                break;
            case "SH":
                solution.setText("Answer on: 3.505 MHz");
                word.setText("");
                break;
            case "SL":
                solution.setText("Answer on: 3.522 MHz");
                word.setText("");
                break;
            case "STE":
                solution.setText("Answer on: 3.582 MHz");
                word.setText("");
                break;
            case "STI":
                solution.setText("Answer on: 3.592 MHz");
                word.setText("");
                break;
            case "STR":
                solution.setText("Answer on: 3.545 MHz");
                word.setText("");
                break;
            case "TR":
                solution.setText("Answer on: 3.532 MHz");
                word.setText("");
                break;
            case "VE":
                solution.setText("Answer on: 3.595 MHz");
                word.setText("");
                break;
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
                    Intent i = new Intent(Module7.this, Module6.class);
                    startActivity(i);
                }
                if(x1>x2){
                    Intent i = new Intent(Module7.this, Module8.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}