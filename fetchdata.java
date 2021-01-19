package com.example.bankapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class fetchdata extends AppCompatActivity {

    private static String receiveNAME;
    private static String sendNAME;
    private static String transAMOUNT;

    RecyclerView recyclerView;
    ArrayList<model> dataholder;


    String sendNamE,receiveNamE;
    int transAmounT;

    FloatingActionButton fAb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetchdata);

        recyclerView = (RecyclerView) findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fAb = (FloatingActionButton) findViewById(R.id.histoBtn);

        Cursor cursor = new dbmanager(this).readalldata();

        dataholder = new ArrayList<>();
        while (cursor.moveToNext()) {
            model obj = new model(cursor.getString(1), cursor.getString(2), cursor.getInt(3),
                    cursor.getInt(4), cursor.getInt(5), cursor.getInt(6));
            dataholder.add(obj);
        }

        myadapter adapter = new myadapter(getApplicationContext(), dataholder);
        recyclerView.setAdapter(adapter);


        sendNamE = getIntent().getStringExtra("name");
        receiveNamE = getIntent().getStringExtra("rname");
//        transAmounT = Integer.parseInt(getIntent().getStringExtra("amountt"));


        fAb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(fetchdata.this, PaymentHistoryActivity.class);
                intent.putExtra(fetchdata.sendNAME ,sendNamE);
                intent.putExtra(fetchdata.receiveNAME,receiveNamE);
                intent.putExtra(fetchdata.transAMOUNT,transAmounT);

                startActivity(intent);


            }
        });

    }
}