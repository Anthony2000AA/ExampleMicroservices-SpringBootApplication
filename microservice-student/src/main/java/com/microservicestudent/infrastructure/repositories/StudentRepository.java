package com.microservicestudent.infrastructure.repositories;

import com.microservicestudent.domain.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long>{



    List<Student> findByCourseId(Long courseId);
}
