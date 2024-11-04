
package com.example.quickdefuse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Module9 extends AppCompatActivity {

    private int wireRedCounter, wireBlueCounter, wireBlackCounter;
    private TextView redCounter, blueCounter, blackCounter;
    private TextView solutionRed, solutionBlue, solutionBlack;
    private ImageButton nextRedWire, nextBlueWire, nextBlackWire;
    private ImageButton previousRedWire, previousBlueWire, previousBlackWire;

    private float x1, x2, y1, y2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module9);
        linkComponents();
        setSolution();
        previousRedWire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPreviousWire(0);
                setSolution();
            }
        });

        previousBlueWire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPreviousWire(1);
                setSolution();
            }
        });

        previousBlackWire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPreviousWire(2);
                setSolution();
            }
        });

        nextRedWire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNextWire(0);
                setSolution();
            }
        });

        nextBlueWire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNextWire(1);
                setSolution();
            }
        });

        nextBlackWire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNextWire(2);
                setSolution();
            }
        });
    }
    private void linkComponents(){

        redCounter = findViewById(R.id.redWireNumber);
        blueCounter = findViewById(R.id.blueWireNumber);
        blackCounter = findViewById(R.id.blackWireNumber);

        previousBlackWire = findViewById(R.id.blackWireMinus);
        previousBlueWire = findViewById(R.id.blueWireMinus);
        previousRedWire = findViewById(R.id.redWireMinus);

        nextBlackWire = findViewById(R.id.blackWirePlus);
        nextBlueWire = findViewById(R.id.blueWirePlus);
        nextRedWire = findViewById(R.id.redWirePlus);

        solutionRed = findViewById(R.id.text_solve_red);
        solutionBlue = findViewById(R.id.text_solve_blue);
        solutionBlack = findViewById(R.id.text_solve_black);

        wireRedCounter=0;
        wireBlueCounter=0;
        wireBlackCounter=0;
    }

    private void setNextWire(int wireID){
        if(wireID ==0){
            wireRedCounter++;
            if(wireRedCounter>9){
                wireRedCounter=0;
            }
            redCounter.setText(""+wireRedCounter);
        }
        if (wireID ==2) {
            wireBlackCounter++;
            if(wireBlackCounter>9){
                wireBlackCounter=0;
            }
            blackCounter.setText(""+wireBlackCounter);
        }
        if(wireID ==1){
            wireBlueCounter++;
            if(wireBlueCounter>9){
                wireBlueCounter=0;
            }
            blueCounter.setText(""+wireBlueCounter);
        }
    }

    private void setPreviousWire(int wireID){
        if(wireID ==0){
            wireRedCounter--;
            if(wireRedCounter<0){
                wireRedCounter=9;
            }
            redCounter.setText(""+wireRedCounter);
        }
        if (wireID ==2) {
            wireBlackCounter--;
            if(wireBlackCounter<0){
                wireBlackCounter=9;
            }
            blackCounter.setText(""+wireBlackCounter);
        }
        if(wireID ==1){
            wireBlueCounter--;
            if(wireBlueCounter<0){
                wireBlueCounter=9;
            }
            blueCounter.setText(""+wireBlueCounter);
        }
    }

    private void setSolution(){
        switch (wireRedCounter){
            case 0:
                solutionRed.setText("Cut RED if on: ");
                break;
            case 1:
                solutionRed.setText("Cut RED if on: C");
                break;
            case 2:
                solutionRed.setText("Cut RED if on: B");
                break;
            case 3:
                solutionRed.setText("Cut RED if on: A");
                break;
            case 4:
                solutionRed.setText("Cut RED if on: A or C");
                break;
            case 5:
                solutionRed.setText("Cut RED if on: B");
                break;
            case 6:
                solutionRed.setText("Cut RED if on: A or C");
                break;
            case 7:
                solutionRed.setText("Cut RED if on: A, B or C");
                break;
            case 8:
                solutionRed.setText("Cut RED if on: A or B");
                break;
            case 9:
                solutionRed.setText("Cut RED if on: B");
                break;
        }
        switch(wireBlueCounter){
            case 0:
                solutionBlue.setText("Cut BLUE if on: ");
                break;
            case 1:
                solutionBlue.setText("Cut BLUE if on: B");
                break;
                case 2:
                solutionBlue.setText("Cut BLUE if on: A or C");
                break;
                case 3:
                solutionBlue.setText("Cut BLUE if on: B");
                break;
                case 4:
                solutionBlue.setText("Cut BLUE if on: A");
                break;
                case 5:
                solutionBlue.setText("Cut BLUE if on: B");
                break;
                case 6:
                solutionBlue.setText("Cut BLUE if on: B or C");
                break;
                case 7:
                solutionBlue.setText("Cut BLUE if on: C");
                break;
                case 8:
                solutionBlue.setText("Cut BLUE if on: A or C");
                break;
                case 9:
                solutionBlue.setText("Cut BLUE if on: A");
                break;
        }
        switch(wireBlackCounter){
            case 0:
                solutionBlack.setText("Cut BLACK if on: ");
                break;
            case 1:
                solutionBlack.setText("Cut BLACK if on: A, B or C");
                break;
            case 2:
                solutionBlack.setText("Cut BLACK if on: A or C");
                break;
            case 3:
                solutionBlack.setText("Cut BLACK if on: B");
                break;
            case 4:
                solutionBlack.setText("Cut BLACK if on: A or C");
                break;
            case 5:
                solutionBlack.setText("Cut BLACK if on: C");
                break;
            case 6:
                solutionBlack.setText("Cut BLACK if on: B or C");
                break;
            case 7:
                solutionBlack.setText("Cut BLACK if on: A or B");
                break;
            case 8:
                solutionBlack.setText("Cut BLACK if on: C");
                break;
            case 9:
                solutionBlack.setText("Cut BLACK if on: C");
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
                    Intent i = new Intent(Module9.this, Module8.class);
                    startActivity(i);
                }
                if(x1>x2){
                    Intent i = new Intent(Module9.this, Module10.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}