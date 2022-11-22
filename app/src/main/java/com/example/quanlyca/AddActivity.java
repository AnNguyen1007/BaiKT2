package com.example.quanlyca;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddActivity extends AppCompatActivity {

    private EditText edtTenKH, edtTenThuong, editDacTinh,edtMauLa;
    private Button btnThem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenKH = edtTenKH.getText().toString();
                String tenthuong = edtTenThuong.getText().toString();
                String dactinh = editDacTinh.getText().toString();
                String maula = edtMauLa.getText().toString();

                Ca ca = new Ca(tenKH,tenthuong,dactinh,maula);
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("QuanLyCa");
                String id = myRef.push().getKey();
                myRef.child(id).setValue(ca).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(getApplicationContext(),"Them thanh cong !",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Them that bai !",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

    private void addControls() {
        edtTenKH = findViewById(R.id.edtTkh);
        edtTenThuong = findViewById(R.id.edtTtg);
        editDacTinh = findViewById(R.id.edtDt);
        edtMauLa = findViewById(R.id.edtmau);

        btnThem = findViewById(R.id.btnAdd);
    }
}
