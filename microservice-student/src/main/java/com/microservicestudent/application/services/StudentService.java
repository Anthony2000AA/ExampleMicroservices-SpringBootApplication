package com.microservicestudent.application.services;


import com.microservicestudent.domain.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

    public List<Student> findAll();
    public Student findById(Long id);
    public Student save(Student student);
    public void deleteById(Long id);
    public List<Student> findByCourseId(Long courseId);
}
