package com.example.recipe2u;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Room;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import Entidades.DatabaseApp;
import Entidades.Recetas;
import Entidades.RecetasDAO;
import Entidades.SingletonMap;

public class recipe2USearch2 extends AppCompatActivity {
    private static final String DB_NAME = "dbEmpotrados";
    public static DatabaseApp db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe2_u_search2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = (DatabaseApp) SingletonMap.getInstance().get(DB_NAME);
        if (db == null){
            db = Room.databaseBuilder(
                    getApplicationContext(),
                    DatabaseApp.class,
                    DB_NAME).allowMainThreadQueries().build();

            SingletonMap.getInstance().put(DB_NAME, db);
        }

        ListView listRecetas = (ListView) findViewById(R.id.listRecetas);
        RecetasDAO dao = db.getRecetasDAO();

        List<Recetas> lRecetas = dao.getAll();
        String[] recetas = new String[lRecetas.size()];
        int c = 0;
        for(Recetas r : lRecetas){
            recetas[c]=r.nombre;
            c++;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, recetas);
        listRecetas.setAdapter(adapter);

        listRecetas.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = listRecetas.getItemAtPosition(position);
                Intent intent = new Intent (view.getContext(), recipe2UViewRecipe.class);
                intent.putExtra("nombre", o.toString());
                startActivityForResult(intent, 0);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (view.getContext(), recipe2UFilterRecipe.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}