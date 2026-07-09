package com.mapping.hibernate.dto;

import com.mapping.hibernate.enums.CourseType;
import com.mapping.hibernate.enums.Grade;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CourseDTO {
    private int id;
    private String courseName;
    private LocalDate enrollmentDate;
    private CourseType courseType;
    private Grade grade;
    private StudentDTO studentDTO;
}
