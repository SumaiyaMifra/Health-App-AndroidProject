package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddingInfo extends AppCompatActivity {
    Button add;
    EditText etime,edate,esystolic,edayastolic,ecomment,ebp;
    DatabaseReference measure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_info);

        add=findViewById(R.id.add);
        ebp=findViewById(R.id.bp);
        etime=findViewById(R.id.time);
        edate=findViewById(R.id.date);
        esystolic=findViewById(R.id.systolic);
        edayastolic=findViewById(R.id.dayastolic);
        ecomment=findViewById(R.id.comment);
        measure= FirebaseDatabase.getInstance().getReference("Data");
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
        });
    }
    public void insertData(){
      String time=etime.getText().toString();
      String date=edate.getText().toString();
      String systolic=esystolic.getText().toString();
      String dayastolic=edayastolic.getText().toString();
      String comment=ecomment.getText().toString();
      String id=measure.push().getKey();
      String bp=ebp.getText().toString();
      etime.setText("");
      edate.setText("");
      esystolic.setText("");
      edayastolic.setText("");
      ecomment.setText("");

      Measurements measurements=new Measurements(id,time,date,systolic,dayastolic,bp,comment);
      measure.child(id).setValue(measurements);
        Toast.makeText(AddingInfo.this,"Data inserted!",Toast.LENGTH_SHORT).show();
    }
}