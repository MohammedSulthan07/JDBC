package com.msulthan.hibernate.entity;

import java.time.LocalDate;

import com.msulthan.hibernate.enums.CourseType;
import com.msulthan.hibernate.enums.Gender;
import com.msulthan.hibernate.enums.Grade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "student_table")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;
    @Column(name = "mobile_number", nullable = false, unique = true)
    private String mobileNumber;
    @Column(name = "email_id", nullable = false, unique = true)
    private String emailId;
    @Column(name = "course_id")
    private int courseId;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "enrollment_date")
    private LocalDate enrollmentDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "course_type")
    private CourseType courseType;
    @Enumerated(EnumType.STRING)
    private Grade grade;
    public Student() {
    }

    public Student(int id, String firstName, String lastName, Gender gender,
                   String city, String state, String mobileNumber,
                   String emailId, int courseId, String courseName,
                   LocalDate enrollmentDate, CourseType courseType,
                   Grade grade) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.city = city;
        this.state = state;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
        this.courseId = courseId;
        this.courseName = courseName;
        this.enrollmentDate = enrollmentDate;
        this.courseType = courseType;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "\nStudent ID = " + id +
                "\nFirst Name = " + firstName +
                "\nLast Name = " + lastName +
                "\nGender = " + gender +
                "\nCity = " + city +
                "\nState = " + state +
                "\nMobile Number = " + mobileNumber +
                "\nEmail ID = " + emailId +
                "\nCourse ID = " + courseId +
                "\nCourse Name = " + courseName +
                "\nEnrollment Date = " + enrollmentDate +
                "\nCourse Type = " + courseType +
                "\nGrade = " + grade;
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