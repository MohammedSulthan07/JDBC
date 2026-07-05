package com.example.jdbc.repository;

import com.example.jdbc.dto.StudentDTO;
import java.time.LocalDate;
import java.util.List;

public interface StudentRepository {
    void addStudent(StudentDTO student) throws Exception;
    StudentDTO getStudentById(int id) throws Exception;
    void updateStudentCourse(int id, String courseName, String grade) throws Exception;
    void deleteStudent(int id) throws Exception;
    List<StudentDTO> getAllStudents() throws Exception;
    StudentDTO getStudentByEmailAndDate(String email,LocalDate date) throws Exception;
}