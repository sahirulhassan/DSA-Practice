package oel;

class Product {
    int id;

    public Product(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "oel.Product ID: " + id;
    }
}
