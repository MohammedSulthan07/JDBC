package com.example.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        try(Connection con =DBUtil.getConnection();){
            Statement st = con.createStatement();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the username: ");
            String username=sc.nextLine();
            System.out.println("Enter the password: ");
            String password =sc.nextLine();
            String sql="select name,password from test where name='"+username+"' and password='"+password+"' ";


            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}