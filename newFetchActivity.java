package com.example.bankapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class newFetchActivity extends AppCompatActivity {

    RecyclerView recyclerView1;
    ArrayList<model> dataholder1;

    public static final String EntAm = "EntAm";
    public static final String SenderName = "SenderName";
    public static final String SenderAmount = "SenderAmount";
    int transAmount;
    int senderNewAmount;
    String senderName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_fetch);

        recyclerView1 = (RecyclerView) findViewById(R.id.recview1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));

        Intent i = getIntent();
        transAmount = i.getIntExtra(EntAm,0);
        senderNewAmount = i.getIntExtra(SenderAmount,0);
        senderName = i.getStringExtra(SenderName);
     //   System.out.println("Transaction Amount : "+transAmount+", SenderName :"+senderName);

        Cursor cursor = new dbmanager(this).readalldata();
        dataholder1 = new ArrayList<>();
        while (cursor.moveToNext())
        {
            model obj = new model(cursor.getString(1),cursor.getString(2),cursor.getInt(3),
                    cursor.getInt(4),cursor.getInt(5),cursor.getInt(6),transAmount,senderName,senderNewAmount);
            dataholder1.add(obj);

        }

        newadapter adapter = new newadapter(getApplicationContext(),dataholder1);
        recyclerView1.setAdapter(adapter);
    }

}