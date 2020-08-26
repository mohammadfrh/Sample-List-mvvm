package com.frh.mvvmsample2.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.frh.mvvmsample2.Model.PersonModel;
import com.frh.mvvmsample2.R;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.MyViewHolder>   {

    private ArrayList<PersonModel> personModels;

    public PersonAdapter() {
    }

    @NonNull
    @Override
    public PersonAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items , parent , false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.MyViewHolder holder, int position) {

        holder.textViewNumber.setText(personModels.get(position).getNumber());
        holder.textViewName.setText(personModels.get(position).getName());
    }

    @Override
    public int getItemCount() {
        if(personModels!=null)
        return personModels.size();
        else  return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewNumber;
        TextView textViewName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textview_name);
            textViewNumber = itemView.findViewById(R.id.textview_number);
        }
    }

    public void setData(ArrayList<PersonModel> personModels){
        this.personModels = personModels;
        notifyDataSetChanged();
    }

}
