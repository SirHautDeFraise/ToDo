package com.example.todo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class TodoCreateActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_create);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);

        List<String> listSpin = new ArrayList<String>();
        listSpin.add("Urgence basse");
        listSpin.add("Urgence grande");

        Spinner spinnerUrgency = (Spinner) findViewById(R.id.spinnerUrgency);

        ArrayAdapter<String> spinner = new ArrayAdapter<String>( TodoCreateActivity.this, android.R.layout.simple_spinner_item, listSpin);
        spinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUrgency.setAdapter(spinner);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}