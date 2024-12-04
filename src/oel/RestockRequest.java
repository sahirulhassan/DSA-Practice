package oel;

class RestockRequest {
    private final int productId;
    private final int priority;

    public RestockRequest(int productId, int priority) {
        this.productId = productId;
        this.priority = priority;
    }

    public int getProductId() {
        return productId;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "RestockRequest [Product ID: " + productId + ", Priority: " + priority + "]";
    }
}
