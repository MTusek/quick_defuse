package com.example.quickdefuse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Module10 extends AppCompatActivity {

    private int c1, c2;

    private TextView col1, col2;
    private ImageButton nextC1, nextC2;
    private ImageButton previousC1, previousC2;

    private ImageView solution;
    private float x1, x2, y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module10);
        linkComponents();
        setSolution();

        nextC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNextIndicator(1);
                setSolution();
            }
        });

        nextC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNextIndicator(2);
                setSolution();
            }
        });

        previousC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPreviousIndicator(2);
                setSolution();
            }
        });

        previousC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPreviousIndicator(1);
                setSolution();
            }
        });
    }

    private void linkComponents() {
        nextC1 = findViewById(R.id.nextNumber1);
        nextC2 = findViewById(R.id.nextNumber2);

        previousC1 = findViewById(R.id.previousNumber1);
        previousC2 = findViewById(R.id.previousNumber2);

        col1 = findViewById(R.id.textNumber1);
        col2 = findViewById(R.id.textNumber2);

        solution = findViewById(R.id.imageSolution);
        c1=1;
        c2=1;
    }

    private void setNextIndicator(int cID) {
        if (cID == 1) {
            c1++;
            if (c1 > 6) {
                c1 = 1;
            }
            col1.setText(""+c1);
        }
        if (cID == 2) {
            c2++;
            if (c2 > 6) {
                c2 = 1;
            }
            col2.setText(""+c2);
        }
    }
    private void setPreviousIndicator(int cID) {
        if (cID == 1) {
            c1--;
            if (c1 < 1) {
                c1 = 6;
            }
            col1.setText(""+c1);
        }
        if (cID == 2) {
            c2--;
            if (c2 < 1) {
                c2 = 6;
            }
            col2.setText(""+c2);
        }
    }

    private void setSolution() {
        solution.setImageResource(R.drawable.maze_empty);
        if (c1 == 1 && c2 == 1) {
            solution.setImageResource(R.drawable.maze11);
        }
        if (c1 == 1 && c2 == 3) {
            solution.setImageResource(R.drawable.maze13);
        }
        if (c1 == 1 && c2 == 6) {
            solution.setImageResource(R.drawable.maze16);
        }
        if (c1 == 2 && c2 == 2) {
            solution.setImageResource(R.drawable.maze22);
        }

        if (c1 == 2 && c2 == 5) {
            solution.setImageResource(R.drawable.maze25);
        }
        if (c1 == 3 && c2 == 4) {
            solution.setImageResource(R.drawable.maze34);
        }
        if (c1 == 3 && c2 == 5) {
            solution.setImageResource(R.drawable.maze35);
        }
        if (c1 == 4 && c2 == 5) {
            solution.setImageResource(R.drawable.maze45);
        }
        if (c1 == 4 && c2 == 6) {
            solution.setImageResource(R.drawable.maze46);
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
                    Intent i = new Intent(Module10.this, Module9.class);
                    startActivity(i);
                }
                if(x1>x2){
                    Intent i = new Intent(Module10.this, Module11.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}