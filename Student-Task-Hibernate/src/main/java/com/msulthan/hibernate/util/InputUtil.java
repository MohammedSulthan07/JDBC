package com.msulthan.hibernate.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputUtil {

    private static final Scanner sc = new Scanner(System.in);

    private InputUtil() {
    }

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
        String input = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(input, formatter);
    }

    public static void closeScanner() {
        sc.close();
    }

}

//                ,ggg,                ,ggg, ,ggg,_,ggg,        ,gg,
//               dP""8I               dP""Y8dP""Y88P""Y8b      i8""8i
//               dP   88               Yb, `88'  `88'  `88      `8,,8'
//              dP    88    gg          `"  88    88    88       `88'
//             ,8'    88    ""              88    88    88       dP"8,
//             d88888888    gg  aaaaaaaa    88    88    88      dP' `8a
// _      _   ,8"     88    88  """"""""    88    88    88     dP'   `Yb
//      dP"  ,8P      Y8    88              88    88    88 _ ,dP'     I8
//      Yb,_,dP       `8b,_,88,_            88    88    Y8,"888,,____,dP " +
//      ""Y8P"         `Y88P""Y8            88    88    `Y8a8P"Y88888P"
//
//        [By Mohammed Sulthan G]