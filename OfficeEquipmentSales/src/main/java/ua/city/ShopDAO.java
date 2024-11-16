package ua.city;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShopDAO {

	// Метод для додавання нового магазину
	public int addShop(Shop shop) throws SQLException {
		String sql = "INSERT INTO shop (shopName) VALUES (?)";

		try (Connection conn = DatabaseConnection.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

			// Встановлення параметрів для запиту
			stmt.setString(1, shop.getShopName());

			// Виконання запиту
			int affectedRows = stmt.executeUpdate();

			// Перевірка, що вставка пройшла успішно та отримання згенерованого ID
			if (affectedRows == 0) {
				throw new SQLException("Створення магазину не вдалося, не додано жодного рядка.");
			}

			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					// Повертаємо згенерований ID
					return generatedKeys.getInt(1);
				} else {
					throw new SQLException("Створення магазину не вдалося, ID не отримано.");
				}
			}
		}
	}

	// Метод для отримання магазину за ID
	public Shop getShopById(int id) throws SQLException {
		String sql = "SELECT * FROM shop WHERE shop_id = ?";

		try (Connection conn = DatabaseConnection.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Shop(rs.getInt("shop_id"), rs.getString("shopName"));
			}
		}
		return null;
	}

	// Метод для оновлення інформації про магазин
	public void updateShop(Shop shop) throws SQLException {
		String sql = "UPDATE shop SET shopName = ? WHERE shop_id = ?";

		try (Connection conn = DatabaseConnection.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, shop.getShopName());
			stmt.setInt(2, shop.getShopId());
			stmt.executeUpdate();
		}
	}

	// Метод для отримання всіх магазинів
	public List<Shop> getAllShops() throws SQLException {
		List<Shop> shops = new ArrayList<>();
		String sql = "SELECT * FROM shop";

		try (Connection conn = DatabaseConnection.getConnection();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				shops.add(new Shop(rs.getInt("shop_id"), rs.getString("shopName")));
			}
		}
		return shops;
	}
}
