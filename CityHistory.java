package WeatherAppPack;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CityHistory {
    private int historicalDataId;
    private int cityId;
    private Date eventDate;
    private double temperature;

    public CityHistory() {
    }

    public CityHistory(int historicalDataId, int cityId, Date eventDate, double temperature) {
        this.historicalDataId = historicalDataId;
        this.cityId = cityId;
        this.eventDate = eventDate;
        this.temperature = temperature;
    }

    

    public static List<CityHistory> readCityHistory(Connection connection, String cityName) throws SQLException {
        List<CityHistory> history = new ArrayList<>();
        String sql = "SELECT * FROM city_history WHERE city_id IN (SELECT city_id FROM cities WHERE city_name = ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cityName);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    history.add(new CityHistory(resultSet.getInt("historical_data_id"), resultSet.getInt("city_id"),
                            resultSet.getDate("event_date"), resultSet.getDouble("temperature")));
                }
            }
        }
        return history;
    }

    public void updateHistoricalRecord(Connection connection) throws SQLException {
        String sql = "UPDATE city_history SET temperature = ? WHERE historical_data_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, temperature);
            statement.setInt(2, historicalDataId);
            statement.executeUpdate();
        }
    }

    public void deleteHistoricalRecord(Connection connection) throws SQLException {
        String sql = "DELETE FROM city_history WHERE historical_data_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, historicalDataId);
            statement.executeUpdate();
        }
    }
}
