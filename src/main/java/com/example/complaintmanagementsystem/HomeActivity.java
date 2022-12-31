package com.example.complaintmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeActivity extends AppCompatActivity {
    FloatingActionButton mAddFab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mAddFab = findViewById(R.id.add_person_fab);

        mAddFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "Fill Up the form to Add complain", Toast.LENGTH_SHORT).show();
                Intent intent  = new Intent(getApplicationContext(), AddComplain.class);
                startActivity(intent);
            }
        });
    }
}