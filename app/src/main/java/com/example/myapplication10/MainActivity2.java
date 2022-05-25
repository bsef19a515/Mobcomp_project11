package com.example.myapplication10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private TextView qs,score,qsno,timer;
    private List<Question> question;
    private RadioButton rb1,rb2,rb3;
    private Button btnnxt;
    int totqs;
    int counter=0;
    private Question crntqs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        question=new ArrayList<>();
        qs=findViewById(R.id.textView5);
        score=findViewById(R.id.textView3);
        qsno=findViewById(R.id.textView2);
        timer=findViewById(R.id.textView4);

        rb1=findViewById(R.id.radioButton);
        rb2=findViewById(R.id.radioButton2);
        rb3=findViewById(R.id.radioButton3);

        btnnxt=findViewById(R.id.button2);

        addQues();
        totqs=question.size();
        showNxtqs();
    }

    private void showNxtqs() {
        if(counter<totqs){
         crntqs=question.get(counter);
         qs.setText(crntqs.getQuestion());
         rb1.setText(crntqs.getOpt1());
         rb2.setText(crntqs.getOpt2());
         rb3.setText(crntqs.getOpt3());

        counter++;
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