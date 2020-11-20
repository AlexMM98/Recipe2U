package com.example.recipe2u;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Categorias (idCategoria INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT)");
        db.execSQL("CREATE TABLE Ingredientes (idIngrediente INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, FOREIGN KEY(idCategoria) REFERENCES Categoria(idCategoria))");
        db.execSQL("CREATE TABLE Recetas (idReceta int PRIMARY KEY AUTOINCREMENT, nombre TEXT, descripcion TEXT)");
        db.execSQL("CREATE TABLE IngredientesRecetas (idIngredientesRecetas INTEGER PRIMARY KEY AUTOINCREMENT, FOREIGN KEY(idIngrediente) REFERENCES Ingredientes(idIngrediente), FOREIGN KEY (idReceta) REFERENCES Recetas(idReceta))");

        db.execSQL("INSERT INTO Categorias (idCategoria,nombre) VALUES (1,'Carne') ");
        db.execSQL("INSERT INTO Categorias (idCategoria,nombre) VALUES (2,'Pescado') ");
        db.execSQL("INSERT INTO Categorias (idCategoria,nombre) VALUES (3,'Vegetales') ");
        db.execSQL("INSERT INTO Categorias (idCategoria,nombre) VALUES (4,'Especias') ");
        db.execSQL("INSERT INTO Categorias (idCategoria,nombre) VALUES (5,'Lacteos') ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Categorias");
        onCreate(db);
    }
}
