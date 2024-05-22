package com.microservicecourse.application.controllers;

import com.microservicecourse.application.services.CourseService;
import com.microservicecourse.domain.entities.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping("/find-all")
    public ResponseEntity<List<Course>> findAll() {

        var courses = courseService.findAll();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Course> findById(@PathVariable Long id) {

        var course = courseService.findById(id);
        return ResponseEntity.ok(course);
    }

    @GetMapping("/save")
    public ResponseEntity<Course> save(@RequestBody Course course) {

        var savedCourse = courseService.save(course);

        return ResponseEntity.ok(savedCourse);
    }


    @GetMapping("/search-my-students-by-course/{courseId}")
    public ResponseEntity<?> searchMyStudentsByCourse(@PathVariable Long courseId) {

        var course = courseService.searchMyStudentsByCourse(courseId);
        return ResponseEntity.ok(course);
    }



}
