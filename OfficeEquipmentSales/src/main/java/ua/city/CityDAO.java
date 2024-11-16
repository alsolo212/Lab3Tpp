package ua.city;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDAO {

    // Метод для додавання нового міста
    public int addCity(City city) {
        String sql = "INSERT INTO city (cityName) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // Встановлення параметра для запиту
            pstmt.setString(1, city.getCityName());
            pstmt.executeUpdate();

            // Отримання згенерованого ID
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // Повертаємо ID нового міста
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Повертаємо -1 у разі помилки
    }

    // Метод для отримання всіх міст
    public List<City> getAllCities() {
        List<City> cities = new ArrayList<>();
        String sql = "SELECT * FROM city";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                City city = new City();
                city.setCityId(rs.getInt("city_id"));
                city.setCityName(rs.getString("cityName"));
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    // Метод для оновлення назви міста
    public void updateCity(City city) {
        String sql = "UPDATE city SET cityName = ? WHERE city_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, city.getCityName());
            pstmt.setInt(2, city.getCityId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Метод для видалення міста за ID
    public void deleteCity(int id) {
        String sql = "DELETE FROM city WHERE city_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
