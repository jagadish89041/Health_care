package EHMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionTest {

    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/HealthcareMangaementSystem"; // Change 'your_database_name' to your actual database name
    private static final String USER = "root"; // Change 'your_username' to your actual MySQL username
    private static final String PASSWORD = "Jaga"; // Change 'your_password' to your actual MySQL password



    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");


            // Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection to MySQL database established successfully!");

        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found. Include it in your library path.");
        } finally {
            // Close the connection if it was established
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException e) {
                System.err.println("SQL Exception on connection close: " + e.getMessage());
            }
        }
    }
}

