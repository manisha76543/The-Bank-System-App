package com.example.bankapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {

    TextView uName,uEmail,uAmount,uPhn,uAccount,uIFSC;
    Button transferMoney;
    String senderName;
    int senderAccountBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        uName = (TextView) findViewById(R.id.TextName);
        uEmail = (TextView) findViewById(R.id.textEmail);
        uAmount = (TextView) findViewById(R.id.textAvailableB);

        uPhn = (TextView) findViewById(R.id.textPhone);
        uAccount = (TextView) findViewById(R.id.textAccountNo);
        uIFSC = (TextView) findViewById(R.id.textIFSC);
        transferMoney = (Button) findViewById(R.id.transferMoney);


        uName.setText(getIntent().getStringExtra("name"));
        uEmail.setText(getIntent().getStringExtra("email"));
        uAmount.setText(getIntent().getStringExtra("amount"));
      uPhn.setText(getIntent().getStringExtra("phone"));
        uAccount.setText(getIntent().getStringExtra("account"));
       uIFSC.setText(getIntent().getStringExtra("ifsc"));

        senderName = getIntent().getStringExtra("name");
        senderAccountBalance = Integer.parseInt(getIntent().getStringExtra("amount"));
      //  System.out.println("Sender Name :"+senderName+", Sender Account Balance :"+senderAccountBalance);

        transferMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog alertDialog =new AlertDialog.Builder(UserActivity.this).create();

                alertDialog.setTitle("Enter amount");

                final EditText input = new EditText(UserActivity.this);
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);


                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "SEND",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                int num = 0;
                                if(!input.getText().toString().equals(""))
                                    num= Integer.parseInt(input.getText().toString());
                                int avlAmount = Integer.parseInt(uAmount.getText().toString());


                                if(TextUtils.isEmpty(input.getText()))
                                {
                                  //  input.setError("Enter value");
                                   //input.requestFocus();

                                    AlertDialog alertDialog;
                                    alertDialog = new AlertDialog.Builder(UserActivity.this).create();

                                    alertDialog.setMessage("Enter value");
                                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            });
                                    alertDialog.show();

                                  //  Toast.makeText(getApplicationContext(), "select receiver" , Toast.LENGTH_SHORT).show();

                                }
                                else if(num == 0)
                                {
                                    input.setError("Entet Valid input");
                                    input.requestFocus();
                                }
                                else if(num > avlAmount)
                                {

                                    AlertDialog alertDialog;
                                    alertDialog = new AlertDialog.Builder(UserActivity.this).create();

                                    alertDialog.setMessage("Insufficient Balance");
                                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            });
                                    alertDialog.show();

                                }
                                else {

                                    int Enteramount = Integer.parseInt(input.getText().toString().trim());
                                    senderAccountBalance = senderAccountBalance - Enteramount;
                                    Toast.makeText(getApplicationContext(), "select receiver" , Toast.LENGTH_SHORT).show();
                                   // startActivity(new Intent(getApplicationContext(), newFetchActivity.class));

                                    Intent i = new Intent(getApplicationContext(), newFetchActivity.class);
                                    i.putExtra(newFetchActivity.EntAm, Enteramount);
                                    i.putExtra(newFetchActivity.SenderAmount,senderAccountBalance);
                                    i.putExtra(newFetchActivity.SenderName,senderName);
                                    startActivity(i);
                                }

                            }
                        });

                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "cancel",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();

            }
        });

    }

}