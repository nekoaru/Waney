package com.ecom.fintech.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ecom.fintech.R;
import com.ecom.fintech.data.RegisterActivity;
import com.ecom.fintech.domain.Fintech;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button buttonAddFintech;
    private FintechAdapter adapter;

    public static final ArrayList<Fintech> fintechList = new ArrayList<>();


    private FirebaseFirestore db;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        adapter = new FintechAdapter(fintechList, this);
        recyclerView = findViewById(R.id.recyclerView);
        buttonAddFintech = findViewById(R.id.buttonAddFintech);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        buttonAddFintech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddFintech.class);
                startActivity(intent);
            }
        });

        adapter.setOnNoteClickListener(new FintechAdapter.OnNoteClickListener() {
            @Override
            public void onNoteClick(int position) {
                Toast.makeText(MainActivity.this, "Держите, чтобы удалить запись ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(int position) {
                remove(position);
            }
        });
        if (mAuth.getCurrentUser() != null) {

        } else {
            signOut();
        }
    }
    private void signOut() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    private void remove(int position) {
        fintechList.remove(position);
        adapter.notifyDataSetChanged();
    }
}