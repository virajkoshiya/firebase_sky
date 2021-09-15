package com.example.skyfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private EditText edtId;
    private EditText edtName;
    private EditText edtMob;
    private EditText edtDetails;
    private Button button;
    private Button showData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtId = (EditText) findViewById(R.id.edt_id);
        edtName = (EditText) findViewById(R.id.edt_name);
        edtMob = (EditText) findViewById(R.id.edt_mob);
        edtDetails = (EditText) findViewById(R.id.edt_details);
        button = (Button) findViewById(R.id.button);

        showData = (Button) findViewById(R.id.show_data);
        // Write a message to the database


//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                String v = snapshot.getValue(String.class);
//                Log.d("vv", "Value is: " + v);
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id=edtId.getText().toString();
                String sname=edtName.getText().toString();
                String smob=edtMob.getText().toString();
                String sdetails=edtDetails.getText().toString();

                if (id.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Enter id", Toast.LENGTH_SHORT).show();
                }else {

                    data d = new data(sname,smob,sdetails);
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("student");
                    myRef.child(id).setValue(d);

                    Toast.makeText(MainActivity.this, "Data Sucessfully Entered", Toast.LENGTH_SHORT).show();

                }




            }
        });

        showData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,show_rec_data.class);
                startActivity(intent);

            }
        });
    }
}