package com.example.recipe2u;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

import Entidades.Categorias;
import Entidades.CategoriasDAO;
import Entidades.DatabaseApp;
import Entidades.Ingredientes;
import Entidades.IngredientesDAO;
import Entidades.SingletonMap;

public class recipe2UCreateIngredient extends AppCompatActivity{
    private static final String DB_NAME = "dbEmpotrados";
    public static DatabaseApp db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe2_u_create_ingredient);

        EditText tNombreIngrediente = (EditText) findViewById(R.id.nombreIngrediente);
        Spinner spnCategorias = (Spinner) findViewById(R.id.SpnCategorias);
        Button btnAceptarIng = (Button) findViewById((R.id.BAceptarIng));

        String[] queryCols = {"idCategoria", "nombre"};
        String[] fromColumns = { "nombre" };
        int[] toViews = { android.R.id.text1 };

        db = (DatabaseApp) SingletonMap.getInstance().get(DB_NAME);
        if (db == null){
            db = Room.databaseBuilder(
                    getApplicationContext(),
                    DatabaseApp.class,
                    DB_NAME).allowMainThreadQueries().build();

            SingletonMap.getInstance().put(DB_NAME, db);
        }

        CategoriasDAO dao = db.getCategoriasDAO();

        List<Categorias> listaCat = dao.getAll();
        String[] cats = new String[listaCat.size()];
        int i =0;

        for(Categorias c :listaCat){
            cats[i]= c.nombre;
            i++;
        }

        spnCategorias.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,cats));

        btnAceptarIng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), recipe2UCreateRecipe.class);

                String seleccion = spnCategorias.getSelectedItem().toString();
                Categorias sel = (Categorias) dao.findByName(seleccion).get(0);
                String txt = String.valueOf(tNombreIngrediente.getText());

                Ingredientes nuevo = new Ingredientes();
                nuevo.categoria=sel.categoriaId;
                nuevo.nombre=txt;
                IngredientesDAO daoI = db.getIngredientesDAO();
                daoI.insertAll(nuevo);

                String msg = ("Ingrediente creado correctamente");
                Toast.makeText(getApplicationContext(), msg , Toast.LENGTH_SHORT).show();
                startActivityForResult(intent, 0);
            }
        });
    }

}