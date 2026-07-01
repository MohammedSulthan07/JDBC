package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String jdbcUrl="jdbc:mysql://localhost:3306/mydatabase";
    private static final String username="root";
    private static final String password="45510ai";
    Connection con=null;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl,username,password);
    }

    public static void close(AutoCloseable resource){
        if (resource!=null){
            try{
                resource.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

