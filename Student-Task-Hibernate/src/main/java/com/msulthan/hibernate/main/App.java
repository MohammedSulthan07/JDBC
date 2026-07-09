package com.msulthan.hibernate.main;

import java.time.LocalDate;

import com.msulthan.hibernate.entity.Student;
import com.msulthan.hibernate.enums.CourseType;
import com.msulthan.hibernate.enums.Gender;
import com.msulthan.hibernate.enums.Grade;
import com.msulthan.hibernate.service.StudentService;
import com.msulthan.hibernate.service.impl.StudentServiceImpl;
import com.msulthan.hibernate.util.InputUtil;

public class App {

    public static void main(String[] args) {

        StudentService service = new StudentServiceImpl();

        while (true) {
            System.out.println("\n========== STUDENT ENROLLMENT SYSTEM ==========");
            System.out.println("1. Add Student");
            System.out.println("2. Fetch Student By ID");
            System.out.println("3. Update Course Details");
            System.out.println("4. Delete Student");
            System.out.println("5. Fetch All Students");
            System.out.println("6. Fetch Student By Email + Enrollment Date");
            System.out.println("7. Exit");
            int choice = InputUtil.getInt("\nEnter Choice : ");

            try {
                switch (choice) {
                    case 1:
                        Student student = new Student();
                        student.setFirstName(InputUtil.getString("First Name : "));
                        student.setLastName(InputUtil.getString("Last Name : "));
                        student.setGender(Gender.valueOf(InputUtil.getString("Gender (MALE/FEMALE): ").toUpperCase()));
                        student.setCity(InputUtil.getString("City : "));
                        student.setState(InputUtil.getString("State : "));
                        student.setMobileNumber(InputUtil.getString("Mobile Number : "));
                        student.setEmailId(InputUtil.getString("Email ID : "));
                        student.setCourseId(InputUtil.getInt("Course ID : "));
                        student.setCourseName(InputUtil.getString("Course Name : "));
                        student.setEnrollmentDate(InputUtil.getDate("Enrollment Date (dd-MM-yyyy): "));
                        student.setCourseType(CourseType.valueOf(InputUtil.getString("Course Type (ONLINE/OFFLINE): ").toUpperCase()));
                        student.setGrade(Grade.valueOf(InputUtil.getString("Grade (A/B/C/D/F): ").toUpperCase()));
                        service.addStudent(student);
                        break;
                    case 2:
                        int id = InputUtil.getInt("Enter Student ID : ");
                        Student student1 = service.getStudentById(id);
                        System.out.println(student1);
                        break;
                    case 3:
                        int updateId = InputUtil.getInt("Student ID : ");
                        String courseName = InputUtil.getString("New Course Name : ");
                        String grade = InputUtil.getString("New Grade : ");
                        service.updateStudentCourse(updateId, courseName, grade);
                        break;
                    case 4:
                        int deleteId = InputUtil.getInt("Student ID : ");
                        service.deleteStudent(deleteId);
                        break;
                    case 5:
                        service.getAllStudents();
                        break;
                    case 6:
                        String email = InputUtil.getString("Email ID : ");
                        LocalDate date = InputUtil.getDate("Enrollment Date (dd-MM-yyyy): ");
                        Student student2 = service.getStudentByEmailAndDate(email, date);
                        System.out.println(student2);
                        break;
                    case 7:
                        System.out.println("Thank You.");
                        InputUtil.closeScanner();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Choice.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }







        }

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