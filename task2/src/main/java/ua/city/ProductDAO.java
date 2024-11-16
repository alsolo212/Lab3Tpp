package ua.city;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO {

    // Insert (Create)
    public void insertProduct(String productName, double price) {
        String sql = "INSERT INTO productt (productName, price) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, productName);
            pstmt.setDouble(2, price);
            pstmt.executeUpdate();
            System.out.println("Product inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Select all (Read)
    public void getAllProducts() {
        String sql = "SELECT * FROM productt";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("product_id") +
                        ", Name: " + rs.getString("productName") +
                        ", Price: " + rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update
    public void updateProduct(int productId, String newProductName, double newPrice) {
        String sql = "UPDATE productt SET productName = ?, price = ? WHERE product_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newProductName);
            pstmt.setDouble(2, newPrice);
            pstmt.setInt(3, productId);
            pstmt.executeUpdate();
            System.out.println("Product updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteProduct(int productId) {
        String sql = "DELETE FROM productt WHERE product_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, productId);
            pstmt.executeUpdate();
            System.out.println("Product deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
