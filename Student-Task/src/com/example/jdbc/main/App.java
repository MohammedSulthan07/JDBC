package com.example.jdbc.main;

import com.example.jdbc.dto.StudentDTO;
import com.example.jdbc.service.StudentService;
import com.example.jdbc.service.impl.StudentServiceImpl;
import com.example.jdbc.util.InputUtil;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        StudentService service = new StudentServiceImpl();
        while (true) {
            System.out.println("\n===== STUDENT ENROLLMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Fetch Student By ID");
            System.out.println("3. Update Course Details");
            System.out.println("4. Delete Student");
            System.out.println("5. Fetch All Students");
            System.out.println("6. Fetch Student By Email + Enrollment Date");
            System.out.println("7. Exit");

            int choice = InputUtil.getInt("Enter choice: ");

            try {
                switch (choice) {
                    case 1:
                        StudentDTO student = new StudentDTO();
                        student.setId(InputUtil.getInt("Enter ID: "));
                        student.setFirstName(InputUtil.getString("Enter First Name: "));
                        student.setLastName(InputUtil.getString("Enter Last Name: "));
                        student.setGender(InputUtil.getString("Enter Gender (MALE/FEMALE): "));
                        student.setCity(InputUtil.getString("Enter City: "));
                        student.setState(InputUtil.getString("Enter State: "));
                        student.setMobileNumber(InputUtil.getString("Enter Mobile Number: "));
                        student.setEmailId(InputUtil.getString("Enter Email ID: "));
                        student.setCourseId(InputUtil.getInt("Enter Course ID: "));
                        student.setCourseName(InputUtil.getString("Enter Course Name: "));
                        student.setEnrollmentDate(InputUtil.getDate("Enter Enrollment Date (dd-MM-yyyy): "));
                        student.setCourseType(InputUtil.getString("Enter Course Type (ONLINE/OFFLINE): "));
                        student.setGrade(InputUtil.getString("Enter Grade (A/B/C/D/F): "));
                        service.addStudent(student);
                        break;
                    case 2:
                        int id = InputUtil.getInt("Enter Student ID: ");
                        StudentDTO result = service.getStudentById(id);
                        System.out.println(result);
                        break;
                    case 3:
                        int updateId = InputUtil.getInt("Enter Student ID: ");
                        String course = InputUtil.getString("Enter New Course Name: ");
                        String grade = InputUtil.getString("Enter New Grade: ");
                        service.updateStudentCourse(updateId, course, grade);
                        break;
                    case 4:
                        int deleteId = InputUtil.getInt("Enter Student ID: ");
                        service.deleteStudent(deleteId);
                        break;
                    case 5:
                        service.getAllStudents();
                        break;
                    case 6:
                        String email = InputUtil.getString("Enter Email ID: ");
                        LocalDate date = InputUtil.getDate("Enter Enrollment Date (dd-MM-yyyy): ");
                        StudentDTO studentResult = service.getStudentByEmailAndDate(email,date);
                        System.out.println(studentResult);
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}