package com.microservicestudent.application.services.impl;

import com.microservicestudent.application.services.StudentService;
import com.microservicestudent.domain.entities.Student;
import com.microservicestudent.infrastructure.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IStudentService implements StudentService {

    private final StudentRepository studentRepository;

    public IStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findByCourseId(Long courseId) {
        return studentRepository.findByCourseId(courseId);
    }
}
