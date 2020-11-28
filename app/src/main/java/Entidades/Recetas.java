package Entidades;

import android.graphics.Bitmap;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Recetas {

    @PrimaryKey(autoGenerate = true)
    public int recetaId;

    @ColumnInfo(name = "nombre")
    public String nombre;

    @ColumnInfo(name = "descripcion")
    public String descripcion;

    @Ignore
    public Bitmap picture;

}
