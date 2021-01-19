package com.example.bankapp;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class newadapter extends RecyclerView.Adapter<newadapter.myviewholder>{

    ArrayList<model> dataholder1;
    private Context mContext;
    int transactionAmount;
    String senderName;
    String receiverName;
    int senderNewAmount;
    int receiverNewAmount;

    public newadapter(Context Context,ArrayList<model> dataholder)
    {
        this.dataholder1 = dataholder;
        this.mContext = Context;
    }


    @NonNull
    @Override
    public newadapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new newadapter.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull newadapter.myviewholder holder, int position) {

        final model temp = dataholder1.get(position);

        holder.dname.setText(dataholder1.get(position).getName());
        holder.dmaile.setText(dataholder1.get(position).getEmail());
        holder.damount.setText(Integer.toString(dataholder1.get(position).getAmount()));
        holder.dphn.setText(Integer.toString(dataholder1.get(position).getPhn()));
        holder.daccount.setText(Integer.toString(dataholder1.get(position).getAccount()));
        holder.difsc.setText(Integer.toString(dataholder1.get(position).getIfsc()));

        transactionAmount = temp.getTransAmount();
        senderName =dataholder1.get(position).getSenderName();
        senderNewAmount = dataholder1.get(position).getSenderNewAmount();
     //   System.out.println("TransactionAmount: "+transactionAmount+", Sender name : "+senderName);

        holder.dname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                receiverName = temp.getName();
                receiverNewAmount = temp.getAmount() + transactionAmount;
             //   System.out.println("TransactionAmount: "+transactionAmount+", Sender name : "+senderName+", ReceiverName : "+receiverName);
                updateAmount(senderName,receiverName,senderNewAmount,receiverNewAmount);

                processinsert2(senderName.toString(), receiverName.toString(), Integer.parseInt(String.valueOf(transactionAmount)));

                ArrayList<historyModel> storhistory = new ArrayList<>();

                Intent intent = new Intent(mContext,fetchdata.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);

            }
        });

    }

   public void updateAmount(String senderName,String receiverName,int senderNewAmount,int receiverNewAmount){
        String res = new dbmanager(mContext).updateData(senderName,receiverName,senderNewAmount,receiverNewAmount);
        Toast.makeText(mContext,res, Toast.LENGTH_SHORT).show();
    }

    private void processinsert2(String se, String re, int am) {

        String res = new dbmanager(this.mContext).insertdata2(se,re,am);

        Toast.makeText(mContext,res,Toast.LENGTH_SHORT).show();

    }


    @Override
    public int getItemCount() {
        return dataholder1.size();
    }


    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView dname,dmaile,damount,dphn,daccount,difsc;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            dname = (TextView) itemView.findViewById(R.id.UserName);
            dmaile = (TextView) itemView.findViewById(R.id.UserEmail);
            damount = (TextView) itemView.findViewById(R.id.UserAmount);
            dphn = (TextView) itemView.findViewById(R.id.UserPhn);
            daccount= (TextView) itemView.findViewById(R.id.UserAccount);
            difsc = (TextView) itemView.findViewById(R.id.UserIFSC);
        }
    }
}