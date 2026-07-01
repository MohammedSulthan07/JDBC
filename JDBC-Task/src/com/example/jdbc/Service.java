package com.example.jdbc;

public interface Service {
    void createDB(String dbname);
    void createTable();
    void insertData(Student student);
    void update(String regno,String name);
    void delete(String regno);
    void findAll();
}