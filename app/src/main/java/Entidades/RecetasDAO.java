package Entidades;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RecetasDAO {

    @Query("SELECT * FROM Recetas ORDER BY nombre ASC")
    List<Recetas> getAll();

    @Query("SELECT * FROM Recetas WHERE recetaId = (:recetaId)")
    Recetas findById(int recetaId);

    @Query("SELECT * FROM Recetas WHERE nombre = :name")
    List<Recetas> findByName(String name);

    @Insert
    void insertAll(Recetas... receta);

    @Delete
    void delete(Recetas receta);
}
