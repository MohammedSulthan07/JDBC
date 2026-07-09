package com.mapping.hibernate.dto;

import com.mapping.hibernate.enums.Gender;
import lombok.Data;

@Data
public class StudentDTO {
    private int id;
    private String firstname;
    private String lastname;
    private Gender Gender;
    private String city;
    private String state;
    private String mobileNumber;
    private String emailId;
    private CourseDTO courseDTO;

}
