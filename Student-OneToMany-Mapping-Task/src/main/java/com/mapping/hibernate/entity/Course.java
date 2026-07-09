package com.mapping.hibernate.entity;


import com.mapping.hibernate.enums.CourseType;
import com.mapping.hibernate.enums.Grade;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "course_name",nullable = false)
    private String courseName;
    @Column(name = "enrollment_date",nullable = false)
    private LocalDate enrollmentDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "course_type")
    private CourseType courseType;
    @Enumerated(EnumType.STRING)
    private Grade grade;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="course_id",referencedColumnName = "id",nullable = false)
    private Student student;

}
