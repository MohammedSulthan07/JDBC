package com.mapping.hibernate.entity;


import com.mapping.hibernate.dto.CourseDTO;
import com.mapping.hibernate.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name",nullable = false)
    private String firstname;
    @Column(name = "last_name",nullable = false)
    private String lastname;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender Gender;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;
    @Column(name = "mobile_number",nullable = false)
    private String mobileNumber;
    @Column(name = "email_id",unique = true,nullable = false)
    private String emailId;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true,mappedBy = "student")
    private List<Course> courseList= new ArrayList<>();

}
