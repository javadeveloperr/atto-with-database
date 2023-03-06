package org.example.db;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    public static java.sql.Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_lesson", "postgres", "root123");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
