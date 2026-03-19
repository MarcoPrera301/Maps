import java.util.*;

public class InventoryManager {
    
    private Map<String, String> inventory;

    public InventoryManager(Map<String, String> inventory) {
        this.inventory = inventory;
        loadInventory();
    }

    private void loadInventory() {
        String[] data = ReadFile.readLines("ListadoProducto.txt");

        for (String line : data) {
            String[] parts = line.split("\\|");

            String category = parts[0];
            String product = parts[1];

            inventory.put(product, category);
        }
    }

    public void showCategory(String product) {
        if (inventory.containsKey(product)) {
            System.out.println("Categoría " + inventory.get(product));
        } else {
            System.out.println("Producto no encontrado");
        }
    }

    public void showInventory() {
        inventory.entrySet().stream().sorted(Map.Entry.comparingByValue())
            .forEach(e -> System.out.println(e.getKey() + "|" + e.getValue()));
    }

    public boolean hasProduct(String product) {
        return inventory.containsKey(product);
    }

    public String getCategory(String product) {
        return inventory.get(product);
    }
}
