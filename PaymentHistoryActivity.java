package com.example.bankapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class PaymentHistoryActivity extends AppCompatActivity {

    RecyclerView rview;
    ArrayList<historyModel> dataholder2=new ArrayList<>();


    public static final String sendNAME = "sendNAME";
    public static final String receiveNAME= "receiveNAME";
    public static final String transAMOUNT = "transAMOUNT";
 //   int transAmouNt;
   // String senderNaME,receiverNaME;
   // int position=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_history);

        rview = (RecyclerView) findViewById(R.id.rview);
        rview.setLayoutManager(new LinearLayoutManager(this));


    //    Cursor cursor = new dbmanager(this).readalldata();

        Cursor cursor = new dbmanager(this).readalldata2();
        dataholder2 = new ArrayList<>();

       while (cursor.moveToNext()) {
            historyModel obj = new historyModel(cursor.getString(1), cursor.getString(2), cursor.getInt(3));
            dataholder2.add(obj);
        }


        //Intent i = getIntent();
        //transAmouNt = i.getIntExtra(transAMOUNT,0);
        //senderNaME = i.getStringExtra(sendNAME);
        //receiverNaME = i.getStringExtra(receiveNAME);

       // ArrayList<historyModel> rview = initCity(senderNaME,receiverNaME,transAmouNt);

       historyAdapter adapter1 = new historyAdapter(getApplicationContext(), dataholder2);
        this.rview.setAdapter(adapter1);

    }

 /*   private ArrayList<historyModel> initCity(String senderNaME, String receiverNaME, int transAmouNt) {

        ArrayList<historyModel> list = new ArrayList<>();
        list.add(position,new historyModel(senderNaME,receiverNaME,transAmouNt));
        position++;
        return list;

    }
*/


}