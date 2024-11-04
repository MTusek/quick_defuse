package com.example.quickdefuse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Module8 extends AppCompatActivity {

    private ImageButton nextWire, previousWire;
    private ImageView wire;

    private TextView solution;
    private CheckBox star, led;

    private int wireCounter;

    private float x1, x2, y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module8);
        linkComponents();

        star.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setSolution();
                }
                if(!isChecked){
                    setSolution();
                }
            }
        });
        led.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setSolution();
                }
                if(!isChecked){
                    setSolution();
                }
            }
        });

        nextWire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNextWire();
                setSolution();
            }
        });

        previousWire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPreviousWire();
                setSolution();
            }
        });
    }

    private void linkComponents(){
        wire = findViewById(R.id.imageView4);
        nextWire = findViewById(R.id.nextWire);
        previousWire = findViewById(R.id.previousWire);
        star = findViewById(R.id.checkBoxStar);
        led = findViewById(R.id.checkBoxLED);
        solution = findViewById(R.id.textFinal);
        wireCounter=3;
        setWire();


        wire.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        float scaleX = 5.0f;
        float scaleY = 10.0f;
        matrix.postScale(scaleX, scaleY);

        float translateX = (wire.getWidth() - wire.getDrawable().getIntrinsicWidth() * scaleX) / 2;
        float translateY = (wire.getHeight() - wire.getDrawable().getIntrinsicHeight() * scaleY) / 2;
        matrix.postTranslate(translateX, translateY);
        wire.setImageMatrix(matrix);
    }

    private void setNextWire(){
        wireCounter++;
        if(wireCounter>5){
            wireCounter=0;
        }
        setWire();
    }

    private void setPreviousWire(){
        wireCounter--;
        if(wireCounter<0){
            wireCounter =5;
        }
        setWire();
    }

    private void setWire(){
        switch (wireCounter){
            case 0:
                wire.setImageResource(R.drawable.wire_blue);
                break;
            case 1:
                wire.setImageResource(R.drawable.wire_red);
                break;
            case 2:
                wire.setImageResource(R.drawable.wire_red_blue);
                break;
            case 3:
                wire.setImageResource(R.drawable.wire_white);
                break;
            case 4:
                wire.setImageResource(R.drawable.wire_white_red);
                break;
            case 5:
                wire.setImageResource(R.drawable.wire_white_blue);
        }
    }
    private void setSolution(){

        //This function uses the following logic
        //If the wire has the blue color, add B
        //If the wire has the red color, add R
        //If the wire has a star, add S
        //If the wire has a lit Led, add L
        //
        //Example: Wire is blue, has star and LED. Your wire is "BSL"
        //The order of things is B, R, S, L.
        //
        //Wire is plain white: Cut
        if(wireCounter==3 &&!(star.isChecked() || led.isChecked())){
            solution.setText("Cut the wire");
        }
        //B - Cut if last number on SN is even
        if((wireCounter==0 || wireCounter==5) &&!(star.isChecked() || led.isChecked())){
            solution.setText("Cut the wire if the last digit of serial# is even");
        }
        //BR - Cut if last number on SN is even
        if(wireCounter==2 &&!(star.isChecked() || led.isChecked())){
            solution.setText("Cut the wire if the last digit of serial# is even");
        }
        //BS - Do NOT Cut
        if((wireCounter==0 || wireCounter==5) && star.isChecked() && !(led.isChecked())){
            solution.setText("Don't cut the wire");
        }
        //BL - Cut if there is a Parallel Port
        if((wireCounter==0 || wireCounter==5) && led.isChecked() && !(star.isChecked())){
            solution.setText("Cut the wire if the bomb has a parallel port");
        }
        //BRS - Cut if there is a Parallel Port
        if(wireCounter==2 && star.isChecked() && !(led.isChecked())){
            solution.setText("Cut the wire if the bomb has a parallel port");
        }
        //BRL - Cut if last number on SN is even
        if(wireCounter==2 && !(star.isChecked()) && led.isChecked()){
            solution.setText("Cut the wire if the last digit of serial# is even");
        }
        //BSL - Cut if there is a Parallel Port
        if((wireCounter==0 || wireCounter==5) && star.isChecked() && led.isChecked()){
            solution.setText("Cut the wire if the bomb has a parallel port");
        }
        //BRSL - Do NOT Cut
        if(wireCounter==2 && star.isChecked() && led.isChecked()){
            solution.setText("Don't cut the wire");
        }
        //R - Cut if last number on SN is even
        if((wireCounter==1 || wireCounter==4) && !(star.isChecked()) && !(led.isChecked())) {
            solution.setText("Cut the wire if the last digit of serial# is even");
        }
        //RS - Cut it
        if((wireCounter==1 || wireCounter==4) && star.isChecked() && !(led.isChecked())) {
            solution.setText("Cut the wire");
        }
        //RL - Cut if there is 2+ batteries
        if((wireCounter==1 || wireCounter==4) && !(star.isChecked()) && (led.isChecked())) {
            solution.setText("Cut the wire if there is 2+ batteries");
        }
        //RSL - Cut if there is 2+ batteries
        if((wireCounter==1 || wireCounter == 4) && star.isChecked() && led.isChecked()){
            solution.setText("Cut the wire if there is 2+ batteries");
        }
        //S - Cut it
        if(star.isChecked() && !(led.isChecked())){
            solution.setText("Cut the wire");
        }
        //SL - Cut if there is 2+ batteries
        if(star.isChecked() && led.isChecked()) {
            solution.setText("Cut the wire if there is 2+ batteries");
        }
        //L - Do NOT Cut
        if(led.isChecked() && !(star.isChecked())){
            solution.setText("Don't cut the wire");
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
                    Intent i = new Intent(Module8.this, Module7.class);
                    startActivity(i);
                }
                if(x1>x2){
                    Intent i = new Intent(Module8.this, Module9.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}