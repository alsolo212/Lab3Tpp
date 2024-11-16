package ua.city;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShopDAO {
    // Insert (Create)
    public void insertShop(String shopName) {
        String sql = "INSERT INTO shopp (shopName) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, shopName);
            pstmt.executeUpdate();
            System.out.println("Shop inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Select all (Read)
    public void getAllShops() {
        String sql = "SELECT * FROM shopp";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Shop ID: " + rs.getInt("shop_id") + ", Name: " + rs.getString("shopName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update
    public void updateShop(int shopId, String newShopName) {
        String sql = "UPDATE shopp SET shopName = ? WHERE shop_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newShopName);
            pstmt.setInt(2, shopId);
            pstmt.executeUpdate();
            System.out.println("Shop updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteShop(int shopId) {
        String sql = "DELETE FROM shopp WHERE shop_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, shopId);
            pstmt.executeUpdate();
            System.out.println("Shop deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
