package sourse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private final static String URL = "jdbc:mysql://localhost:3306/Store";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "";
    private final Connection connection;

    public DBConnector() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Error while database connection: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
