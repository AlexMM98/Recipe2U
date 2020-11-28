package com.example.recipe2u;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import Entidades.Categorias;
import Entidades.CategoriasDAO;
import Entidades.DatabaseApp;
import Entidades.SingletonMap;

public class MainActivity extends AppCompatActivity {
    private static final String DB_NAME = "dbEmpotrados";
    public static DatabaseApp db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //AdminSQLiteOpenHelper conn = new AdminSQLiteOpenHelper(this, "bd_recetas", null, 1);
        db = (DatabaseApp) SingletonMap.getInstance().get(DB_NAME);

        if (db == null){
            db = Room.databaseBuilder(
                    getApplicationContext(),
                    DatabaseApp.class,
                    DB_NAME).allowMainThreadQueries().build();

            SingletonMap.getInstance().put(DB_NAME, db);

            CategoriasDAO dao = db.getCategoriasDAO();

            /*for(Categorias c : dao.getAll()){
                dao.delete(c);
            }*/

            //CategoriasDAO dao = db.getCategoriasDAO();
            if(dao.getAll().size()<5) {
                Categorias catP = new Categorias();
                catP.nombre = "Pescado";
                catP.categoriaId=1;
                Categorias catC = new Categorias();
                catC.nombre = "Carne";
                catC.categoriaId=2;
                Categorias catV = new Categorias();
                catV.nombre = "Vegetal";
                catV.categoriaId=3;
                Categorias catL = new Categorias();
                catL.nombre = "Lacteo";
                catL.categoriaId=5;
                Categorias catE = new Categorias();
                catE.nombre = "Especia";
                catE.categoriaId=4;

                dao.insertAll(catP, catC, catE, catV, catL);
            }/*else{
                for(Categorias c : dao.getAll()){
                    dao.delete(c);
                }
        }*/
        }

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

        bBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent (v.getContext(), recipe2USearch2.class);
                startActivityForResult(intent1, 0);
            }
        });
        }
    }