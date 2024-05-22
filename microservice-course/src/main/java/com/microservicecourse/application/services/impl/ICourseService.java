package com.microservicecourse.application.services.impl;


import com.microservicecourse.application.dto.CourseDto;
import com.microservicecourse.application.dto.StudentDto;
import com.microservicecourse.application.services.CourseService;
import com.microservicecourse.client.StudentClient;
import com.microservicecourse.domain.entities.Course;
import com.microservicecourse.infrastructure.repositories.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICourseService  implements CourseService {

    private final CourseRepository courseRepository;

    private final StudentClient studentClient;


    public ICourseService(CourseRepository courseRepository, StudentClient studentClient) {
        this.courseRepository = courseRepository;
        this.studentClient = studentClient;

    }
    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public CourseDto searchMyStudentsByCourse(Long courseId) {
        var course = courseRepository.findById(courseId).orElse(null);

        List<StudentDto> students = studentClient.searchMyStudentsByCourse(courseId);

        return CourseDto.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .students(students)
                .build();
    }
}
