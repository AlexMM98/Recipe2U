package Entidades;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Categorias {

    @PrimaryKey(autoGenerate = true)
    public int categoriaId;

    @ColumnInfo(name = "nombre")
    public String nombre;
}
