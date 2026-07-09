package com.mapping.hibernate.service;

import com.mapping.hibernate.dto.StudentDTO;
import com.mapping.hibernate.exception.StudentNotFoundException;

public interface StudentService {
    void saveStudent(StudentDTO studentDTO);

    StudentDTO findStudent(int studentId) throws StudentNotFoundException;

    void updateCourserDetails(int studentId, String courseName) throws StudentNotFoundException;

    void deleteStudent(int studentId) throws StudentNotFoundException;
}
