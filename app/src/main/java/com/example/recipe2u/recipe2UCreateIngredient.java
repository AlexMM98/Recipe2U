package com.example.recipe2u;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

public class recipe2UCreateIngredient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe2_u_create_ingredient);

        EditText tNombreIngrediente = (EditText) findViewById(R.id.nombreIngrediente);
        Spinner spnCategorias = (Spinner) findViewById(R.id.SpnCategorias);
        Button btnAceptarIng = (Button) findViewById((R.id.BAceptarIng));

        AdminSQLiteOpenHelper con = new AdminSQLiteOpenHelper(this, "bd_categorias", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        String[] queryCols = {"idCategoria", "nombre"};
        String[] fromColumns = { "nombre" };
        int[] toViews = { android.R.id.text1 };

        Cursor cursor = db.query(true,"Categorias", queryCols,null,null,null,null,null,null);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_spinner_item,
                cursor,
                fromColumns,
                toViews,
                0);
        spnCategorias.setAdapter(adapter);

        //String[] lenguajes = {"Seleccione","Ruby","Java",".NET","Python","PHP","JavaScript","GO"};
        //spnCategorias.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,lenguajes));
    }

}