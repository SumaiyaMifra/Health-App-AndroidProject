package com.example.androidproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewInfo extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    ArrayList<Measurements>list;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_info);
        recyclerView=findViewById(R.id.myrecycleview);

        databaseReference= FirebaseDatabase.getInstance().getReference();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot dataSnapshot:snapshot.child("Data").getChildren())

                {
                  String gtime=dataSnapshot.child("time").getValue(String.class);
                    String gdate=dataSnapshot.child("date").getValue(String.class);
                    String gsystolic=dataSnapshot.child("systolic").getValue(String.class);
                    String gdayastolic=dataSnapshot.child("dayastolic").getValue(String.class);
                    String gcomment=dataSnapshot.child("comment").getValue(String.class);
                    String gid=dataSnapshot.child("id").getValue(String.class);
                    String gbp=dataSnapshot.child("bp").getValue(String.class);
                    Measurements measurements=new Measurements(gid,gtime,gdate,gsystolic,gdayastolic,gbp,gcomment);
                    list.add(measurements);
                }
                myAdapter=new MyAdapter(ViewInfo.this,list);
                recyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}