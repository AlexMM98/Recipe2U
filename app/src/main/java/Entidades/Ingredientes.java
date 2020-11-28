package Entidades;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Categorias.class,
        parentColumns = "categoriaId",
        childColumns = "categoria",
        onDelete = 1))
public class Ingredientes {

    @PrimaryKey(autoGenerate = true)
    public int ingredienteId;

    @ColumnInfo(name = "nombre")
    public String nombre;

    @ColumnInfo(name = "categoria")
    public int categoria;

}
