package com.example.recipe2u;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import Entidades.DatabaseApp;
import Entidades.Ingredientes;
import Entidades.IngredientesDAO;
import Entidades.IngredientesRecetas;
import Entidades.IngredientesRecetasDAO;
import Entidades.Recetas;
import Entidades.RecetasDAO;
import Entidades.SingletonMap;

public class recipe2UCreateRecipe extends AppCompatActivity {
    private static final String DB_NAME = "dbEmpotrados";
    public static DatabaseApp db;
    private Bitmap imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe2_u_create_recipe);

        TextView txt = (TextView) findViewById(R.id.TAdd);

        Button bPescado = (Button) findViewById(R.id.bPescado);
        Button bCarne = (Button) findViewById(R.id.bCarnes);
        Button bVegetal = (Button) findViewById(R.id.bVegetales);
        Button bEspecia = (Button) findViewById(R.id.bEspecias);
        Button bLacteo = (Button) findViewById(R.id.bLacteos);

        Button butNuevoIngrediente = (Button) findViewById(R.id.BAddIngrediente);
        Button butImagen = (Button) findViewById(R.id.BImagen);
        Button butAceptar = (Button) findViewById(R.id.BAceptar);
        EditText tNombreReceta = (EditText) findViewById(R.id.NombreReceta);
        EditText tDescripcion = (EditText) findViewById(R.id.TDescripcion);

        db = (DatabaseApp) SingletonMap.getInstance().get(DB_NAME);
        if (db == null){
            db = Room.databaseBuilder(
                    getApplicationContext(),
                    DatabaseApp.class,
                    DB_NAME).allowMainThreadQueries().build();

            SingletonMap.getInstance().put(DB_NAME, db);
        }

        IngredientesDAO dao = db.getIngredientesDAO();
        //////////////////////PESCADOS///////////////////////////////
        List<Ingredientes> LingsP = dao.findByCategoria(1);
        String[] ingP = new String[LingsP.size()];
        int c =0;
        for(Ingredientes i :LingsP){
            ingP[c]= i.nombre;
            c++;
        }

        AlertDialog.Builder builderP = new AlertDialog.Builder(this);
        builderP.setTitle("Selecciona pescados");

        boolean[] checkedPescados = new boolean[LingsP.size()];
        builderP.setMultiChoiceItems(ingP, checkedPescados, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Toast.makeText(getApplicationContext(),
                        "Position: " + which + " Value: " + ingP[which] + " State: " + (isChecked ? "checked" : "unchecked"),
                        Toast.LENGTH_LONG).show();
            }
        });

        builderP.setPositiveButton("aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        bPescado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = builderP.create();
                dialog.show();
            }
        });

        //////////////////////CARNES///////////////////////////////
        List<Ingredientes> LingsC = dao.findByCategoria(2);
        String[] ingC = new String[LingsC.size()];
        c =0;
        for(Ingredientes i :LingsC){
            ingC[c]= i.nombre;
            c++;
        }

        AlertDialog.Builder builderC = new AlertDialog.Builder(this);
        builderC.setTitle("Selecciona carnes");

        boolean[] checkedCarnes = new boolean[LingsC.size()];
        builderC.setMultiChoiceItems(ingC, checkedCarnes, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Toast.makeText(getApplicationContext(),
                        "Position: " + which + " Value: " + ingC[which] + " State: " + (isChecked ? "checked" : "unchecked"),
                        Toast.LENGTH_LONG).show();
            }
        });

        builderC.setPositiveButton("aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        bCarne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = builderC.create();
                dialog.show();
            }
        });

        //////////////////////VEGETAL///////////////////////////////
        List<Ingredientes> LingsV = dao.findByCategoria(3);
        String[] ingV = new String[LingsV.size()];
        c =0;
        for(Ingredientes i :LingsV){
            ingV[c]= i.nombre;
            c++;
        }

        AlertDialog.Builder builderV = new AlertDialog.Builder(this);
        builderV.setTitle("Selecciona vegetales");

        boolean[] checkedVegetales = new boolean[LingsV.size()];
        builderV.setMultiChoiceItems(ingV, checkedVegetales, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Toast.makeText(getApplicationContext(),
                        "Position: " + which + " Value: " + ingV[which] + " State: " + (isChecked ? "checked" : "unchecked"),
                        Toast.LENGTH_LONG).show();
            }
        });

        builderV.setPositiveButton("aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        bVegetal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = builderV.create();
                dialog.show();
            }
        });

        //////////////////////ESPECIAS///////////////////////////////
        List<Ingredientes> LingsE = dao.findByCategoria(4);
        String[] ingE = new String[LingsE.size()];
        c =0;
        for(Ingredientes i :LingsE){
            ingE[c]= i.nombre;
            c++;
        }

        AlertDialog.Builder builderE = new AlertDialog.Builder(this);
        builderE.setTitle("Selecciona especias");

        boolean[] checkedEspecias = new boolean[LingsE.size()];
        builderE.setMultiChoiceItems(ingE, checkedEspecias, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Toast.makeText(getApplicationContext(),
                        "Position: " + which + " Value: " + ingE[which] + " State: " + (isChecked ? "checked" : "unchecked"),
                        Toast.LENGTH_LONG).show();
            }
        });

        builderE.setPositiveButton("aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        bEspecia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = builderE.create();
                dialog.show();
            }
        });

        //////////////////////LACTEOS///////////////////////////////
        List<Ingredientes> LingsL = dao.findByCategoria(5);
        String[] ingL = new String[LingsL.size()];
        c =0;
        for(Ingredientes i :LingsL){
            ingL[c]= i.nombre;
            c++;
        }

        AlertDialog.Builder builderL = new AlertDialog.Builder(this);
        builderL.setTitle("Selecciona lacteos");

        boolean[] checkedLacteos = new boolean[LingsL.size()];
        builderL.setMultiChoiceItems(ingL, checkedLacteos, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Toast.makeText(getApplicationContext(),
                        "Position: " + which + " Value: " + ingL[which] + " State: " + (isChecked ? "checked" : "unchecked"),
                        Toast.LENGTH_LONG).show();
            }
        });

        builderL.setPositiveButton("aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        bLacteo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = builderL.create();
                dialog.show();
            }
        });

        butNuevoIngrediente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(v.getContext(), recipe2UCreateIngredient.class);
                startActivityForResult(intent2, 0);
            }
        });

        butImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Intent.ACTION_PICK);
                intent3.setType("image/*");
                startActivityForResult(intent3, 1);
            }
        });



        butAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);

                RecetasDAO rDao = db.getRecetasDAO();
                IngredientesRecetasDAO irDao = db.getIngredientesRecetasDAO();
                Recetas nueva = new Recetas();
                nueva.nombre = String.valueOf(tNombreReceta.getText());
                nueva.descripcion = String.valueOf(tDescripcion.getText());
                nueva.picture = imagen;
                rDao.insertAll(nueva);

                List<Ingredientes> añadir = new ArrayList<Ingredientes>();
                for (int i =0; i< checkedPescados.length; i++){
                    if(checkedPescados[i]) añadir.add(LingsP.get(i));
                }
                for(int i =0; i< checkedCarnes.length; i++){
                    if(checkedCarnes[i]) añadir.add(LingsC.get(i));
                }
                for(int i =0; i< checkedVegetales.length; i++){
                    if(checkedVegetales[i]) añadir.add(LingsV.get(i));
                }
                for(int i =0; i< checkedEspecias.length; i++){
                    if(checkedEspecias[i]) añadir.add(LingsE.get(i));
                }
                for(int i =0; i< checkedLacteos.length; i++){
                    if(checkedLacteos[i]) añadir.add(LingsL.get(i));
                }
                nueva = (Recetas) rDao.findByName(String.valueOf(tNombreReceta.getText())).get(0);

                for(Ingredientes i: añadir){
                    IngredientesRecetas ir = new IngredientesRecetas(i.ingredienteId, nueva.recetaId);
                    irDao.insertAll(ir);
                }

                String msg1 = ("Receta creada correctamente");
                Toast.makeText(getApplicationContext(), msg1 , Toast.LENGTH_SHORT).show();
                startActivityForResult(intent, 0);
            }
        });
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK){
            Uri uri = data.getData();
            final InputStream imageStream;
            try {
                imageStream = getContentResolver().openInputStream(uri);
                imagen = BitmapFactory.decodeStream(imageStream);

                String msg = ("Imagen guardada");
                Toast.makeText(getApplicationContext(), msg , Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //image.setImageBitmap(selectedImage);
        }
    }
    }
