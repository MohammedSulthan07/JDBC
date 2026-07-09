package com.mapping.hibernate.service;


import com.mapping.hibernate.dto.CourseDTO;
import com.mapping.hibernate.exception.CourseNotFoundException;

public interface CourseService {
    CourseDTO findCourse(int courseId) throws CourseNotFoundException;
}
