package com.msulthan.hibernate.service;

import java.time.LocalDate;

import com.msulthan.hibernate.entity.Student;

public interface StudentService {
    void addStudent(Student student) throws Exception;
    Student getStudentById(int id) throws Exception;
    void updateStudentCourse(int id, String courseName, String grade) throws Exception;
    void deleteStudent(int id) throws Exception;
    void getAllStudents() throws Exception;
    Student getStudentByEmailAndDate(String email, LocalDate date) throws Exception;

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