package com.example.jdbc;

import java.util.Scanner;

public class InputUtil {
    static Scanner sc = new Scanner(System.in);
    public static String getDBName() {
        System.out.println("Enter database name:");
        return sc.nextLine();
    }

    public static Student getStudentInput() {
        Student student = new Student();
        System.out.println("Enter Register Number:");
        student.setRegno(sc.nextLine());
        System.out.println("Enter Name:");
        student.setName(sc.nextLine());
        System.out.println("Enter Department:");
        student.setDept(sc.nextLine());
        System.out.println("Enter Email:");
        student.setEmail(sc.nextLine());
        return student;
    }

    public static String getRegno() {
        System.out.println("Enter Register Number:");
        return sc.nextLine();
    }

    public static String getName() {
        System.out.println("Enter New Name:");
        return sc.nextLine();
    }
}