package com.example.bankapp;

public class historyModel {

    String sendName,receiveName;
    int transfAmount;

    public historyModel(String sendnamE, String receiveNamE, int TransferAmount1) {
        this.sendName = sendnamE;
        this.receiveName = receiveNamE;
        this.transfAmount = TransferAmount1;

    }

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public int getTransfAmount() {
        return transfAmount;
    }

    public void setTransfAmount(int transfAmount) {
        this.transfAmount = transfAmount;
    }
}
