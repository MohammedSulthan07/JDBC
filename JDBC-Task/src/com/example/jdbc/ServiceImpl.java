package com.example.jdbc;

import java.sql.*;

public class ServiceImpl implements Service {

    @Override
    public void createDB(String dbname) {
        String sql = "create database if not exists " + dbname;
        try (Connection con = DBUtil.getConnection();
             Statement st = con.createStatement()) {
            st.executeUpdate(sql);
            DBUtil.setDbName(dbname);
            System.out.println("Database Created Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createTable() {
        String sql = "create table if not exists student(id int auto_increment primary key,regno varchar(20),name varchar(30),dept varchar(20),email varchar(50))";
        try (Connection con = DBUtil.getDBConnection();
             Statement st = con.createStatement()) {
            st.executeUpdate(sql);
            System.out.println("Table Created Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertData(Student student) {
        String sql =
                "insert into student(regno,name,dept,email) values(?,?,?,?)";
        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, student.getRegno());
            ps.setString(2, student.getName());
            ps.setString(3, student.getDept());
            ps.setString(4, student.getEmail());
            ps.executeUpdate();
            System.out.println("Data Inserted Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String regno, String name) {
        String sql = "update student set name=? where regno=?";
        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, regno);
            ps.executeUpdate();
            System.out.println("Updated Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String regno) {
        String sql = "delete from student where regno=?";
        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, regno);
            ps.executeUpdate();
            System.out.println("Deleted Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void findAll() {
        String sql = "select * from student";
        try (Connection con = DBUtil.getDBConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("regno") + " " +
                                rs.getString("name") + " " +
                                rs.getString("dept") + " " +
                                rs.getString("email")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}