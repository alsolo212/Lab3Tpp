package ua.city;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDAO {
    // Insert (Create)
    public void insertCity(String cityName) {
        String sql = "INSERT INTO cityy (cityName) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cityName);
            pstmt.executeUpdate();
            System.out.println("City inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Select all (Read)
    public void getAllCities() {
        String sql = "SELECT * FROM cityy";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("City ID: " + rs.getInt("city_id") +
                        ", Name: " + rs.getString("cityName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update
    public void updateCity(int cityId, String newCityName) {
        String sql = "UPDATE cityy SET cityName = ? WHERE city_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newCityName);
            pstmt.setInt(2, cityId);
            pstmt.executeUpdate();
            System.out.println("City updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteCity(int cityId) {
        String sql = "DELETE FROM cityy WHERE city_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cityId);
            pstmt.executeUpdate();
            System.out.println("City deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
