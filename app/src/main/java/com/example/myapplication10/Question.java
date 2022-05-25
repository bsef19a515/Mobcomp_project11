package com.example.myapplication10;

public class Question {
    private String question,opt1,opt2,opt3;
    private int quesno;

    public Question(String qs,String op1,String op2,String op3,int qsno) {
        this.question=qs;
        this.opt1=op1;
        this.opt2=op2;
        this.opt3=op3;
        this.quesno=qsno;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOpt1() {
        return opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }

    public int getQuesno() {
        return quesno;
    }

    public void setQuesno(int quesno) {
        this.quesno = quesno;
    }
}

