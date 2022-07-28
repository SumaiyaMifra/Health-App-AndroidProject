package com.example.androidproject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<Measurements>list;

    public MyAdapter(Context context, ArrayList<Measurements> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
       return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       final Measurements measurements=list.get(position);
        holder.ttime.setText(measurements.getTime());
        holder.tdate.setText(measurements.getDate());
        holder.tsystolic.setText(measurements.getSystolic());
        holder.tdayastolic.setText(measurements.getDayastolic());
        holder.tcomment.setText(measurements.getComment());
        holder.tbp.setText(measurements.getBp());
        holder.btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus=DialogPlus.newDialog(holder.ttime.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_dialog))
                        .setExpanded(true,1200)
                        .create();
                //dialogPlus.show();
                View view1=dialogPlus.getHolderView();
                EditText time,date,systolic,dayastolic,comment,bp;
                time=view1.findViewById(R.id.time);
                date=view1.findViewById(R.id.date);
                systolic=view1.findViewById(R.id.systolic);
                dayastolic=view1.findViewById(R.id.dayastolic);
                comment=view1.findViewById(R.id.comment);
                bp=view1.findViewById(R.id.bp);
                Button update=view1.findViewById(R.id.udate);
                time.setText(measurements.getTime());
                date.setText(measurements.getDate());
                systolic.setText(measurements.getSystolic());
                dayastolic.setText(measurements.getDayastolic());
                comment.setText(measurements.getComment());
                bp.setText(measurements.getBp());
                    int dd=Integer.parseInt(measurements.getDayastolic());
                int ss=Integer.parseInt(measurements.getSystolic());
                if(dd<60 || dd>90)
                {
                    dayastolic.setTextColor(Color.RED);
                }
                if(ss<90 || ss>140)
                {
                   systolic.setTextColor(Color.RED);
                }
                dialogPlus.show();
                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String id=measurements.getId().toString();
                        FirebaseDatabase.getInstance().getReference("Data").child(id).child("time").setValue(time.getText().toString());
                        FirebaseDatabase.getInstance().getReference("Data").child(id).child("date").setValue(date.getText().toString());
                        FirebaseDatabase.getInstance().getReference("Data").child(id).child("systolic").setValue(systolic.getText().toString());
                        FirebaseDatabase.getInstance().getReference("Data").child(id).child("dayastolic").setValue(dayastolic.getText().toString());
                        FirebaseDatabase.getInstance().getReference("Data").child(id).child("comment").setValue(comment.getText().toString());
                        FirebaseDatabase.getInstance().getReference("Data").child(id).child("bp").setValue(bp.getText().toString());
                        dialogPlus.dismiss();
                        Toast.makeText(holder.ttime.getContext(), "data updated",Toast.LENGTH_SHORT).show();
                    }
                });
                holder.btndelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder=new AlertDialog.Builder(holder.ttime.getContext());
                        builder.setTitle("Are you sure?");
                        builder.setMessage("Deleted data can't be undo");
                        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                               String id=measurements.getId().toString();
                                FirebaseDatabase.getInstance().getReference("Data").child(id).removeValue();

                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(holder.ttime.getContext(), "Cancelled",Toast.LENGTH_SHORT).show();

                            }
                        });
                        builder.show();
                    }
                });

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView ttime,tdate,tsystolic,tdayastolic,tcomment,tbp;
        Button btnedit,btndelete;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ttime=itemView.findViewById(R.id.time);
            tdate=itemView.findViewById(R.id.date);
           tsystolic=itemView.findViewById(R.id.systolic);
           tdayastolic=itemView.findViewById(R.id.dayastolic);
           tbp=itemView.findViewById(R.id.bp);
             tcomment=itemView.findViewById(R.id.comment);
             btnedit=(Button)itemView.findViewById(R.id.edit);
             btndelete=(Button)itemView.findViewById(R.id.delete);
        }
    }
}
