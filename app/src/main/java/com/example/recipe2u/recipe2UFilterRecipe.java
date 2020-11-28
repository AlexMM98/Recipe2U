package com.example.recipe2u;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

import Entidades.DatabaseApp;
import Entidades.Recetas;
import Entidades.RecetasDAO;
import Entidades.SingletonMap;

public class recipe2UFilterRecipe extends AppCompatActivity {
    private static final String DB_NAME = "dbEmpotrados";
    public static DatabaseApp db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe2_u_filter_recipe);

        db = (DatabaseApp) SingletonMap.getInstance().get(DB_NAME);
        if (db == null){
            db = Room.databaseBuilder(
                    getApplicationContext(),
                    DatabaseApp.class,
                    DB_NAME).allowMainThreadQueries().build();

            SingletonMap.getInstance().put(DB_NAME, db);
        }

        EditText tNombre = (EditText) findViewById(R.id.tNombre);
        ListView listReceta = (ListView) findViewById(R.id.listReceta);
        RecetasDAO dao = db.getRecetasDAO();
        List<Recetas> lRecetas = dao.getAll();
        String[] recetas = new String[lRecetas.size()];
        int c = 0;
        for(Recetas r : lRecetas){
            recetas[c]=r.nombre;
            c++;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, recetas);
        listReceta.setAdapter(adapter);

        tNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        listReceta.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = listReceta.getItemAtPosition(position);
                Intent intent = new Intent (view.getContext(), recipe2UViewRecipe.class);
                intent.putExtra("nombre", o.toString());
                startActivityForResult(intent, 0);
            }
        });
    }
}