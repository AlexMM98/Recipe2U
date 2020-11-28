package Entidades;
import java.util.HashMap;

public class SingletonMap extends HashMap<String,DatabaseApp>{

    private static class SingletonHolder {
        private static final SingletonMap instance = new SingletonMap();
    }

    private SingletonMap() {}

    public static SingletonMap getInstance() {
        return SingletonHolder.instance;
    }
}
