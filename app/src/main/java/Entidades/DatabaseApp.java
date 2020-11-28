package Entidades;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Categorias.class, Ingredientes.class, Recetas.class, IngredientesRecetas.class}, version = 1)
public abstract class DatabaseApp extends RoomDatabase {
    // this should satisfy singletonMap approach
    public abstract CategoriasDAO getCategoriasDAO();
    public abstract IngredientesDAO getIngredientesDAO();
    public abstract RecetasDAO getRecetasDAO();
    public abstract IngredientesRecetasDAO getIngredientesRecetasDAO();
}
