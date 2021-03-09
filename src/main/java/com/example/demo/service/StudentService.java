package com.example.demo.service;

import com.example.demo.pojo.Student;
import com.example.demo.pojo.StudentGradeResponse;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudent(String studentId) {
        return studentRepository.findById(studentId);
    }

    public StudentGradeResponse getStudentGrade(String studentId) {
        StudentGradeResponse studentGradeResponse = new StudentGradeResponse();
        Student student;
        student = studentRepository.findById(studentId);
        studentGradeResponse.setGrade(student.getGrade());

        if (student.getName() != null && !student.getName().isEmpty()) {
//        if (student.getName() != null && student.getName().isEmpty()) {
            studentGradeResponse.setMessage("Success");
        } else {
            studentGradeResponse.setMessage("Error - Student does not exist");
        }

        return studentGradeResponse;
    }

    public String getStudentSchool(Student student) {
        String school = "";

        if (student.getGrade() > 0 && student.getGrade() <= 5) {
            school = "Elementary School";
        } else if (student.getGrade() > 5 && student.getGrade() <= 8) {
            school = "Middle School";
        } else if (student.getGrade() > 8 && student.getGrade() <= 12) {
            school = "High School";
        } else {
            school = "Please enter a valid grade";
        }

        return school;
    }
}
