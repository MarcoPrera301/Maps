import java.util.*;

public class Main {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //interaccion usuario y estructura
        System.out.println("\n--- Seleccion de estructura ---");
            System.out.println("1. HashMap");
            System.out.println("2. TreeMap");
            System.out.println("3. LinkedHashMap");

        int option;

        try {
                option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                option = 1;
            }

        Map<String, String> inventory=MapFactory.getMap(option);
        Map<String, Integer> stock=MapFactory.getMap(option);

        String[] data = ReadFile.readLines("ListadoProducto.txt");

        for (String line : data) 
            {
                String[] parts = line.split("\\|");

                String category = parts[0].trim().toLowerCase();
                String product = parts[1].trim().toLowerCase();

                // inventory: producto -> categoria
                inventory.put(product, category);

                // stock: producto -> 0
                stock.put(product, 0);
            }

        StockManager Smanager = new StockManager(stock);
        InventoryManager Imanager = new InventoryManager(inventory);

        //interaccion usuario con inventario y stock

        option=-1;

        while(option!=0){
            System.out.println("\n--- MENU ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar categoria de producto");
            System.out.println("3. Mostrar coleccion");
            System.out.println("4. Mostrar coleccion ordenada por categoria");
            System.out.println("5. Mostrar inventario");
            System.out.println("6. Mostrar inventario ordenado");
            System.out.println("0. Salir");
            System.out.print("Seleccione opción: ");

        try {
                option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Entrada inválida");
                continue;
            }

            switch(option){
                case 1: 
                String product="";
                Smanager.addProduct(product);
                break;
                case 2:
                String product2="";
                Imanager.showCategory(product2);
                break;
                case 3:
                Smanager.showStockData();
                break;
                case 4:
                Smanager.showStockDataByCategory();
                break;
                case 5:
                Imanager.showInventory();
                break;
                case 6:
                Imanager.showInventoryByCategory();
                break;
            }


        }


    }
}