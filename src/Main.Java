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

        Map<String, String> inventory = MapFactory.getMap(option);
        Map<String, Integer> stock = MapFactory.getMap(option);

        InventoryManager Imanager = new InventoryManager(inventory);
        StockManager Smanager = new StockManager(stock, Imanager);

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
                    System.out.print("Ingrese el producto: ");
                    String product = sc.nextLine().trim().toLowerCase();
                    Smanager.addProduct(product, 1);
                    break;
                case 2:
                    System.out.print("Ingrese el producto: ");
                    String product2 = sc.nextLine().trim().toLowerCase();
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
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }


        }


    }
}