package Entidades;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(primaryKeys = { "ingId", "recId" },
        foreignKeys = {
                @ForeignKey(entity = Ingredientes.class,
                        parentColumns = "ingredienteId",
                        childColumns = "ingId"),
                @ForeignKey(entity = Recetas.class,
                        parentColumns = "recetaId",
                        childColumns = "recId")
        })
public class IngredientesRecetas {

    public final int ingId;
    public final int recId;

    public IngredientesRecetas(int ingId, int recId) {
        this.ingId = ingId;
        this.recId = recId;
    }
}
