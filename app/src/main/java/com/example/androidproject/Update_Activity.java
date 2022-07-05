package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

//adding activity basically!!

public class Update_Activity extends AppCompatActivity {

    Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        button1=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        /**
         * button1 represents ADD button
         */
        button1.setOnClickListener(view -> {
            startActivity(new Intent(Update_Activity.this,AddingInfo.class));
        });

        /**
         * button2 represents VIEW button
         */

        button2.setOnClickListener(view -> {
            startActivity(new Intent(Update_Activity.this,ViewInfo.class));
        });



    }
}