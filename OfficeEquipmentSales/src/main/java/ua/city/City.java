package ua.city;

public class City {
    private int cityId; // Відповідає полю city_id у таблиці
    private String cityName; // Відповідає полю cityName у таблиці

    // Конструктор за замовчуванням
    public City() {}

    // Конструктор із параметрами
    public City(int cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    // Геттери та сетери
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
