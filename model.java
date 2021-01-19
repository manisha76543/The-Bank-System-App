package com.example.bankapp;

public class model {

    String Mname;
    String Memail;
    int Mamount;
    int Mphn,Maccount,Mifsc;
    int transAmount;
    String senderName;
    int senderNewAmount;
    public model(){

    }

    public model(String name, String email, int amount, int phn, int account, int ifsc) {
        this.Mname = name;
        this.Memail = email;
        this.Mamount = amount;
        this.Mphn = phn;
        this.Maccount = account;
        this.Mifsc = ifsc;

    }
    public model(String name, String email, int amount, int phn, int account, int ifsc,int transAmount,String senderName,int senderNewAmount) {
        this.Mname = name;
        this.Memail = email;
        this.Mamount = amount;
        this.Mphn = phn;
        this.Maccount = account;
        this.Mifsc = ifsc;
        this.transAmount = transAmount;
        this.senderName = senderName;
        this.senderNewAmount = senderNewAmount;
    }



    public String getName() {
        return Mname;
    }

    public void setName(String name) {
        this.Mname = name;
    }

    public String getEmail() {
        return Memail;
    }

    public void setEmail(String email) {
        this.Memail = email;
    }

    public int getAmount() {
        return Mamount;
    }

    public void setAmount(int amount) {
        this.Mamount = amount;
    }


    public int getPhn() {
        return Mphn;
    }

    public void setPhn(int phn) {
        this.Mphn = phn;
    }

    public int getAccount() {
        return Maccount;
    }

    public void setAccount(int account) {
        this.Maccount = account;
    }

    public int getIfsc() {
        return Mifsc;
    }

    public void setIfsc(int ifsc) {
        this.Mifsc = ifsc;
    }

    public void setTransAmount(int transAmount) {
        this.transAmount = transAmount;
    }
    public int getTransAmount() {
        return transAmount;
    }

    public String getSenderName(){return senderName;}
    public void setSenderName(String senderName){this.senderName = senderName;}

    public void setSenderNewAmount(int senderNewAmount) {
        this.senderNewAmount = senderNewAmount;
    }
    public int getSenderNewAmount() {
        return senderNewAmount;
    }

}
