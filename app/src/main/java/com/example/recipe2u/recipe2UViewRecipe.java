package com.example.recipe2u;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

import Entidades.DatabaseApp;
import Entidades.Ingredientes;
import Entidades.IngredientesRecetasDAO;
import Entidades.Recetas;
import Entidades.RecetasDAO;
import Entidades.SingletonMap;

public class recipe2UViewRecipe extends AppCompatActivity {
    private static final String DB_NAME = "dbEmpotrados";
    public static DatabaseApp db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe2_u_view_recipe);

        db = (DatabaseApp) SingletonMap.getInstance().get(DB_NAME);
        if (db == null){
            db = Room.databaseBuilder(
                    getApplicationContext(),
                    DatabaseApp.class,
                    DB_NAME).allowMainThreadQueries().build();

            SingletonMap.getInstance().put(DB_NAME, db);
        }

        TextView tNombreReceta = (TextView) findViewById(R.id.tNombreReceta);
        TextView tDescripcionReceta = (TextView) findViewById(R.id.tDescripcionReceta);
        ListView listIngredientes = (ListView) findViewById(R.id.listIngredientes4Recipe);
        ImageView image = (ImageView) findViewById(R.id.image);

        RecetasDAO dao = db.getRecetasDAO();
        IngredientesRecetasDAO irDao = db.getIngredientesRecetasDAO();
        String nombreReceta = getIntent().getStringExtra("nombre");
        Recetas receta = (Recetas) dao.findByName(nombreReceta).get(0);
        tNombreReceta.setText(nombreReceta);
        tDescripcionReceta.setText(receta.descripcion);
        image.setImageBitmap(receta.picture);
        List<Ingredientes> lIngredientes = irDao.getIngredientesForReceta(receta.recetaId);
        String[] ingredientes = new String[lIngredientes.size()];
        int c = 0;
        for(Ingredientes i : lIngredientes){
            ingredientes[c]=i.nombre;
            c++;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ingredientes);
        listIngredientes.setAdapter(adapter);
    }
}