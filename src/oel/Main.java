package oel;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventory = new InventoryManager(3);

        // Adding products
        inventory.addProduct(101);
        inventory.addProduct(102);
        inventory.addProduct(103);
        inventory.addProduct(104);

        // Query inventory state
        inventory.queryInventoryState();

        // Retrieve a product
        System.out.println("Retrieved: " + inventory.retrieveProduct());

        // Add restock requests
        inventory.addRestockRequest(105, 1);
        inventory.addRestockRequest(106, 2);

        // Process restocks
        inventory.processRestocks();

        // Query inventory state again
        inventory.queryInventoryState();
    }
}
