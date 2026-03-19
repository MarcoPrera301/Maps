import java.util.*;

public class StockManager {

    private Map<String, Integer> stock;
    private InventoryManager inventoryManager;

    public StockManager(Map<String, Integer> stock, InventoryManager inventoryManager) {
        this.stock = stock;
        this.inventoryManager = inventoryManager;
    }

    public void addProduct(String product, int quantity) {
        if (!inventoryManager.hasProduct(product)) {
            System.out.println("Producto no existe en el inventario");
            return;
        }

        stock.put(product, stock.getOrDefault(product, 0) + quantity);
        System.out.println("Producto agregado.");
    }

    public void showStockData() {
        for(Map.Entry<String, Integer> entry : stock.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            String category = inventoryManager.getCategory(product);

            System.out.println(product + " | " + category + " | " + quantity);
        }
    }

    public void showStockDataByCategory() {
        stock.entrySet().stream()
            .sorted((a, b) -> {
                String categoryA = inventoryManager.getCategory(a.getKey());
                String categoryB = inventoryManager.getCategory(b.getKey());
                return categoryA.compareTo(categoryB);
            })
            .forEach(entry -> {
                String product = entry.getKey();
                int quantity = entry.getValue();
                String category = inventoryManager.getCategory(product);

                System.out.println(product + " | " + category + " | " + quantity);
            });
    }
}

