package com.example.jdbc;

import java.sql.*;

public class Demo {
    public static void main(String[] args) {
        /*
        1. Download the driver(mysql driver)

         */
        String jdbcUrl="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="45510ai";

        try(Connection con = DriverManager.getConnection(jdbcUrl,username,password);
            Statement statement=con.createStatement()){
            String sql="select * from customers";
            ResultSet rs=statement.executeQuery(sql);
            while (rs.next()){
                System.out.print(rs.getInt("id")+" ");
                System.out.print(rs.getString("first_name")+" ");
                System.out.print(rs.getString("country")+" ");
                System.out.print(rs.getInt("score")+" ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
