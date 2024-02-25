package WeatherAppPack;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class City {
    private int cityId;
    private String cityName;
    private double currentTemperature;
    private double currentHumidity;
    private double currentWindSpeed;

    public City() {
    }

    public City(int cityId, String cityName, double currentTemperature, double currentHumidity, double currentWindSpeed) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.currentTemperature = currentTemperature;
        this.currentHumidity = currentHumidity;
        this.currentWindSpeed = currentWindSpeed;
    }

    

    public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public double getCurrentTemperature() {
		return currentTemperature;
	}

	public void setCurrentTemperature(double currentTemperature) {
		this.currentTemperature = currentTemperature;
	}

	public double getCurrentHumidity() {
		return currentHumidity;
	}

	public void setCurrentHumidity(double currentHumidity) {
		this.currentHumidity = currentHumidity;
	}

	public double getCurrentWindSpeed() {
		return currentWindSpeed;
	}

	public void setCurrentWindSpeed(double currentWindSpeed) {
		this.currentWindSpeed = currentWindSpeed;
	}

	public static City readCity(Connection connection, String cityName) throws SQLException {
        String sql = "SELECT * FROM cities WHERE city_name = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cityName);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new City(resultSet.getInt("city_id"), resultSet.getString("city_name"),
                            resultSet.getDouble("current_temperature"), resultSet.getDouble("current_humidity"),
                            resultSet.getDouble("current_wind_speed"));
                }
            }
        }
        return null;
    }

    public void updateCityRecord(Connection connection) throws SQLException {
        String sql = "UPDATE cities SET current_temperature = ?, current_humidity = ?, current_wind_speed = ? WHERE city_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, currentTemperature);
            statement.setDouble(2, currentHumidity);
            statement.setDouble(3, currentWindSpeed);
            statement.setInt(4, cityId);
            statement.executeUpdate();
        }
    }

    public void deleteCityRecord(Connection connection) throws SQLException {
        String sql = "DELETE FROM cities WHERE city_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, cityId);
            statement.executeUpdate();
        }
    }
}
