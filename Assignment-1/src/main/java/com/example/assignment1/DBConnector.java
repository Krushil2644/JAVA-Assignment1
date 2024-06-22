package com.example.assignment1;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

public class DBConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/deforestation_db";
    private static final String USER = "root";
    private static final String PASSWORD = "8780883589@Kdl";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
