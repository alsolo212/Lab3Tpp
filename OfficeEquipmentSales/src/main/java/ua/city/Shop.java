package ua.city;

public class Shop {
    private int shopId; // Відповідає полю shop_id у базі даних
    private String shopName; // Відповідає полю shopName у базі даних

    // Конструктор за замовченням
    public Shop() {
    }

    // Конструктор із параметрами
    public Shop(int shopId, String shopName) {
        this.shopId = shopId;
        this.shopName = shopName;
    }

    // Геттери та сетери
    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopId=" + shopId +
                ", shopName='" + shopName + '\'' +
                '}';
    }
}
