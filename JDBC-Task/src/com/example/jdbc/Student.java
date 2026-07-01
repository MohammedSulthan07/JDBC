package com.example.jdbc;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Student {
    private int id;
    private String regno;
    private String name;
    private String dept;
    private String email;

    public int getId() {
        return id;
    }

    public String getRegno() {
        return regno;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}