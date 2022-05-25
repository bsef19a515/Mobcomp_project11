package com.example.myapplication10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private TextView qs,score,qsno;
    private List<Question> question;
    private RadioGroup radiogrp;
    private RadioButton rb1,rb2,rb3;
    private Button btnnxt;
    int totqs;
    int counter=0;
    int sc;
    public Question crntqs;

    ColorStateList clr;
    boolean answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        question=new ArrayList<>();
        qs=findViewById(R.id.textView5);
        score=findViewById(R.id.textView3);
        qsno=findViewById(R.id.textView2);

        radiogrp=findViewById(R.id.rg);
        rb1=findViewById(R.id.radioButton);
        rb2=findViewById(R.id.radioButton2);
        rb3=findViewById(R.id.radioButton3);

        btnnxt=findViewById(R.id.button2);
        clr=rb1.getTextColors();

        addQues();
        totqs=question.size();
        showNxtqs();
        btnnxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer==false){
                    if(rb1.isChecked()||rb2.isChecked()||rb3.isChecked()){
                        checkAnswer();
                    }
                    else{
                        Toast.makeText(MainActivity2.this, "Please Select an option", Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    showNxtqs();
                }
            }
        });
    }

    private void checkAnswer() {
        answer=true;
        RadioButton selected=findViewById(radiogrp.getCheckedRadioButtonId());
        int ansno=radiogrp.indexOfChild(selected)+1;
        if(ansno==crntqs.getQuesno()){
            sc++;
            score.setText("Score :"+sc);
        }
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        switch (crntqs.getQuesno()){
            case 1:
                rb1.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                break;case 3:
                rb3.setTextColor(Color.GREEN);
                break;
        }
        if(counter<totqs){
            btnnxt.setText("Next");
        }
        else{
            btnnxt.setText("Finish");

        }

    }

    private void showNxtqs() {
        radiogrp.clearCheck();

        rb1.setTextColor(clr);
        rb2.setTextColor(clr);
        rb3.setTextColor(clr);

        if(counter<totqs){
         crntqs=question.get(counter);
         qs.setText(crntqs.getQuestion());
         rb1.setText(crntqs.getOpt1());
         rb2.setText(crntqs.getOpt2());
         rb3.setText(crntqs.getOpt3());

        counter++;
        btnnxt.setText("Submit");
        qsno.setText("Questions:"+counter+"/"+totqs);
        answer=false;
        }
        else{
            finish();
        }
    }




    private void addQues() {
        question.add(new Question("قرآن میں کتنے جُزْءْ ہیں؟","۱۰","۲۰","۳۰",3));
        question.add(new Question("قرآن مجید میں کتنی سورتیں ہیں؟","۱۱۰","۱۱۴","۱۱۸",2));
        question.add(new Question("قرآن مجید کی آخری سورت کون سی ہے؟","سورة الناس","سورة الفلق"," سورة الإخلاص",1));
        question.add(new Question("قرآن مجید کی پہلی سورت کون سی ہے؟"," سورة الفاتحة","سورة الناس","سورة الإخلاص",1));
        question.add(new Question("قرآن مجید کی سب سے چھوٹی سورت کون سی ہے؟","سورة الفلق","سورة الفاتحة","سورة الكوثر",3));


    }
}