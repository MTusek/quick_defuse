package com.example.quickdefuse;

import static android.widget.Toast.makeText;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Module4 extends AppCompatActivity {

    private float x1,x2, y1, y2;

    private CheckBox firstError;
    private CheckBox secondError;
    private CheckBox serialCheck;

    private Button blueButton;
    private Button yellowButton;

    private Button greenButton;
    private Button redButton;

    private ImageView solution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module4);
        linkComponents();
        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "BLUE", Toast.LENGTH_SHORT).show();
                setBlueSolution();
                resetImageStateAfterDelay(solution);

            }
        });

        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "YELLOW", Toast.LENGTH_SHORT).show();
                setYellowSolution();
                resetImageStateAfterDelay(solution);
            }
        });

        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "GREEN", Toast.LENGTH_SHORT).show();
                setGreenSolution();
                resetImageStateAfterDelay(solution);

            }
        });

        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "RED", Toast.LENGTH_SHORT).show();
                setRedSolution();
                resetImageStateAfterDelay(solution);
            }
        });
        secondError.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    firstError.setChecked(true);
                } else {
                    firstError.setEnabled(true);
                }
            }
        });

        firstError.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (secondError.isChecked()) {
                    firstError.setChecked(true);
                    firstError.setEnabled(false);
                } else {
                    firstError.setEnabled(true);
                }
            }
        });


        serialCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                }
            }
        });
    }


    private void resetImageStateAfterDelay(ImageView solution) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                solution.setImageResource(R.drawable.simon_wireframe);
            }
        }, 700);
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
                        Intent i = new Intent(Module4.this, Module3.class);
                        startActivity(i);
                    }
                    if(x1>x2){
                        Intent i = new Intent(Module4.this, Module5.class);
                        startActivity(i);
                    }
                    break;
            }
            return false;
        }

    public void setRedSolution(){
        int errors =0;
        if(firstError.isChecked())
            errors=1;
        if(secondError.isChecked())
            errors =2;

        if(serialCheck.isChecked()) {
            switch (errors) {
                case 0:
                    solution.setImageResource(R.drawable.blue);
                    break;
                case 1:
                    solution.setImageResource(R.drawable.yellow);
                    break;
                case 2:
                    solution.setImageResource(R.drawable.green);
                    break;
            }
        }
            if(!serialCheck.isChecked()){
                switch (errors){
                    case 0:
                        solution.setImageResource(R.drawable.blue);
                        break;
                    case 1:
                        solution.setImageResource(R.drawable.red);
                        break;
                    case 2:
                        solution.setImageResource(R.drawable.yellow);
                        break;
                }
            }
        }

    public void setBlueSolution(){
        int errors =0;
        if(firstError.isChecked())
            errors=1;
        if(secondError.isChecked())
            errors =2;

        if(serialCheck.isChecked()) {
            switch (errors) {
                case 0:
                    solution.setImageResource(R.drawable.red);
                    break;
                case 1:
                    solution.setImageResource(R.drawable.green);
                    break;
                case 2:
                    solution.setImageResource(R.drawable.red);
                    break;
            }
        }
            if(!serialCheck.isChecked()){
                switch (errors){
                    case 0:
                        solution.setImageResource(R.drawable.yellow);
                        break;
                    case 1:
                        solution.setImageResource(R.drawable.blue);
                        break;
                    case 2:
                        solution.setImageResource(R.drawable.green);
                        break;
                }
            }
        }

    public void setGreenSolution(){
        int errors =0;
        if(firstError.isChecked())
            errors=1;
        if(secondError.isChecked())
            errors =2;

        if(serialCheck.isChecked()) {
            switch (errors) {
                case 0:
                    solution.setImageResource(R.drawable.yellow);
                    break;
                case 1:
                    solution.setImageResource(R.drawable.blue);
                    break;
                case 2:
                    solution.setImageResource(R.drawable.yellow);
                    break;
            }
        }
            if(!serialCheck.isChecked()){
                switch (errors){
                    case 0:
                        solution.setImageResource(R.drawable.green);
                        break;
                    case 1:
                        solution.setImageResource(R.drawable.yellow);
                        break;
                    case 2:
                        solution.setImageResource(R.drawable.blue);
                        break;
                }
            }
        }

    public void setYellowSolution(){
        int errors =0;
        if(firstError.isChecked())
            errors=1;
        if(secondError.isChecked())
            errors =2;

        if(serialCheck.isChecked()) {
            switch (errors) {
                case 0:
                    solution.setImageResource(R.drawable.green);
                    break;
                case 1:
                    solution.setImageResource(R.drawable.red);
                    break;
                case 2:
                    solution.setImageResource(R.drawable.blue);
                    break;
            }
        }
            if(!serialCheck.isChecked()){
                switch (errors){
                    case 0:
                        solution.setImageResource(R.drawable.red);
                        break;
                    case 1:
                        solution.setImageResource(R.drawable.green);
                        break;
                    case 2:
                        solution.setImageResource(R.drawable.red);
                        break;
                }
            }
        }


    public void linkComponents() {
        firstError = findViewById(R.id.error1);
        secondError = findViewById(R.id.error2);
        serialCheck = findViewById(R.id.additional);
        blueButton = findViewById(R.id.blue);
        yellowButton = findViewById(R.id.yellow);
        greenButton = findViewById(R.id.green);
        redButton = findViewById(R.id.red);
        solution = findViewById(R.id.imageView);
    }
}
