package ua.city;

public class Product {
    private int productId; // Відповідає полю product_id в БД
    private String productName; // Відповідає полю productName в БД
    private double price; // Відповідає полю price в БД

    // Конструктор за замовченням
    public Product() {
    }

    // Конструктор з усіма параметрами
    public Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    // Геттери та сеттери
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}