package com.example.demo.repository;

import com.example.demo.pojo.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    public Student findById(String studentId) {
        // Make a call to the "database"
        return new Student(studentId);
    }
}
