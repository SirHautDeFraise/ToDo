package com.example.todo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1=(TextView)findViewById(R.id.textView1);
        Intent intent=new Intent(MainActivity.this,TodoCreateActivity.class);
        startActivityForResult(intent, 2);// Activity is started with requestCode 2
    }
    // Call Back method  to get the Message form other Activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2)
        {
            String message=data.getStringExtra("MESSAGE");
            textView1.setText(message);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // On créer le Menu
        getMenuInflater().inflate(R.menu.menu_todo_create, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        // Try & Catch
        switch (item.getItemId()) {
            case R.id.createtodo:
                // On créer l'intent
                Intent intent = new Intent(getApplicationContext(), TodoCreateActivity.class);

                // On démarre l'activité
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}