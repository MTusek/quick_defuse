package com.example.quickdefuse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Module5 extends AppCompatActivity {

    private float x1, x2, y1, y2;
    private ImageView table;
    private TextView textViewFirst;
    private TextView solution;

    private String []s_ready;
    private String []s_first;

    private String []s_no;
    private String []s_blank;

    private String[]s_nothing;
    private String[]s_yes;
    private String[]s_what;

    private String []s_uhhh;
    private String[]s_left;

    private String []s_right;

    private String []s_middle;
    private String[]s_okay;
    private String[]s_wait;
    private  String []s_press;
    private String []s_you;

    private String[]s_youare;

    private String[]s_your;

    private String[]s_youre;
    private String[]s_ur;
    private String[]s_u;
    private String[]s_uhhuh;
    private String[]s_uhuh;
    private String[]s_what7;
    private String[]s_done;
    private String[]s_next;
    private String[]s_hold;
    private String[]s_sure;
    private String[]s_like;

    private ImageButton previousTable;
    private ImageButton nextTable;

    private ImageButton nextWord;
    private ImageButton previousWord;

    private int selectedImage;
    private int selectedWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module5);
        linkComponents();
        setSolutions();

        nextTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextTable();
            }
        });
        previousTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previousTable();
            }
        });

        nextWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextWord();
            }
        });

        previousWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previousWord();
            }
        });
    }
    private Handler handler = new Handler();
    private Runnable[] runnables;
    private boolean isRunning = false;
    private void displaySolutionWithDelay(final String[] words) {
        if (isRunning) {
            handler.removeCallbacksAndMessages(null);  // Stop previous tasks
        }
        solution.setText("");

        runnables = new Runnable[words.length];


        for (int i = 0; i < words.length; i++) {
            int index = i;
            runnables[i] = new Runnable() {
                    @Override
                    public void run () {
                        solution.setText(words[index]);
                    }
                };
            handler.postDelayed(runnables[i],700*i );
            }
        isRunning = true;
        }

    private void linkComponents(){
        table = findViewById(R.id.word);
        textViewFirst = findViewById(R.id.texts);
        solution = findViewById(R.id.textSolution);
        previousTable = findViewById(R.id.previousTable);
        nextTable = findViewById(R.id.nextTable);
        previousWord = findViewById(R.id.previousWord);
        nextWord = findViewById(R.id.nextWord);
        selectedImage = 0;
        selectedWord = 0;
    }

    private void setSolutions(){
       s_ready = new String[] {"YES", "OKAY", "WHAT", "MIDDLE", "LEFT", "PRESS", "RIGHT", "BLANK", "READY", "NO", "FIRST", "UHHH", "NOTHING", "WAIT"};
       s_first = new String[] {"LEFT", "OKAY", "YES", "MIDDLE", "NO", "RIGHT", "NOTHING", "UHHH", "WAIT", "READY", "BLANK", "WHAT", "PRESS", "FIRST"};
       s_no = new String[] {"BLANK", "UHHH", "WAIT", "FIRST", "WHAT", "READY", "RIGHT", "YES", "NOTHING", "LEFT", "PRESS", "OKAY", "NO", "MIDDLE"};
       s_blank = new String[] {"WAIT", "RIGHT", "OKAY", "MIDDLE", "BLANK", "PRESS", "READY", "NOTHING", "NO", "WHAT", "LEFT", "UHHH", "YES", "FIRST"};
       s_nothing = new String[]{"UHHH", "RIGHT", "OKAY", "MIDDLE", "YES", "BLANK", "NO", "PRESS", "LEFT", "WHAT", "WAIT", "FIRST", "NOTHING", "READY"};
       s_yes = new String[]{"OKAY", "RIGHT", "UHHH", "MIDDLE", "FIRST", "WHAT", "PRESS", "READY", "NOTHING", "YES", "LEFT", "BLANK", "NO", "WAIT"};
       s_what = new String[]{"UHHH", "WHAT", "LEFT", "NOTHING", "READY", "BLANK", "MIDDLE", "NO", "OKAY", "FIRST", "WAIT", "YES", "PRESS", "RIGHT"};
       s_uhhh = new String[]{"READY", "NOTHING", "LEFT", "WHAT", "OKAY", "YES", "RIGHT", "NO", "PRESS", "BLANK", "UHHH", "MIDDLE", "WAIT", "FIRST"};
        s_left = new String[]{"RIGHT", "LEFT", "FIRST", "NO", "MIDDLE", "YES", "BLANK", "WHAT", "UHHH", "WAIT", "PRESS", "READY", "OKAY", "NOTHING"};
        s_right = new String[]{"YES", "NOTHING", "READY", "PRESS", "NO", "WAIT", "WHAT", "RIGHT", "MIDDLE", "LEFT", "UHHH", "BLANK", "OKAY", "FIRST"};
        s_middle = new String[]{"BLANK", "READY", "OKAY", "WHAT", "NOTHING", "PRESS", "NO", "WAIT", "LEFT", "MIDDLE", "RIGHT", "FIRST", "UHHH", "YES"};
        s_okay = new String[]{"MIDDLE", "NO", "FIRST", "YES", "UHHH", "NOTHING", "WAIT", "OKAY", "LEFT", "READY", "BLANK", "PRESS", "WHAT", "RIGHT"};
        s_wait = new String[]{"UHHH", "NO", "BLANK", "OKAY", "YES", "LEFT", "FIRST", "PRESS", "WHAT", "WAIT", "NOTHING", "READY", "RIGHT", "MIDDLE"};
        s_press = new String[]{"RIGHT", "MIDDLE", "YES", "READY", "PRESS", "OKAY", "NOTHING", "UHHH", "BLANK", "LEFT", "FIRST", "WHAT", "NO", "WAIT"};
        s_you = new String[]{"SURE", "YOU ARE", "YOUR", "YOU'RE", "NEXT", "UH HUH", "UR", "HOLD", "WHAT?", "YOU", "UH UH", "LIKE", "DONE", "U"};
        s_youare = new String[]{"YOUR", "NEXT", "LIKE", "UH HUH", "WHAT?", "DONE", "UH UH", "HOLD", "YOU", "U", "YOU'RE", "SURE", "UR", "YOU ARE"};
        s_your = new String[]{"UH UH", "YOU ARE", "UH HUH", "YOUR", "NEXT", "UR", "SURE", "U", "YOU'RE", "YOU", "WHAT?", "HOLD", "LIKE", "DONE"};
        s_youre = new String[]{"YOU", "YOU'RE", "UR", "NEXT", "UH UH", "YOU ARE", "U", "YOUR", "WHAT?", "UH HUH", "SURE", "DONE", "LIKE", "HOLD"};
        s_ur = new String[]{"DONE", "U", "UR", "UH HUH", "WHAT?", "SURE", "YOUR", "HOLD", "YOU'RE", "LIKE", "NEXT", "UH UH", "YOU ARE", "YOU"};
        s_u = new String[]{"UH HUH", "SURE", "NEXT", "WHAT?", "YOU'RE", "UR", "UH UH", "DONE", "U", "YOU", "LIKE", "HOLD", "YOU ARE", "YOUR"};
        s_uhhuh = new String[]{"UH HUH", "YOUR", "YOU ARE", "YOU", "DONE", "HOLD", "UH UH", "NEXT", "SURE", "LIKE", "YOU'RE", "UR", "U", "WHAT?"};
        s_uhuh = new String[]{"UR", "U", "YOU ARE", "YOU'RE", "NEXT", "UH UH", "DONE", "YOU", "UH HUH", "LIKE", "YOUR", "SURE", "HOLD", "WHAT?"};
        s_what7 = new String[]{"YOU", "HOLD", "YOU'RE", "YOUR", "U", "DONE", "UH UH", "LIKE", "YOU ARE", "UH HUH", "UR", "NEXT", "WHAT?", "SURE"};
        s_done = new String[]{"SURE", "UH HUH", "NEXT", "WHAT?", "YOUR", "UR", "YOU'RE", "HOLD", "LIKE", "YOU", "U", "YOU ARE", "UH UH", "DONE"};
        s_next = new String[]{"WHAT?", "UH HUH", "UH UH", "YOUR", "HOLD", "SURE", "NEXT", "LIKE", "DONE", "YOU ARE", "UR", "YOU'RE", "U", "YOU"};
        s_hold = new String[]{"YOU ARE", "U", "DONE", "UH UH", "YOU", "UR", "SURE", "WHAT?", "YOU'RE", "NEXT", "HOLD", "UH HUH", "YOUR", "LIKE"};
        s_sure = new String[]{"YOU ARE", "DONE", "LIKE", "YOU'RE", "YOU", "HOLD", "UH HUH", "UR", "SURE", "U", "WHAT?", "NEXT", "YOUR", "UH UH"};
        s_like = new String[]{"YOU'RE", "NEXT", "U", "UR", "HOLD", "DONE", "UH UH", "WHAT?", "UH HUH", "YOU", "LIKE", "SURE", "YOU ARE", "YOUR"};

    }

    private void nextTable(){
        selectedImage++;
        if (selectedImage > 27) {
            selectedImage = 0;
        }
        displayTable();
    }
    private void previousTable() {
        selectedImage--;
        if (selectedImage < 0) {
            selectedImage = 27;
        }
        displayTable();
    }
    private void displayTable(){
        switch (selectedImage){
            case 0:
                table.setImageResource(R.drawable.word);
                break;
            case 1:
                table.setImageResource(R.drawable.word_blank);
                break;
            case 2:
                table.setImageResource(R.drawable.word_c);
                break;
            case 3:
                table.setImageResource(R.drawable.word_cee);
                break;
            case 4:
                table.setImageResource(R.drawable.word_display);
                break;
            case 5:
                table.setImageResource(R.drawable.word_first);
                break;
            case 6:
                table.setImageResource(R.drawable.word_holdon);
                break;
            case 7:
                table.setImageResource(R.drawable.word_lead);
                break;
            case 8:
                table.setImageResource(R.drawable.word_led);
                break;
            case 9:
                table.setImageResource(R.drawable.word_leed);
                break;
            case 10:
                table.setImageResource(R.drawable.word_no);
                break;
            case 11:
                table.setImageResource(R.drawable.word_nothing);
                break;
            case 12:
                table.setImageResource(R.drawable.word_okay);
                break;
            case 13:
                table.setImageResource(R.drawable.word_read);
                break;
            case 14:
                table.setImageResource(R.drawable.word_red);
                break;
            case 15:
                table.setImageResource(R.drawable.word_reed);
                break;
            case 16:
                table.setImageResource(R.drawable.word_says);
                break;
            case 17:
                table.setImageResource(R.drawable.word_see);
                break;
            case 18:
                table.setImageResource(R.drawable.word_their);
                break;
            case 19:
                table.setImageResource(R.drawable.word_there);
                break;
            case 20:
                table.setImageResource(R.drawable.word_theyare);
                break;
            case 21:
                table.setImageResource(R.drawable.word_theyre);
                break;
            case 22:
                table.setImageResource(R.drawable.word_ur);
                break;
            case 23:
                table.setImageResource(R.drawable.word_yes);
                break;
            case 24:
                table.setImageResource(R.drawable.word_you);
                break;
            case 25:
                table.setImageResource(R.drawable.word_youare);
                break;
            case 26:
                table.setImageResource(R.drawable.word_your);
                break;
            case 27:
                table.setImageResource(R.drawable.word_youre);
                break;
        }
    }

    private void nextWord(){
        selectedWord++;
        if(selectedWord>25){
            selectedWord=0;
        }
        displayWord();
    }

    private void  previousWord(){
        selectedWord--;
        if(selectedWord<0){
            selectedWord=25;
        }
        displayWord();
    }
    private void displayWord(){
        switch (selectedWord){
            case 0:
                textViewFirst.setText("READY");
                displaySolutionWithDelay(s_ready);
                break;
            case 1:
                textViewFirst.setText("FIRST");
                displaySolutionWithDelay(s_first);
                break;
            case 2:
                textViewFirst.setText("NO");
                displaySolutionWithDelay(s_no);

                break;
            case 3:
                textViewFirst.setText("BLANK");
                displaySolutionWithDelay(s_blank);

                break;
            case 4:
                textViewFirst.setText("YES");
                displaySolutionWithDelay(s_yes);

                break;
            case 5:
                textViewFirst.setText("UHHH");
                displaySolutionWithDelay(s_uhhh);

                break;
            case 6:
                textViewFirst.setText("LEFT");
                displaySolutionWithDelay(s_left);

                break;
            case 7:
                textViewFirst.setText("RIGHT");
                displaySolutionWithDelay(s_right);

                break;
            case 8:
                textViewFirst.setText("MIDDLE");
                displaySolutionWithDelay(s_middle);

                break;
            case 9:
                textViewFirst.setText("OKAY");
                displaySolutionWithDelay(s_okay);

                break;
            case 10:
                textViewFirst.setText("WAIT");
                displaySolutionWithDelay(s_wait);

                break;
            case 11:
                textViewFirst.setText("PRESS");
                displaySolutionWithDelay(s_press);

                break;
            case 12:
                textViewFirst.setText("YOU");
                displaySolutionWithDelay(s_you);

                break;
            case 13:
                textViewFirst.setText("YOU ARE");
                displaySolutionWithDelay(s_youare);

                break;
            case 14:
                textViewFirst.setText("YOUR");
                displaySolutionWithDelay(s_your);

                break;
            case 15:
                textViewFirst.setText("YOU'RE");
                displaySolutionWithDelay(s_youre);

                break;
            case 16:
                textViewFirst.setText("UR");
                displaySolutionWithDelay(s_ur);

                break;
            case 17:
                textViewFirst.setText("U");
                displaySolutionWithDelay(s_u);
                break;
            case 18:
                textViewFirst.setText("UH HUH");
                displaySolutionWithDelay(s_uhhuh);
                break;
            case 19:
                textViewFirst.setText("UH UH");
                displaySolutionWithDelay(s_uhuh);
                break;
            case 20:
                textViewFirst.setText("WHAT?");
                displaySolutionWithDelay(s_what7);

                break;
            case 21:
                textViewFirst.setText("DONE");
                displaySolutionWithDelay(s_done);

                break;
            case 22:
                textViewFirst.setText("NEXT");
                displaySolutionWithDelay(s_next);

                break;
            case 23:
                textViewFirst.setText("HOLD");
                displaySolutionWithDelay(s_hold);

                break;
            case 24:
                textViewFirst.setText("SURE");
                displaySolutionWithDelay(s_sure);

                break;
            case 25:
                textViewFirst.setText("LIKE");
                displaySolutionWithDelay(s_like);
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
                    Intent i = new Intent(Module5.this, Module4.class);
                    startActivity(i);
                }
                if(x1>x2){
                    Intent i = new Intent(Module5.this, Module5.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}