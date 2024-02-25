package WeatherAppPack;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Weather_DB", "root", "1234")) {
            while (true) {
                System.out.println("Menu:");
                System.out.println("1. Afficher les prévisions météorologiques actuelles pour une ville");
                System.out.println("2. Afficher l'historique météorologique pour une ville");
                System.out.println("3. Quitter");
                System.out.print("Choisissez une option : ");
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        displayCurrentWeather(connection);
                        break;
                    case 2:
                        displayWeatherHistory(connection);
                        break;
                    case 3:
                        System.out.println("Au revoir !");
                        return;
                    default:
                        System.out.println("Option invalide. Veuillez choisir une option valide.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayCurrentWeather(Connection connection) throws SQLException {
        System.out.print("Entrez le nom de la ville : ");
        String cityName = scanner.nextLine();
        City city = City.readCity(connection, cityName);
        if (city != null) {
            System.out.println("Prévisions météorologiques actuelles pour " + cityName + ":");
            System.out.println("Température : " + city.getCurrentTemperature());
            System.out.println("Humidité : " + city.getCurrentHumidity());
            System.out.println("Vitesse du vent : " + city.getCurrentWindSpeed());
        } else {
            System.out.println("Ville non trouvée.");
        }
    }

    private static void displayWeatherHistory(Connection connection) throws SQLException {
        System.out.print("Entrez le nom de la ville : ");
        String cityName = scanner.nextLine();
        List<CityHistory> history = CityHistory.readCityHistory(connection, cityName);
        if (!history.isEmpty()) {
            System.out.println("Historique météorologique pour " + cityName + ":");
            for (CityHistory event : history) {
                System.out.println("Date : " + event.getEventDate() +
                        ", Température : " + event.getTemperature());
            }
        } else {
            System.out.println("Aucun historique trouvé pour cette ville.");
        }
    }
} 
