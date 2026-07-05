package com.example.jdbc.service;

import com.example.jdbc.dto.StudentDTO;
import java.time.LocalDate;

public interface StudentService {
    void addStudent(StudentDTO student) throws Exception;
    StudentDTO getStudentById(int id) throws Exception;
    void updateStudentCourse(int id, String courseName, String grade) throws Exception;
    void deleteStudent(int id) throws Exception;
    void getAllStudents() throws Exception;
    StudentDTO getStudentByEmailAndDate(String email, LocalDate date) throws Exception;
}