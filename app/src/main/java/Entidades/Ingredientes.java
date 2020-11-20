package Entidades;

public class Ingredientes {

    private int id;
    private String nombre;
    private Categorias categorias;

    public Ingredientes(String nombre, Categorias categorias, int id) {
        this.nombre = nombre;
        this.categorias = categorias;
        this.id =id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public Categorias getCategorias() {
        return categorias;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }
}
