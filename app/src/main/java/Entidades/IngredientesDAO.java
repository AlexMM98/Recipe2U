package Entidades;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface IngredientesDAO {

    @Query("SELECT * FROM Ingredientes ORDER BY nombre ASC")
    List<Ingredientes> getAll();

    @Query("SELECT * FROM Ingredientes WHERE ingredienteId = (:ingredienteId)")
    Ingredientes findById(int ingredienteId);

    @Query("SELECT * FROM Ingredientes WHERE nombre = :name")
    List<Ingredientes> findByName(String name);

    @Query("SELECT * FROM Ingredientes WHERE categoria = :categoria")
    List<Ingredientes> findByCategoria(int categoria);

    @Insert
    void insertAll(Ingredientes... ingredientes);

    @Delete
    void delete(Ingredientes ingredientes);
}
