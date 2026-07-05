package com.example.jdbc.repository.impl;

import com.example.jdbc.util.DBUtil;
import com.example.jdbc.dto.StudentDTO;
import com.example.jdbc.exception.StudentNotFoundException;
import com.example.jdbc.repository.StudentRepository;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    @Override
    public void addStudent(StudentDTO student) throws Exception {
        String sql = "INSERT INTO student VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, student.getId());
            ps.setString(2, student.getFirstName());
            ps.setString(3, student.getLastName());
            ps.setString(4, student.getGender());
            ps.setString(5, student.getCity());
            ps.setString(6, student.getState());
            ps.setString(7, student.getMobileNumber());
            ps.setString(8, student.getEmailId());
            ps.setInt(9, student.getCourseId());
            ps.setString(10, student.getCourseName());
            ps.setDate(11, Date.valueOf(student.getEnrollmentDate()));
            ps.setString(12, student.getCourseType());
            ps.setString(13, student.getGrade());
            ps.executeUpdate();
            System.out.println("Student added successfully.");
        }
    }


    @Override
    public StudentDTO getStudentById(int id) throws Exception {
        String sql = "SELECT * FROM student WHERE id=?";
        try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return extractStudent(rs);
            }
            throw new StudentNotFoundException(
                    "Student not found with id " + id);
        }
    }

    @Override
    public void updateStudentCourse(int id, String courseName, String grade) throws Exception {

        String sql = "UPDATE student SET course_name=?, grade=? WHERE id=?";

        try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, courseName);
            ps.setString(2, grade);
            ps.setInt(3, id);
            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new StudentNotFoundException(
                        "Student not found.");
            }
            System.out.println("Course updated successfully.");
        }
    }

    @Override
    public void deleteStudent(int id) throws Exception {
        String sql = "DELETE FROM student WHERE id=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new StudentNotFoundException(
                        "Student not found.");
            }
            System.out.println("Student deleted successfully.");
        }
    }

    @Override
    public List<StudentDTO> getAllStudents() throws Exception {
        String sql = "SELECT * FROM student";
        List<StudentDTO> list = new ArrayList<>();
        try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(extractStudent(rs));
            }
        }
        return list;
    }


    @Override
    public StudentDTO getStudentByEmailAndDate(String email, LocalDate date)
            throws Exception {
        String sql =
                "SELECT * FROM student WHERE email_id=? AND enrollment_date=?";
        try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setDate(2, Date.valueOf(date));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return extractStudent(rs);
            }
            throw new StudentNotFoundException(
                    "Student not found.");
        }
    }

    private StudentDTO extractStudent(ResultSet rs)
            throws SQLException {
        StudentDTO student = new StudentDTO();
        student.setId(rs.getInt("id"));
        student.setFirstName(rs.getString("first_name"));
        student.setLastName(rs.getString("last_name"));
        student.setGender(rs.getString("gender"));
        student.setCity(rs.getString("city"));
        student.setState(rs.getString("state"));
        student.setMobileNumber(rs.getString("mobile_number"));
        student.setEmailId(rs.getString("email_id"));
        student.setCourseId(rs.getInt("course_id"));
        student.setCourseName(rs.getString("course_name"));
        student.setEnrollmentDate(rs.getDate("enrollment_date").toLocalDate());
        student.setCourseType(rs.getString("course_type"));
        student.setGrade(rs.getString("grade"));
        return student;
    }
}