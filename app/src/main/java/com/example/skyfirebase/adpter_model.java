package com.example.skyfirebase;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adpter_model extends RecyclerView.Adapter<adpter_model.viewholder> {

    public ArrayList<model> adArraylist;

    public adpter_model(ArrayList<model> adArraylist) {
        this.adArraylist=adArraylist;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_rec,parent,false);
        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        model s = adArraylist.get(position);



        String name = s.getM_name();

        Log.e("nufmber", "onBindViewHolder: "+ name);

        holder.Id.setText(s.m_id);
        holder.Mobile.setText(s.m_mob);
        holder.details.setText(s.m_details);
        holder.Name.setText(s.m_name);


    }

    @Override
    public int getItemCount() {
        return adArraylist.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        private TextView Id;
        private TextView Mobile;
        private TextView details;
        private TextView Name;


        public viewholder(@NonNull View itemView) {
            super(itemView);


            Id = (TextView) itemView.findViewById(R.id.Id);
            Mobile = (TextView)  itemView.findViewById(R.id.Mobile);
            details = (TextView)  itemView.findViewById(R.id.details);
            Name = (TextView)  itemView.findViewById(R.id.Name);
        }
    }
}
