package com.example.jdbc.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputUtil {
    private static final Scanner sc = new Scanner(System.in);
    public static int getInt(String message) {
        System.out.print(message);
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

    public static String getString(String message) {
        System.out.print(message);
        return sc.nextLine();
    }

    public static LocalDate getDate(String message) {
        System.out.print(message);
        String date = sc.nextLine();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return LocalDate.parse(date, formatter);
    }

    public static void closeScanner() {
        sc.close();
    }
}