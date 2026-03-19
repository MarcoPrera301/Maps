import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class MapFactory {
    public static <K, V> Map<K, V> getMap(int opcion) {
        switch (opcion) {
            case 1: return new HashMap<>();
            case 2: return new TreeMap<>();
            case 3: return new LinkedHashMap<>();
            default: return new HashMap<>();
        }
    }
}