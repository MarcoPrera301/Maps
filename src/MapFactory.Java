public class MapFactory {
    public static Map<String, String> getMap(String map) {

        String opcion = map.toLowerCase();
        switch (opcion) {
            case "hashmap": return new HashMap<>();
            case "treemap": return new TreeMap<>();
            case "linkedhashmap": return new LinkedHashMap<>();
            default: return new HashMap<>();
        }
    }
}