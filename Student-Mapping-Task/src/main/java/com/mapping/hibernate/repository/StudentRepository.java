package com.mapping.hibernate.repository;

import com.mapping.hibernate.entity.Student;

public interface StudentRepository {
    void saveStudent(Student student);

    Student findStudent(int studentId);

    void updateCourseDetails(int studentId, String courseName);

    void deleteStudent(int studentId);
}
