package com.microservicecourse.client;


import com.microservicecourse.application.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-student", url = "http://localhost:8080/api/v1/students")
public interface StudentClient {

    @GetMapping("/find-by-course-id/{courseId}")
    List<StudentDto> searchMyStudentsByCourse(@PathVariable Long courseId);
}
