package com.mapping.hibernate.repository.impl;

import com.mapping.hibernate.config.DatabaseConfig;
import com.mapping.hibernate.entity.Student;
import com.mapping.hibernate.repository.StudentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentRepositoryImpl implements StudentRepository {


    private static final SessionFactory SESSION_FACTORY =
            DatabaseConfig.getSessionFactory();


    @Override
    public void saveStudent(Student student) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(student);
            tx.commit();
        }
    }

    @Override
    public Student findStudent(int studentId) {
        try (Session session = SESSION_FACTORY.openSession()) {
            return session.find(Student.class, studentId);
        }
    }

    @Override
    public void updateCourseDetails(int studentId, String courseName) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx= session.beginTransaction();
            Student student=session.find(Student.class,studentId);
            student.getCourse().setCourseName(courseName);
            session.merge(student);
            tx.commit();
        }
    }

    @Override
    public void deleteStudent(int studentId) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx= session.beginTransaction();
            Student student=session.find(Student.class,studentId);
            session.remove(student);
            tx.commit();
        }
    }
}
