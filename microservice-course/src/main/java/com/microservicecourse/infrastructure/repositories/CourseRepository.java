package com.microservicecourse.infrastructure.repositories;

import com.microservicecourse.domain.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
