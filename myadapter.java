package com.example.bankapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>{

ArrayList<model> dataholder;
private Context mContext;

    public myadapter(Context Context,ArrayList<model> dataholder)
    {
        this.dataholder = dataholder;
        this.mContext = Context;

    }


    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        final model temp = dataholder.get(position);

        holder.dname.setText(dataholder.get(position).getName());
        holder.dmaile.setText(dataholder.get(position).getEmail());
        holder.damount.setText(Integer.toString(dataholder.get(position).getAmount()));
        holder.dphn.setText(Integer.toString(dataholder.get(position).getPhn()));
        holder.daccount.setText(Integer.toString(dataholder.get(position).getAccount()));
        holder.difsc.setText(Integer.toString(dataholder.get(position).getIfsc()));


        holder.dname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, UserActivity.class);
                intent.putExtra("name", temp.getName());
                intent.putExtra("email", temp.getEmail());
                intent.putExtra("amount", Integer.toString(temp.getAmount()));
                intent.putExtra("phone", Integer.toString(temp.getPhn()));
                intent.putExtra("account", Integer.toString(temp.getAccount()));
                intent.putExtra("ifsc", Integer.toString(temp.getIfsc()));


                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return dataholder.size();
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