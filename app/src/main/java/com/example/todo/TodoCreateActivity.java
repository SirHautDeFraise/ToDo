package com.example.todo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class TodoCreateActivity extends AppCompatActivity {
    EditText task;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_create);

        task=(EditText)findViewById(R.id.editTask);
        add=(Button)findViewById(R.id.btnAdd);
        add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String message=task.getText().toString();
                Intent intent=new Intent();
                intent.putExtra("MESSAGE",message);
                setResult(2,intent);
                finish();//finishing activity
            }
        });

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);

        List<String> listSpin = new ArrayList<String>();
        listSpin.add("Urgence Basse");
        listSpin.add("Urgence Moyenne");
        listSpin.add("Urgence Grande");

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