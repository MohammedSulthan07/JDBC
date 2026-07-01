package com.example.jdbc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Service service = new ServiceImpl();
        while (true) {
            System.out.println("\nWelcome to CRUD API");
            System.out.println("1.Create Database");
            System.out.println("2.Create table");
            System.out.println("3.Insert data");
            System.out.println("4.Update data");
            System.out.println("5.Delete data");
            System.out.println("6.Retrieve data");
            System.out.println("7.Exit");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    String dbname = InputUtil.getDBName();
                    service.createDB(dbname);
                    break;
                case 2:
                    service.createTable();
                    break;
                case 3:
                    Student student = InputUtil.getStudentInput();
                    service.insertData(student);
                    break;
                case 4:
                    String regno = InputUtil.getRegno();
                    String name = InputUtil.getName();
                    service.update(regno, name);
                    break;
                case 5:
                    String deleteRegno = InputUtil.getRegno();
                    service.delete(deleteRegno);
                    break;
                case 6:
                    service.findAll();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}