package com.microservicestudent.application.controllers;


import com.microservicestudent.application.services.StudentService;
import com.microservicestudent.domain.entities.Student;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/find-all")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/find-by-course-id/{courseId}")
    public ResponseEntity<List<Student>> findByCourseId(@PathVariable Long courseId) {

        var students = studentService.findByCourseId(courseId);
        return ResponseEntity.ok(students);
    }

    @PostMapping("/save")
    public ResponseEntity<Student> save(@RequestBody  Student student) {

       var savedStudent = studentService.save(student);

       return  ResponseEntity.ok(savedStudent);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id) {

       var student = studentService.findById(id);

         return ResponseEntity.ok(student);
    }

    @GetMapping("/delete-by-id/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }
}
