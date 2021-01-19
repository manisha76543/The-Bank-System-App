package com.example.bankapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class historyAdapter extends RecyclerView.Adapter<historyAdapter.myviewholder> {

    ArrayList<historyModel> dataholder2 = new ArrayList<>();
    private Context hContext;
    int transacAmountH;
    String sendNameH;
    String receivNameH;

    public historyAdapter(Context Context,ArrayList<historyModel> dataholder)
    {
        this.dataholder2 = dataholder;
        this.hContext = Context;
    }


    @NonNull
    @Override
    public historyAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.historyrow,parent,false);
        return new historyAdapter.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull historyAdapter.myviewholder holder, int position) {

        final historyModel temp = dataholder2.get(position);

        holder.hnameSender.setText(temp.getSendName());
        holder.hnameReceiver.setText(temp.getReceiveName());
        holder.hamount.setText(temp.getTransfAmount());

        transacAmountH = temp.getTransfAmount();
        sendNameH = temp.getSendName();
        receivNameH = temp.getReceiveName();


    }

    @Override
    public int getItemCount() {
        return dataholder2.size();
    }


    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView hnameSender,hamount,hnameReceiver;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            hnameSender = (TextView) itemView.findViewById(R.id.SendName);
            hamount = (TextView) itemView.findViewById(R.id.transfAmount);
            hnameReceiver = (TextView) itemView.findViewById(R.id.receiveName);

        }
    }

}
