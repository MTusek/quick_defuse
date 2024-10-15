package com.example.quickdefuse;

import static com.google.android.material.internal.ContextUtils.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private float x1, x2, y1, y2;
    private TextView wiresNumber;
    private TextView solution;

    private ImageButton imageButtonNext;
    private ImageButton imageButtonPrevious;

    private CheckBox islastDigitEven;

    //1. red žica
    private CheckBox wire1Red;
    private CheckBox wire1White;
    private CheckBox wire1Yellow;
    private CheckBox wire1Black;
    private CheckBox wire1Blue;

    //2. red žica
    private CheckBox wire2Red;
    private CheckBox wire2White;
    private CheckBox wire2Yellow;
    private CheckBox wire2Black;
    private CheckBox wire2Blue;

    //3. red žica
    private CheckBox wire3Red;
    private CheckBox wire3White;
    private CheckBox wire3Yellow;
    private CheckBox wire3Black;
    private CheckBox wire3Blue;

    //zadnja 3 reda žica, temelji se na vidljivosti

    //4. red žica
    private CheckBox wire4Red;
    private CheckBox wire4White;
    private CheckBox wire4Yellow;
    private CheckBox wire4Black;
    private CheckBox wire4Blue;
    private TextView wire4Text;

    //5.red žica
    private CheckBox wire5Red;
    private CheckBox wire5White;
    private CheckBox wire5Yellow;
    private CheckBox wire5Black;
    private CheckBox wire5Blue;
    private TextView wire5Text;

    //6.red žica
    private CheckBox wire6Red;
    private CheckBox wire6White;
    private CheckBox wire6Yellow;
    private CheckBox wire6Black;
    private CheckBox wire6Blue;
    private TextView wire6Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkComponents();
        setVisibleComponents();
        setWires();
        solution.setVisibility(View.INVISIBLE);
        imageButtonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reduceWiresNumber();
            }
        });

        imageButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addWiresNumber();
            }
        });

        islastDigitEven.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setSolution();
                }
            }
        });


        //1. red žica
        wire1Red.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire1Black.setChecked(false);
                    wire1Blue.setChecked(false);
                    wire1Yellow.setChecked(false);
                    wire1White.setChecked(false);
                    setSolution();
                }
            }
        });
        wire1Blue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire1Black.setChecked(false);
                    wire1Red.setChecked(false);
                    wire1Yellow.setChecked(false);
                    wire1White.setChecked(false);
                    setSolution();
                }
            }
        });

        wire1Black.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire1Red.setChecked(false);
                    wire1Blue.setChecked(false);
                    wire1Yellow.setChecked(false);
                    wire1White.setChecked(false);
                    setSolution();

                }
            }
        });

        wire1Yellow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire1Red.setChecked(false);
                    wire1Blue.setChecked(false);
                    wire1Black.setChecked(false);
                    wire1White.setChecked(false);
                    setSolution();

                }
            }
        });
        wire1White.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire1Red.setChecked(false);
                    wire1Blue.setChecked(false);
                    wire1Black.setChecked(false);
                    wire1Yellow.setChecked(false);
                    setSolution();

                }
            }
        });


        //2. red žica
        wire2Red.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire2Black.setChecked(false);
                    wire2Blue.setChecked(false);
                    wire2Yellow.setChecked(false);
                    wire2White.setChecked(false);
                    setSolution();

                }
            }
        });
        wire2Blue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire2Black.setChecked(false);
                    wire2Red.setChecked(false);
                    wire2Yellow.setChecked(false);
                    wire2White.setChecked(false);
                    setSolution();

                }
            }
        });

        wire2Black.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire2Red.setChecked(false);
                    wire2Blue.setChecked(false);
                    wire2Yellow.setChecked(false);
                    wire2White.setChecked(false);
                    setSolution();

                }
            }
        });

        wire2Yellow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire2Red.setChecked(false);
                    wire2Blue.setChecked(false);
                    wire2Black.setChecked(false);
                    wire2White.setChecked(false);
                    setSolution();

                }
            }
        });

        wire2White.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire2Red.setChecked(false);
                    wire2Blue.setChecked(false);
                    wire2Black.setChecked(false);
                    wire2Yellow.setChecked(false);
                    setSolution();

                }
            }
        });

        //3. red žica
        wire3Red.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire3Black.setChecked(false);
                    wire3Blue.setChecked(false);
                    wire3Yellow.setChecked(false);
                    wire3White.setChecked(false);
                    setSolution();

                }
            }
        });
        wire3Blue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire3Black.setChecked(false);
                    wire3Red.setChecked(false);
                    wire3Yellow.setChecked(false);
                    wire3White.setChecked(false);
                    setSolution();

                }
            }
        });

        wire3Black.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire3Red.setChecked(false);
                    wire3Blue.setChecked(false);
                    wire3Yellow.setChecked(false);
                    wire3White.setChecked(false);
                    setSolution();

                }
            }
        });

        wire3Yellow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire3Red.setChecked(false);
                    wire3Blue.setChecked(false);
                    wire3Black.setChecked(false);
                    wire3White.setChecked(false);
                    setSolution();

                }
            }
        });

        wire3White.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire3Red.setChecked(false);
                    wire3Blue.setChecked(false);
                    wire3Black.setChecked(false);
                    wire3Yellow.setChecked(false);
                    setSolution();

                }
            }
        });

        //4. red žica
        wire4Red.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire4Black.setChecked(false);
                    wire4Blue.setChecked(false);
                    wire4Yellow.setChecked(false);
                    wire4White.setChecked(false);
                    setSolution();

                }
            }
        });
        wire4Blue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire4Black.setChecked(false);
                    wire4Red.setChecked(false);
                    wire4Yellow.setChecked(false);
                    wire4White.setChecked(false);
                    setSolution();

                }
            }
        });

        wire4Black.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire4Red.setChecked(false);
                    wire4Blue.setChecked(false);
                    wire4Yellow.setChecked(false);
                    wire4White.setChecked(false);
                    setSolution();

                }
            }
        });

        wire4Yellow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire4Red.setChecked(false);
                    wire4Blue.setChecked(false);
                    wire4Black.setChecked(false);
                    wire4White.setChecked(false);
                    setSolution();

                }
            }
        });

        wire4White.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire4Red.setChecked(false);
                    wire4Blue.setChecked(false);
                    wire4Black.setChecked(false);
                    wire4Yellow.setChecked(false);
                    setSolution();

                }
            }
        });

        //5. red žica
        wire5Red.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire5Black.setChecked(false);
                    wire5Blue.setChecked(false);
                    wire5Yellow.setChecked(false);
                    wire5White.setChecked(false);
                    setSolution();

                }
            }
        });
        wire5Blue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire5Black.setChecked(false);
                    wire5Red.setChecked(false);
                    wire5Yellow.setChecked(false);
                    wire5White.setChecked(false);
                    setSolution();

                }
            }
        });

        wire5Black.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire5Red.setChecked(false);
                    wire5Blue.setChecked(false);
                    wire5Yellow.setChecked(false);
                    wire5White.setChecked(false);
                    setSolution();

                }
            }
        });

        wire5Yellow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire5Red.setChecked(false);
                    wire5Blue.setChecked(false);
                    wire5Black.setChecked(false);
                    wire5White.setChecked(false);
                    setSolution();

                }
            }
        });

        wire5White.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire5Red.setChecked(false);
                    wire5Blue.setChecked(false);
                    wire5Black.setChecked(false);
                    wire5Yellow.setChecked(false);
                    setSolution();

                }
            }
        });

        //6. red žica
        wire6Red.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire6Black.setChecked(false);
                    wire6Blue.setChecked(false);
                    wire6Yellow.setChecked(false);
                    wire6White.setChecked(false);
                    setSolution();

                }
            }
        });
        wire6Blue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire6Black.setChecked(false);
                    wire6Red.setChecked(false);
                    wire6Yellow.setChecked(false);
                    wire6White.setChecked(false);
                    setSolution();

                }
            }
        });

        wire6Black.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire6Red.setChecked(false);
                    wire6Blue.setChecked(false);
                    wire6Yellow.setChecked(false);
                    wire6White.setChecked(false);
                    setSolution();

                }
            }
        });

        wire6Yellow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire6Red.setChecked(false);
                    wire6Blue.setChecked(false);
                    wire6Black.setChecked(false);
                    wire6White.setChecked(false);
                    setSolution();

                }
            }
        });

        wire6White.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wire6Red.setChecked(false);
                    wire6Blue.setChecked(false);
                    wire6Black.setChecked(false);
                    wire6Yellow.setChecked(false);
                    setSolution();

                }
            }
        });

    }

    //Swipe funkcija za novi modul
    public boolean onTouchEvent(MotionEvent touchevent){
        switch(touchevent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1= touchevent.getX();
                y1= touchevent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2= touchevent.getX();
                y2= touchevent.getY();
                if(x1>x2){
                    Intent i = new Intent(MainActivity.this, Module2.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }

    public void addWiresNumber() {
        int wires = Integer.parseInt(wiresNumber.getText().toString());
        wires++;
        if (wires > 6)
            wires = 3;
        wiresNumber.setText("" + wires);
        setVisibleComponents();
        setSolution();
    }

    public void reduceWiresNumber() {
        int wires = Integer.parseInt(wiresNumber.getText().toString());
        wires--;
        if (wires < 3)
            wires = 6;
        wiresNumber.setText("" + wires);
        setVisibleComponents();
        setSolution();
    }

    public void setVisibleComponents() {
        int wires = Integer.parseInt(wiresNumber.getText().toString());
        switch (wires) {
            case 3:
                //4.red žica
                wire4Text.setVisibility(View.GONE);
                wire4Yellow.setVisibility(View.GONE);
                wire4Red.setVisibility(View.GONE);
                wire4Blue.setVisibility(View.GONE);
                wire4Black.setVisibility(View.GONE);
                wire4White.setVisibility(View.GONE);

                //5. red žica
                wire5Text.setVisibility(View.GONE);
                wire5Yellow.setVisibility(View.GONE);
                wire5Red.setVisibility(View.GONE);
                wire5Blue.setVisibility(View.GONE);
                wire5Black.setVisibility(View.GONE);
                wire5White.setVisibility(View.GONE);

                //6.red žica
                wire6Text.setVisibility(View.GONE);
                wire6Yellow.setVisibility(View.GONE);
                wire6Red.setVisibility(View.GONE);
                wire6Blue.setVisibility(View.GONE);
                wire6Black.setVisibility(View.GONE);
                wire6White.setVisibility(View.GONE);

                break;
            case 4:
                //4.red žica
                wire4Text.setVisibility(View.VISIBLE);
                wire4Yellow.setVisibility(View.VISIBLE);
                wire4Red.setVisibility(View.VISIBLE);
                wire4Blue.setVisibility(View.VISIBLE);
                wire4Black.setVisibility(View.VISIBLE);
                wire4White.setVisibility(View.VISIBLE);

                //5. red žica
                wire5Text.setVisibility(View.GONE);
                wire5Yellow.setVisibility(View.GONE);
                wire5Red.setVisibility(View.GONE);
                wire5Blue.setVisibility(View.GONE);
                wire5Black.setVisibility(View.GONE);
                wire5White.setVisibility(View.GONE);

                //6.red žica
                wire6Text.setVisibility(View.GONE);
                wire6Yellow.setVisibility(View.GONE);
                wire6Red.setVisibility(View.GONE);
                wire6Blue.setVisibility(View.GONE);
                wire6Black.setVisibility(View.GONE);
                wire6White.setVisibility(View.GONE);

                break;
            case 5:
                //4.red žica
                wire4Text.setVisibility(View.VISIBLE);
                wire4Yellow.setVisibility(View.VISIBLE);
                wire4Red.setVisibility(View.VISIBLE);
                wire4Blue.setVisibility(View.VISIBLE);
                wire4Black.setVisibility(View.VISIBLE);
                wire4White.setVisibility(View.VISIBLE);

                //5. red žica
                wire5Text.setVisibility(View.VISIBLE);
                wire5Yellow.setVisibility(View.VISIBLE);
                wire5Red.setVisibility(View.VISIBLE);
                wire5Blue.setVisibility(View.VISIBLE);
                wire5Black.setVisibility(View.VISIBLE);
                wire5White.setVisibility(View.VISIBLE);

                //6. red žica
                wire6Text.setVisibility(View.GONE);
                wire6Yellow.setVisibility(View.GONE);
                wire6Red.setVisibility(View.GONE);
                wire6Blue.setVisibility(View.GONE);
                wire6Black.setVisibility(View.GONE);
                wire6White.setVisibility(View.GONE);
                break;
            case 6:
                //4.red žica
                wire4Text.setVisibility(View.VISIBLE);
                wire4Yellow.setVisibility(View.VISIBLE);
                wire4Red.setVisibility(View.VISIBLE);
                wire4Blue.setVisibility(View.VISIBLE);
                wire4Black.setVisibility(View.VISIBLE);
                wire4White.setVisibility(View.VISIBLE);

                //5. red žica
                wire5Text.setVisibility(View.VISIBLE);
                wire5Yellow.setVisibility(View.VISIBLE);
                wire5Red.setVisibility(View.VISIBLE);
                wire5Blue.setVisibility(View.VISIBLE);
                wire5Black.setVisibility(View.VISIBLE);
                wire5White.setVisibility(View.VISIBLE);

                //6. red žica
                wire6Text.setVisibility(View.VISIBLE);
                wire6Yellow.setVisibility(View.VISIBLE);
                wire6Red.setVisibility(View.VISIBLE);
                wire6Blue.setVisibility(View.VISIBLE);
                wire6Black.setVisibility(View.VISIBLE);
                wire6White.setVisibility(View.VISIBLE);
                break;
        }
    }

    public void linkComponents() {
        imageButtonNext = findViewById(R.id.addWireCount);
        imageButtonPrevious = findViewById(R.id.reduceWireCount);
        wiresNumber = findViewById(R.id.text_wires_number);
        solution = findViewById(R.id.text_solve);
        wire4Text = findViewById(R.id.textView6);
        wire5Text = findViewById(R.id.textView3);
        wire6Text = findViewById(R.id.textView7);
        islastDigitEven = findViewById(R.id.additional);

        //1. red žica
        wire1Black = findViewById(R.id.checkBox4Row1);
        wire1Blue = findViewById(R.id.checkBox2Row1);
        wire1Red = findViewById(R.id.checkBoxRow1);
        wire1White = findViewById(R.id.checkBox1Row1);
        wire1Yellow = findViewById(R.id.checkBox3Row1);

        //2.red žica
        wire2Black = findViewById(R.id.checkBox4Row2);
        wire2Blue = findViewById(R.id.checkBox2Row2);
        wire2Red = findViewById(R.id.checkBoxRow2);
        wire2White = findViewById(R.id.checkBox1Row2);
        wire2Yellow = findViewById(R.id.checkBox3Row2);

        //3.red žica
        wire3Black = findViewById(R.id.checkBox4Row3);
        wire3Blue = findViewById(R.id.checkBox2Row3);
        wire3Red = findViewById(R.id.checkBoxRow3);
        wire3White = findViewById(R.id.checkBox1Row3);
        wire3Yellow = findViewById(R.id.checkBox3Row3);

        //4. red žica
        wire4Black = findViewById(R.id.checkBox4Row4);
        wire4Blue = findViewById(R.id.checkBox2Row4);
        wire4Red = findViewById(R.id.checkBoxRow4);
        wire4White = findViewById(R.id.checkBox1Row4);
        wire4Yellow = findViewById(R.id.checkBox3Row4);

        //5. red žica
        wire5Black = findViewById(R.id.checkBox4Row5);
        wire5Blue = findViewById(R.id.checkBox2Row5);
        wire5Red = findViewById(R.id.checkBoxRow5);
        wire5White = findViewById(R.id.checkBox1Row5);
        wire5Yellow = findViewById(R.id.checkBox3Row5);

        //6. red žica
        wire6Black = findViewById(R.id.checkBox4Row6);
        wire6Blue = findViewById(R.id.checkBox2Row6);
        wire6Red = findViewById(R.id.checkBoxRow6);
        wire6White = findViewById(R.id.checkBox1Row6);
        wire6Yellow = findViewById(R.id.checkBox3Row6);
    }

    public void setWires() {

        //1. red žica
        while (wire1Red.isChecked()) {
            wire1Blue.setChecked(false);
            wire1Black.setChecked(false);
            wire1White.setChecked(false);
            wire1Yellow.setChecked(false);
        }
        while (wire1Blue.isChecked()) {
            wire1Red.setChecked(false);
            wire1Yellow.setChecked(false);
            wire1Black.setChecked(false);
            wire1White.setChecked(false);
        }
    }

    public void setSolution() {
        int wires = Integer.parseInt(wiresNumber.getText().toString());

        int redWireCounter = 0;
        int blueWireCounter = 0;
        int yellowWireCounter = 0;
        int blackWireCounter = 0;
        int whiteWireCounter =0;

        if(wire1White.isChecked()){
            whiteWireCounter++;
        }
        if(wire2White.isChecked()){
            whiteWireCounter++;
        }
        if(wire3White.isChecked()){
            whiteWireCounter++;
        }
        if(wire4White.isChecked()){
            whiteWireCounter++;
        }
        if(wire5White.isChecked()){
            whiteWireCounter++;
        }
        if(wire6White.isChecked()){
            whiteWireCounter++;
        }

        if (wire1Black.isChecked()) {
            blackWireCounter++;
        }
        if (wire2Black.isChecked()) {
            blackWireCounter++;
        }
        if (wire3Black.isChecked()) {
            blackWireCounter++;
        }
        if (wire4Black.isChecked()) {
            blackWireCounter++;
        }
        if (wire5Black.isChecked()) {
            blackWireCounter++;
        }
        if (wire6Black.isChecked()) {
            blackWireCounter++;
        }
        if (wire1Yellow.isChecked()) {
            yellowWireCounter++;
        }
        if (wire2Yellow.isChecked()) {
            yellowWireCounter++;
        }
        if (wire3Yellow.isChecked()) {
            yellowWireCounter++;
        }
        if (wire4Yellow.isChecked()) {
            yellowWireCounter++;
        }
        if (wire5Yellow.isChecked()) {
            yellowWireCounter++;
        }
        if (wire6Yellow.isChecked()) {
            yellowWireCounter++;
        }
        if (wire1Blue.isChecked()) {
            blueWireCounter++;
        }
        if (wire2Blue.isChecked()) {
            blueWireCounter++;
        }
        if (wire3Blue.isChecked()) {
            blueWireCounter++;
        }
        if (wire4Blue.isChecked()) {
            blueWireCounter++;
        }
        if (wire5Blue.isChecked()) {
            blueWireCounter++;
        }
        if (wire1Red.isChecked()) {
            redWireCounter++;
        }
        if (wire2Red.isChecked()) {
            redWireCounter++;
        }
        if (wire3Red.isChecked()) {
            redWireCounter++;
        }
        if (wire4Red.isChecked()) {
            redWireCounter++;
        }
        if (wire5Red.isChecked()) {
            redWireCounter++;
        }
        if(wire6Red.isChecked()){
            redWireCounter++;
        }

        //Provjere sa 3 žice
        if (wires == 3) {
            if (!(wire1Red.isChecked()) && !(wire2Red.isChecked()) && !(wire3Red.isChecked())) {
                solution.setText("Cut wire number 2");
                solution.setVisibility(View.VISIBLE);
            } else if (wire3White.isChecked()) {
                solution.setText("Cut wire number 3");
                solution.setVisibility(View.VISIBLE);
            } else if ((wire3Blue.isChecked() && wire2Blue.isChecked()) || (wire1Blue.isChecked() && wire3Blue.isChecked())) {
                solution.setText("Cut wire number 3");
                solution.setVisibility(View.VISIBLE);
            } else if (wire2Blue.isChecked() && wire1Blue.isChecked()) {
                solution.setText("Cut wire number 2");
                solution.setVisibility(View.VISIBLE);
            } else {
                solution.setText("Cut wire number 3");
                solution.setVisibility(View.VISIBLE);
            }
        }

        //Provjere sa 4 žice
        if (wires == 4) {
            if (redWireCounter > 1 && !(islastDigitEven.isChecked())) {
                if (wire4Red.isChecked()) {
                    solution.setText("Cut wire number 4");
                } else if (wire3Red.isChecked()) {
                    solution.setText("Cut wire number 3");
                } else if (wire2Red.isChecked()) {
                    solution.setText("Cut wire number 2");
                }
                solution.setVisibility(View.VISIBLE);
            } else if (wire4Yellow.isChecked() && redWireCounter == 0) {
                solution.setText("Cut wire number 1");
                solution.setVisibility(View.VISIBLE);
            } else if (blueWireCounter == 1) {
                solution.setText("Cut wire number 1");
                solution.setVisibility(View.VISIBLE);
            } else if (yellowWireCounter > 1) {
                solution.setText("Cut wire number 4");
                solution.setVisibility(View.VISIBLE);
            } else {
                solution.setText("Cut wire number 2");
                solution.setVisibility(View.VISIBLE);
            }
        }

        //Provjere sa 5 žica
        if (wires == 5) {
            if (wire5Black.isChecked() && !(islastDigitEven.isChecked())) {
                solution.setText("Cut wire number 4");
                solution.setVisibility(View.VISIBLE);
            } else if (redWireCounter == 1 && yellowWireCounter > 1) {
                solution.setText("Cut wire number 1");
                solution.setVisibility(View.VISIBLE);
            } else if (blackWireCounter == 0) {
                solution.setText("Cut wire number 2");
                solution.setVisibility(View.VISIBLE);
            } else {
                solution.setText("Cut wire number 1");
            }
        }

        //Provjere sa 6 žica
        if (wires == 6) {
            if (yellowWireCounter == 0 && !(islastDigitEven.isChecked())) {
                solution.setText("Cut wire number 3");
                solution.setVisibility(View.VISIBLE);
            } else if (yellowWireCounter == 1 && whiteWireCounter>1) {
                solution.setText("Cut wire number 4");
                solution.setVisibility(View.VISIBLE);
            } else if (redWireCounter == 0) {
                solution.setText("Cut wire number 6");
                solution.setVisibility(View.VISIBLE);
            }
            else {
                solution.setText("Cut wire number 4");
                solution.setVisibility(View.VISIBLE);
            }
        }
    }
}