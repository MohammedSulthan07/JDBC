package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/";
    private static final String username = "root";
    private static final String password = "45510ai";
    private static String dbName;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, username, password);
    }

    public static Connection getDBConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl + dbName, username, password);
    }

    public static void setDbName(String db) {
        dbName = db;
    }
}