package com.example.demo.controller;

import com.example.demo.pojo.Student;
import com.example.demo.pojo.StudentGradeResponse;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getStudent")
    public Student getStudent(@RequestParam String studentId) {
        return studentService.getStudent(studentId);
    }

    @GetMapping("/getStudentGrade")
    public StudentGradeResponse getStudentGrade(@RequestParam String studentId) {
        return studentService.getStudentGrade(studentId);
    }

    @GetMapping("/getStudentSchool")
    public String getStudentSchool(@RequestBody Student student) {
        return studentService.getStudentSchool(student);
    }
}
