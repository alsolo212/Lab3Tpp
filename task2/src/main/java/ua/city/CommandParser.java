package ua.city;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandParser {
    private CityDAO cityDAO = new CityDAO();
    private ShopDAO shopDAO = new ShopDAO();
    private ProductDAO productDAO = new ProductDAO();

    public void executeCommand(String command) {
        if (command.startsWith("insert city")) {
            // Команда для додавання нового міста
            Pattern pattern = Pattern.compile("name='(.+?)'");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                String cityName = matcher.group(1);
                cityDAO.insertCity(cityName);
                System.out.println("Inserted city successfully.");
            } else {
                System.out.println("Invalid insert city command format.");
            }
        } else if (command.startsWith("update city")) {
            // Команда для оновлення назви міста
            Pattern pattern = Pattern.compile("id=(\\d+), name='(.+?)'");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int cityId = Integer.parseInt(matcher.group(1));
                String newCityName = matcher.group(2);
                cityDAO.updateCity(cityId, newCityName);
                System.out.println("Updated city successfully.");
            } else {
                System.out.println("Invalid update city command format.");
            }
        } else if (command.startsWith("delete city")) {
            // Команда для видалення міста за id
            Pattern pattern = Pattern.compile("id=(\\d+)");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int cityId = Integer.parseInt(matcher.group(1));
                cityDAO.deleteCity(cityId);
                System.out.println("Deleted city successfully.");
            } else {
                System.out.println("Invalid delete city command format.");
            }
        } else if (command.startsWith("read city")) {
            // Команда для зчитування всіх міст
            cityDAO.getAllCities();

        } else if (command.startsWith("insert shop")) {
            // Команда для додавання нового магазину
            Pattern pattern = Pattern.compile("name='(.+?)'");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                String shopName = matcher.group(1);
                shopDAO.insertShop(shopName);
                System.out.println("Inserted shop successfully.");
            } else {
                System.out.println("Invalid insert shop command format.");
            }
        } else if (command.startsWith("update shop")) {
            // Команда для оновлення назви магазину
            Pattern pattern = Pattern.compile("id=(\\d+), name='(.+?)'");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int shopId = Integer.parseInt(matcher.group(1));
                String newShopName = matcher.group(2);
                shopDAO.updateShop(shopId, newShopName);
                System.out.println("Updated shop successfully.");
            } else {
                System.out.println("Invalid update shop command format.");
            }
        } else if (command.startsWith("delete shop")) {
            // Команда для видалення магазину за id
            Pattern pattern = Pattern.compile("id=(\\d+)");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int shopId = Integer.parseInt(matcher.group(1));
                shopDAO.deleteShop(shopId);
                System.out.println("Deleted shop successfully.");
            } else {
                System.out.println("Invalid delete shop command format.");
            }
        } else if (command.startsWith("read shop")) {
            // Команда для зчитування всіх магазинів
            shopDAO.getAllShops();

        } else if (command.startsWith("insert product")) {
            // Команда для додавання нового продукту
            Pattern pattern = Pattern.compile("name='(.+?)', price=(\\d+(\\.\\d{1,2})?)");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                String productName = matcher.group(1);
                double price = Double.parseDouble(matcher.group(2));
                productDAO.insertProduct(productName, price);
                System.out.println("Inserted product successfully.");
            } else {
                System.out.println("Invalid insert product command format.");
            }
        } else if (command.startsWith("update product")) {
            // Команда для оновлення продукту
            Pattern pattern = Pattern.compile("id=(\\d+), name='(.+?)', price=(\\d+(\\.\\d{1,2})?)");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int productId = Integer.parseInt(matcher.group(1));
                String newProductName = matcher.group(2);
                double newPrice = Double.parseDouble(matcher.group(3));
                productDAO.updateProduct(productId, newProductName, newPrice);
                System.out.println("Updated product successfully.");
            } else {
                System.out.println("Invalid update product command format.");
            }
        } else if (command.startsWith("delete product")) {
            // Команда для видалення продукту за id
            Pattern pattern = Pattern.compile("id=(\\d+)");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int productId = Integer.parseInt(matcher.group(1));
                productDAO.deleteProduct(productId);
                System.out.println("Deleted product successfully.");
            } else {
                System.out.println("Invalid delete product command format.");
            }
        } else if (command.startsWith("read product")) {
            // Команда для зчитування всіх продуктів
            productDAO.getAllProducts();

        } else {
            System.out.println("Unknown command. Please try again.");
        }
    }
}
