package com.example.jdbc.dto;

import java.time.LocalDate;

public class StudentDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String city;
    private String state;
    private String mobileNumber;
    private String emailId;
    private int courseId;
    private String courseName;
    private LocalDate enrollmentDate;
    private String courseType;
    private String grade;

    public StudentDTO() {
    }

    public StudentDTO(int id, String firstName, String lastName, String gender, String city, String state, String mobileNumber, String emailId, int courseId, String courseName, LocalDate enrollmentDate, String courseType, String grade) {

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


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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


    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }


    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
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