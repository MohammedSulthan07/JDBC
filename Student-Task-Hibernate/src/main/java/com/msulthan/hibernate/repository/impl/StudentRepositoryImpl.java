package com.msulthan.hibernate.repository.impl;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.msulthan.hibernate.entity.Student;
import com.msulthan.hibernate.repository.StudentRepository;
import com.msulthan.hibernate.util.HibernateUtil;

public class StudentRepositoryImpl implements StudentRepository {

    @Override
    public void save(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public Student findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Student.class, id);
        }
    }

    @Override
    public void update(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }

    }

    @Override
    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.remove(student);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }

    }

    @Override
    public List<Student> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Student", Student.class).getResultList();

        }

    }

    @Override
    public Student getStudentByEmailAndDate(String email, LocalDate date) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = """
                    FROM Student
                    WHERE emailId = :email
                    AND enrollmentDate = :date
                    """;
            return session.createQuery(hql, Student.class)
                    .setParameter("email", email)
                    .setParameter("date", date)
                    .uniqueResult();

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