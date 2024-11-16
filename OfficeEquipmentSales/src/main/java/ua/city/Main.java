package ua.city;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        CityDAO cityDAO = new CityDAO();
        ShopDAO shopDAO = new ShopDAO();
        ProductDAO productDAO = new ProductDAO();

        // Додавання нового міста
        City city = new City();
        city.setCityName("Kharkiv");
        int cityId = cityDAO.addCity(city);
        System.out.println("Додано місто з ID: " + cityId);

        // Додавання нового магазину
        Shop shop = new Shop();
        shop.setShopName("Shop4");
        int shopId = shopDAO.addShop(shop);
        System.out.println("Додано магазин з ID: " + shopId);

        // Додавання нового продукту
        Product product = new Product();
        product.setProductName("Laptop");
        product.setPrice(1200.50);
        int productId = productDAO.addProduct(product);
        System.out.println("Додано продукт з ID: " + productId);

        // Отримання та виведення списку всіх міст
        System.out.println("\nСписок міст:");
        List<City> cities = cityDAO.getAllCities();
        for (City c : cities) {
            System.out.println("ID: " + c.getCityId() + ", Назва: " + c.getCityName());
        }

        // Отримання та виведення списку всіх магазинів
        System.out.println("\nСписок магазинів:");
        List<Shop> shops = shopDAO.getAllShops();
        for (Shop s : shops) {
            System.out.println("ID: " + s.getShopId() + ", Назва: " + s.getShopName());
        }

        // Отримання та виведення списку всіх продуктів
        System.out.println("\nСписок продуктів:");
        List<Product> products = productDAO.getAllProducts();
        for (Product p : products) {
            System.out.println("ID: " + p.getProductId() + ", Назва: " + p.getProductName() + ", Ціна: " + p.getPrice());
        }
    }
}
