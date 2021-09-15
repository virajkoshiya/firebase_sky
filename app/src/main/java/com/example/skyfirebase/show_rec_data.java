package com.example.skyfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class show_rec_data extends AppCompatActivity {
    private RecyclerView rec;
    public  ArrayList<model> dataa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_rec_data);
        rec = (RecyclerView) findViewById(R.id.rec);
        dataa = new ArrayList<>();


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("student");
      //  DatabaseReference childref = FirebaseDatabase.getInstance().getReference().child("id");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataa.clear();
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String id=snapshot1.getKey().toString();
                    DataSnapshot det=snapshot1.child("details");
                    DataSnapshot num=snapshot1.child("mob");
                    DataSnapshot name=snapshot1.child("name");

                    String details = det.getValue().toString();
                    String number = num.getValue().toString();
                    String namee = name.getValue().toString();

                    model m = new model(id,details,number,namee);

                    m.setM_mob(number);
                    m.setM_id(id);
                    m.setM_details(details);
                    m.setM_name(namee);

                 //   Log.e("data", "onDataChange: "+number);
                    dataa.add(m);



                }
                rec.setLayoutManager(new LinearLayoutManager(show_rec_data.this));
                rec.setAdapter(new adpter_model(dataa));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



//        rec.setLayoutManager(new LinearLayoutManager(this));
//        rec.setAdapter(new adpter_model(dataa));

    }
}