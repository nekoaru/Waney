package com.ecom.fintech.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.ecom.fintech.R;
import com.ecom.fintech.domain.Fintech;

public class AddFintech extends AppCompatActivity {

    private Spinner spinnerCategory;
    private EditText editTextCash;
    private EditText editTextComment;
    private Spinner spinnerDate;
    private Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fintech);

        spinnerCategory = findViewById(R.id.spinnerCategory);
        spinnerDate = findViewById(R.id.spinnerData);
        editTextCash = findViewById(R.id.editTextCash);
        editTextComment = findViewById(R.id.editTextComment);
        buttonAdd = findViewById(R.id.buttonAdd);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = spinnerCategory.getSelectedItem().toString();
                String cash = editTextCash.getText().toString().trim();
                String comment = editTextComment.getText().toString().trim();
                String date = spinnerDate.getSelectedItem().toString().trim();

                Fintech fintech = new Fintech(category, cash, comment, date);
                MainActivity.fintechList.add(fintech);

                Intent intent = new Intent(AddFintech.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}