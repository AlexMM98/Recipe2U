package com.example.recipe2u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdminSQLiteOpenHelper conn = new AdminSQLiteOpenHelper(this, "bd_recetas", null, 1);

        Button bBuscar = (Button) findViewById(R.id.BBuscar);
        Button bAnyadir = (Button) findViewById(R.id.BAdd);

        //bBuscar.setOnClickListener(new OnClickListener()){

        //}

        bAnyadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), recipe2UCreateRecipe.class);
                startActivityForResult(intent, 0);
            }
        });
        }
    }