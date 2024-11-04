package com.example.quickdefuse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Module11 extends AppCompatActivity {

    private String []wordlist;
    private char[] pos1, pos2, pos3, pos4, pos5;
    private EditText letters1, letters2, letters3, letters4, letters5;
    private TextView solution;

    private float x1,x2,y1,y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module11);

        linkComponets();

        letters1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                setSolution();
            }
        });
        letters2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                setSolution();
            }
        });
        letters3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                setSolution();
            }
        });
        letters4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                setSolution();
            }
        });
        letters5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                setSolution();
            }
        });
    }

    private void linkComponets(){
        letters1 = findViewById(R.id.editText1);
        letters2 = findViewById(R.id.editText2);
        letters3 = findViewById(R.id.editText3);
        letters4 = findViewById(R.id.editText4);
        letters5 = findViewById(R.id.editText5);
        solution = findViewById(R.id.textFinal);
    }

    private void setSolution(){
        wordlist = new String[]{"about", "after", "again", "below", "could","every","first","found","great","house","large","learn","never","other","place","plant","point","right","small","sound","spell","still","study","their","there","these","thing","think","three","water","where","which","world","would","write"};
        setLetters();
        List<String> matchingWords = findMatchingWords(wordlist, pos1, pos2, pos3, pos4, pos5);
        if(!matchingWords.isEmpty()) {
            solution.setText(matchingWords.get(0).toUpperCase());
        }
    }

    private List<String> findMatchingWords(String[] wordlist, char[] pos1, char[] pos2, char[] pos3, char[] pos4, char[] pos5)
    {
        //Metoda pronalazi sve riječi koje uspije pronaći kao lozinku
        List<String> result = new ArrayList<>();

        for (String word : wordlist) {
            if (containsChar(pos1, word.charAt(0)) &&
                    containsChar(pos2, word.charAt(1)) &&
                    containsChar(pos3, word.charAt(2)) &&
                    containsChar(pos4, word.charAt(3)) &&
                    containsChar(pos5, word.charAt(4)))
            {
                result.add(word);
            }
        }
        return result;
    }

    private void setLetters(){
        //Metoda postavlja slova u varijable

        pos1 = new char[letters1.length()];
        pos2 = new char[letters2.length()];
        pos3 = new char[letters3.length()];
        pos4 = new char[letters4.length()];
        pos5 = new char[letters5.length()];

        int i;
        i=0;
        for (char c:letters1.getText().toString().toCharArray()) {
            pos1[i] = c;
            i++;
        }
        i=0;
        for (char c:letters2.getText().toString().toCharArray()) {
            pos2[i] = c;
            i++;
        }
        i=0;
        for (char c:letters3.getText().toString().toCharArray()) {
            pos3[i] = c;
            i++;
        }
        i=0;
        for (char c:letters4.getText().toString().toCharArray()) {
            pos4[i] = c;
            i++;
        }
        i=0;
        for (char c:letters5.getText().toString().toCharArray()) {
            pos5[i] = c;
            i++;
        }

        pos1 = removeDuplicates(pos1);
        pos2 = removeDuplicates(pos2);
        pos3 = removeDuplicates(pos3);
        pos4 = removeDuplicates(pos4);
        pos5 = removeDuplicates(pos5);
    }

    private char[] removeDuplicates(char[] letters) {
        //Metoda briše dupla slova u varijablama

        HashSet<Character> seen = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for (char letter : letters) {
            if (!seen.contains(letter)) {
                seen.add(letter);
                result.append(letter);
            }
        }

        return result.toString().toCharArray();
    }

    public static boolean containsChar(char[] array, char target) {
        if (array.length == 0) {
            return true;
        }
        for (char c : array) {
            if (c == target) {
                return true;
            }
        }
        return false;
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
                    Intent i = new Intent(Module11.this, Module10.class);
                    startActivity(i);
                }
                if(x1>x2){
                    Intent i = new Intent(Module11.this, Module12.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}