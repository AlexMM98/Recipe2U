package Entidades;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface CategoriasDAO {

    @Query("SELECT * FROM Categorias ORDER BY nombre ASC")
    List<Categorias> getAll();

    @Query("SELECT * FROM Categorias WHERE categoriaId = (:categoriaId)")
    Categorias findById(int categoriaId);

    @Query("SELECT * FROM Categorias WHERE nombre = :name")
    List<Categorias> findByName(String name);

    @Insert
    void insertAll(Categorias... categorias);

    @Delete
    void delete(Categorias categorias);
}
