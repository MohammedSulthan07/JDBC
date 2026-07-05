package com.example.jdbc.service.impl;

import com.example.jdbc.dto.StudentDTO;
import com.example.jdbc.repository.StudentRepository;
import com.example.jdbc.repository.impl.StudentRepositoryImpl;
import com.example.jdbc.service.StudentService;
import java.time.LocalDate;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentRepository repository = new StudentRepositoryImpl();

    @Override
    public void addStudent(StudentDTO student) throws Exception {
        repository.addStudent(student);
    }

    @Override
    public StudentDTO getStudentById(int id) throws Exception {
        return repository.getStudentById(id);
    }

    @Override
    public void updateStudentCourse(int id, String courseName, String grade) throws Exception {
        repository.updateStudentCourse(id, courseName, grade);
    }

    @Override
    public void deleteStudent(int id) throws Exception {
        repository.deleteStudent(id);
    }

    @Override
    public void getAllStudents() throws Exception {
        List<StudentDTO> students = repository.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (StudentDTO student : students) {
            System.out.println(student);
            System.out.println("---------------------------");
        }
    }

    @Override
    public StudentDTO getStudentByEmailAndDate(String email, LocalDate date) throws Exception {
        return repository.getStudentByEmailAndDate(email, date);
    }
}