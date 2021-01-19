package com.example.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    EditText name,email,amount,phone,account,ifsc;
    Button sbmt,viewAll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name = (EditText) findViewById(R.id.nametext);
        email = (EditText) findViewById(R.id.emailtext);
        amount = (EditText) findViewById(R.id.amounttext);
        phone = (EditText) findViewById(R.id.phoneText);
        account = (EditText) findViewById(R.id.accountText);
        ifsc = (EditText) findViewById(R.id.ifscText);


        viewAll = (Button) findViewById(R.id.viewAll_users);
        sbmt = (Button) findViewById(R.id.btn);


        sbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                processinsert(name.getText().toString(), email.getText().toString(), Integer.parseInt(amount.getText().toString()),
                        Integer.parseInt(phone.getText().toString()),Integer.parseInt(account.getText().toString()),
                        Integer.parseInt(ifsc.getText().toString()));

            }
        });

        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),fetchdata.class));

            }
        });


    }
            private void processinsert(String n, String e, int a , int phn, int ac, int ifs) {

                String res = new dbmanager(this).insertdata(n,e,a,phn,ac,ifs);

                name.setText("");
                email.setText("");
                amount.setText("");
                phone.setText("");
                account.setText("");
                ifsc.setText("");

                Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();

            }

}