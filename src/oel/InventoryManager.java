package oel;

import java.util.*;

class InventoryManager {
    private List<Bin> bins;
    private PriorityQueue<RestockRequest> restockQueue;
    private final int binCapacity;

    public InventoryManager(int binCapacity) {
        this.bins = new ArrayList<>();
        this.restockQueue = new PriorityQueue<>(Comparator.comparingInt(RestockRequest::getPriority).reversed());
        this.binCapacity = binCapacity;
    }

    public void addProduct(int productId) {
        Product product = new Product(productId);

        // Add to the first bin with available space
        for (Bin bin : bins) {
            if (!bin.isFull()) {
                bin.addProduct(product);
                return;
            }
        }

        // Create a new bin if none have space
        Bin newBin = new Bin(binCapacity);
        newBin.addProduct(product);
        bins.add(newBin);
    }

    public Product retrieveProduct() {
        if (bins.isEmpty()) {
            throw new NoSuchElementException("No products available for retrieval");
        }

        // Retrieve from the oldest bin
        Product product = bins.get(0).removeProduct();

        // Remove bin if it becomes empty
        if (bins.get(0).isEmpty()) {
            bins.remove(0);
        }

        return product;
    }

    public void addRestockRequest(int productId, int priority) {
        restockQueue.add(new RestockRequest(productId, priority));
    }

    public void processRestocks() {
        while (!restockQueue.isEmpty()) {
            RestockRequest request = restockQueue.poll();
            addProduct(request.getProductId());
            System.out.println("Restocked: " + request);
        }
    }

    public void queryInventoryState() {
        System.out.println("Inventory State:");
        System.out.println("Total Bins: " + bins.size());
        for (int i = 0; i < bins.size(); i++) {
            System.out.println("Bin " + (i + 1) + ": " + bins.get(i).getSize() + " products");
        }

        System.out.println("Restock Requests:");
        for (RestockRequest request : restockQueue) {
            System.out.println(request);
        }
    }
}
