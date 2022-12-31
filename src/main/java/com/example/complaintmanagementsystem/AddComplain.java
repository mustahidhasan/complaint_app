package com.example.complaintmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddComplain extends AppCompatActivity {
    EditText title, description;
    Button submit;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_complain);

        title = (EditText) findViewById(R.id.complain_title);
        description = (EditText) findViewById(R.id.complaint_description);
        submit = (Button) findViewById(R.id.btnsubmit);
        DB = new DBHelper(this);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String get_title = title.getText().toString();
                String get_description = description.getText().toString();
                Boolean insert = DB.insertComplaintData(get_title, get_description);
                if (insert == true){
                    Toast.makeText(AddComplain.this, "Complain Registered", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(AddComplain.this, "Complain Registration failed", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
}