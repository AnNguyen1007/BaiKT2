package com.example.quanlyca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvCa;
    private ArrayList<Ca> cayXanhArrayList;
    private  CaAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvCa = findViewById(R.id.lvCa);

        cayXanhArrayList = new ArrayList<>();
        getData();
        adapter = new CaAdapter(this,R.layout.activity_listview,cayXanhArrayList);
        lvCa.setAdapter(adapter);

        lvCa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, DetailActivity.class);
                    startActivity(intent);
                } else if (i == 1){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, DetailActivity.class);
                    startActivity(intent);
                } else if (i == 2){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, DetailActivity.class);
                    startActivity(intent);
                }

            }
        });

    }
    private  void getData(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("QuanLyCa");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                adapter.clear();
                for(DataSnapshot data : snapshot.getChildren()){
                    Ca ca = data.getValue(Ca.class);
                    if(ca != null){
                        ca.setId(data.getKey());
                        adapter.add(ca);
                    }
                }
                Toast.makeText(getApplicationContext(),"Thành công !",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),"Thất bại !" + error.toString(),Toast.LENGTH_SHORT).show();
                Log.d("MYTAG","onCancelled: " + error.toString());
            }
        });
    }
}