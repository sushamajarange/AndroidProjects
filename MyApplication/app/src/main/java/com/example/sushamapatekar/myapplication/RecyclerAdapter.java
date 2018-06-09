package com.example.sushamapatekar.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Myholder>{
    List<DataModel> dataModelArrayList;

    public RecyclerAdapter(List<DataModel> dataModelArrayList) {
        this.dataModelArrayList = dataModelArrayList;
    }

    class Myholder extends RecyclerView.ViewHolder{
        TextView fName,lName,contact;

        public Myholder(View itemView) {
            super(itemView);

            fName = (TextView) itemView.findViewById(R.id.fName);
            lName = (TextView) itemView.findViewById(R.id.lName);
            contact = (TextView) itemView.findViewById(R.id.contact);
        }
    }


    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_display_list,null);
        return new Myholder(view);

    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        DataModel dataModel=dataModelArrayList.get(position);
        holder.fName.setText(dataModel.getFirstname());
        holder.lName.setText(dataModel.getLastname());
        holder.contact.setText(dataModel.getContactNo());

    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }
}


