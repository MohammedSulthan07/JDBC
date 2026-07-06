package com.msulthan.hibernate.service.impl;

import java.time.LocalDate;
import java.util.List;

import com.msulthan.hibernate.entity.Student;
import com.msulthan.hibernate.enums.Grade;
import com.msulthan.hibernate.exception.DuplicateStudentException;
import com.msulthan.hibernate.exception.StudentNotFoundException;
import com.msulthan.hibernate.repository.StudentRepository;
import com.msulthan.hibernate.repository.impl.StudentRepositoryImpl;
import com.msulthan.hibernate.service.StudentService;

public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository = new StudentRepositoryImpl();

    @Override
    public void addStudent(Student student) throws Exception {
        Student existingStudent = repository.getStudentByEmailAndDate(student.getEmailId(), student.getEnrollmentDate());
        if (existingStudent != null) {
            throw new DuplicateStudentException("Student already exists with Email ID : " + student.getEmailId());
        }
        repository.save(student);
        System.out.println("Student Added Successfully.");
    }

    @Override
    public Student getStudentById(int id) throws Exception {
        Student student = repository.findById(id);
        if (student == null) {
            throw new StudentNotFoundException("Student Not Found with ID : " + id);
        }
        return student;

    }

    @Override
    public void updateStudentCourse(int id, String courseName, String grade) throws Exception {
        Student student = repository.findById(id);
        if (student == null) {
            throw new StudentNotFoundException(
                    "Student Not Found.");
        }
        student.setCourseName(courseName);
        student.setGrade(Grade.valueOf(grade.toUpperCase()));
        repository.update(student);
        System.out.println("Student Updated Successfully.");
    }

    @Override
    public void deleteStudent(int id) throws Exception {
        Student student = repository.findById(id);
        if (student == null) {
            throw new StudentNotFoundException("Student Not Found.");
        }
        repository.delete(id);
        System.out.println("Student Deleted Successfully.");

    }

    @Override
    public void getAllStudents() throws Exception {
        List<Student> students = repository.findAll();
        if (students.isEmpty()) {
            System.out.println("No Students Found.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
            System.out.println("---------------------------------------");

        }

    }

    @Override
    public Student getStudentByEmailAndDate(String email, LocalDate date)
            throws Exception {Student student = repository.getStudentByEmailAndDate(email, date);
        if (student == null) {
            throw new StudentNotFoundException(
                    "Student Not Found.");
        }

        return student;

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
//        ""Y8P"         `Y88P""Y8            88    88    `Y8a8P"Y88888P"
//
//        [By Mohammed Sulthan G]