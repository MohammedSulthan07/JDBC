package com.mapping.hibernate.main;


import java.util.Scanner;

import com.mapping.hibernate.dto.StudentDTO;
import com.mapping.hibernate.dto.CourseDTO;
import com.mapping.hibernate.service.StudentService;
import com.mapping.hibernate.service.impl.StudentServiceImpl;
import com.mapping.hibernate.service.CourseService;
import com.mapping.hibernate.service.impl.CourseServiceImpl;
import com.mapping.hibernate.util.InputUtil;
import com.mapping.hibernate.dto.CourseDTO;
import com.mapping.hibernate.dto.StudentDTO;
import com.mapping.hibernate.service.CourseService;
import com.mapping.hibernate.service.StudentService;
import com.mapping.hibernate.service.impl.CourseServiceImpl;
import com.mapping.hibernate.service.impl.StudentServiceImpl;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    public void run() {
        StudentService studentService = new StudentServiceImpl();
        CourseService courseService = new CourseServiceImpl();
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println("Welcome to Student Management");
                int menuOption = InputUtil.acceptMenuOption(scanner);
                switch (menuOption) {
                    case 1:
                        StudentDTO studentDTO = InputUtil.acceptStudentDetailsToSave(scanner);
                        CourseDTO courseDTO = InputUtil.acceptCourseDetailsToSave(scanner);
                        studentDTO.setCourseDTO(courseDTO);
                        studentService.saveStudent(studentDTO);
                        System.out.println("Student has been saved successfully.");
                        break;
                    case 2:
                        int studentId = InputUtil.acceptStudentIdToOperate(scanner);
                        studentDTO = studentService.findStudent(studentId);
                        System.out.println("Student has been fetched successfully.");
                        System.out.println(studentDTO);
                        break;
                    case 3:
                        studentId = InputUtil.acceptStudentIdToOperate(scanner);
                        String courseName = InputUtil.acceptCourseDetailsToUpdate(scanner);
                        studentService.updateCourserDetails(studentId, courseName);
                        System.out.println("Course details of Student have been updated successfully.");
                        break;
                    case 4:
                        studentId = InputUtil.acceptStudentIdToOperate(scanner);
                        studentService.deleteStudent(studentId);
                        System.out.println("Student has been deleted successfully.");
                        break;
                    case 5:
                        int courseId = InputUtil.acceptCourseIdToOperate(scanner);
                        courseDTO = courseService.findCourse(courseId);
                        System.out.println("Course has been fetched successfully.");
                        System.out.println(courseDTO);
                        break;
                    default:
                        System.out.println("Invalid option entered.");
                }
            } while (InputUtil.wantToContinue(scanner));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}