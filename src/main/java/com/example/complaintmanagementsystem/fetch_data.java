package com.example.complaintmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class fetch_data extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ComplainModel> dataholder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_data);
        recyclerView = (RecyclerView)findViewById(R.id.recv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor = new DBHelper(this).read_all_data();
        while(cursor.moveToNext()){
            ComplainModel obj = new ComplainModel(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            dataholder.add(obj);
        }
        MyAdapter adapter = new MyAdapter(dataholder);
        recyclerView.setAdapter(adapter);
    }
}