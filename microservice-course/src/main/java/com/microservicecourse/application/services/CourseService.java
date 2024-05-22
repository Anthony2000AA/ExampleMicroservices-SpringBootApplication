package com.microservicecourse.application.services;

import com.microservicecourse.application.dto.CourseDto;
import com.microservicecourse.domain.entities.Course;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CourseService {

    List<Course> findAll();

    Course findById(Long id);

    Course save(Course course);


    CourseDto searchMyStudentsByCourse(Long courseId);
}
