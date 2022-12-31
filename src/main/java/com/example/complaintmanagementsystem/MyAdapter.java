package com.example.complaintmanagementsystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myviewholder>{
    ArrayList<ComplainModel> dataholder;

    public MyAdapter(ArrayList<ComplainModel> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);

        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.id.setText(dataholder.get(position).getId());
        holder.title.setText(dataholder.get(position).getTitle());
        holder.description.setText(dataholder.get(position).getDescription());


    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{
        TextView id, title, description;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            id = (TextView)itemView.findViewById(R.id.id_display);
            title = (TextView)itemView.findViewById(R.id.title_display);
            description = (TextView)itemView.findViewById(R.id.desc_display);
        }
    }
}
