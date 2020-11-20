package com.example.recipe2u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class recipe2UCreateRecipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe2_u_create_recipe);

        TextView txt = (TextView) findViewById(R.id.TAdd);
        Spinner spnV = (Spinner) findViewById(R.id.SVerdura);
        Spinner spnC = (Spinner) findViewById(R.id.SCarne);
        Spinner spnP = (Spinner) findViewById(R.id.SPescado);
        Spinner spnL = (Spinner) findViewById(R.id.SLacteo);
        Spinner spnE = (Spinner) findViewById(R.id.SEspecia);
        Button butNuevoIngrediente = (Button) findViewById(R.id.BAddIngrediente);
        Button butImagen = (Button) findViewById(R.id.BImagen);
        Button butAceptar = (Button) findViewById(R.id.BAceptar);
        EditText tNombreReceta = (EditText) findViewById(R.id.NombreReceta);
        EditText tDescripcion = (EditText) findViewById(R.id.TDescripcion);

        butNuevoIngrediente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(v.getContext(), recipe2UCreateIngredient.class);
                startActivityForResult(intent2, 0);
            }
        });
        }
    }
