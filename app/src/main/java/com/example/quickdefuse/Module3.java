package com.example.quickdefuse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Module3 extends AppCompatActivity {

    private float x1, x2, y1, y2;
    private ImageButton nextImage;
    private ImageButton previousImage;

    private ImageView solution;
    private int selectedImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module3);
        linkComponents();

        nextImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveImageForwards();
            }
        });

        previousImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveImageBackwards();
            }
        });
    }


    public void linkComponents() {
        solution = findViewById(R.id.keypad);
        nextImage = findViewById(R.id.nextKeypad);
        previousImage = findViewById(R.id.previousKeypad);
        selectedImage = 3;
    }

    public void moveImageForwards() {
        selectedImage++;
        if (selectedImage > 5) {
            selectedImage = 0;
        }
        setSolution();
    }

    public void moveImageBackwards() {
        selectedImage--;
        if(selectedImage<0){
            selectedImage=5;
        }
        setSolution();
    }

    public void setSolution(){
        switch (selectedImage){
            case 0:
                solution.setImageResource(R.drawable.row1);
                break;
            case 1:
                solution.setImageResource(R.drawable.row2);
                break;
            case 2:
                solution.setImageResource(R.drawable.row3);
                break;
            case 3:
                solution.setImageResource(R.drawable.row4);
                break;
            case 4:
                solution.setImageResource(R.drawable.row5);
            case 5:
                solution.setImageResource(R.drawable.row6);
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
                    Intent i = new Intent(Module3.this, Module2.class);
                    startActivity(i);
                }
                if(x1>x2){
                    Intent i = new Intent(Module3.this, Module4.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }


}