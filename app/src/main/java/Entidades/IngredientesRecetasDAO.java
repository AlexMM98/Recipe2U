package Entidades;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface IngredientesRecetasDAO {

    @Query("SELECT * FROM Ingredientes INNER JOIN IngredientesRecetas ON " +
            "Ingredientes.ingredienteId=IngredientesRecetas.ingId " +
            "WHERE IngredientesRecetas.recId=:recId")
    List<Ingredientes> getIngredientesForReceta(int recId);

    @Query("SELECT * FROM Recetas INNER JOIN IngredientesRecetas ON " +
            "Recetas.recetaId=IngredientesRecetas.recId " +
            "WHERE IngredientesRecetas.ingId=:ingId")
    List<Recetas> getRecetasForIngrediente(int ingId);

    @Insert
    void insertAll(IngredientesRecetas... ingredientesReceta);
}
