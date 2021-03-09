package com.example.demo;

import com.example.demo.pojo.Student;
import com.example.demo.pojo.StudentGradeResponse;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class StudentTest {

    @Mock
    StudentRepository studentRepository;

    private StudentService studentService;

    @BeforeEach
    public void setUp() {
        this.studentService = new StudentService(studentRepository);
    }

    @Test
    public void testGetStudentGradeSuccess() {
        when(studentRepository.findById(any())).thenReturn(new Student("1"));

        StudentGradeResponse response = studentService.getStudentGrade("1");
        assertThat(response.getMessage()).isEqualTo("Success");
    }

    @Test
    public void testGetStudentGradeError() {
        when(studentRepository.findById(any())).thenReturn(new Student());

        StudentGradeResponse response = studentService.getStudentGrade("1");
        assertThat(response.getMessage()).isEqualTo("Error - Student does not exist");
    }

    static Stream<Arguments> studentSchoolDataProvider() {
        return Stream.of(
                arguments(new Student("1", "John Smith", 3), "Elementary School"),
                arguments(new Student("1", "John Smith", 7), "Middle School"),
                arguments(new Student("1", "John Smith", 10), "High School"),
//                arguments(new Student("1", "John Smith", -1), "Elementary School"),
                arguments(new Student("1", "John Smith", -1), "Please enter a valid grade"),
                arguments(new Student("1", "John Smith", 0), "Please enter a valid grade"),
                arguments(new Student("1", "John Smith", 13), "Please enter a valid grade")
        );
    }

    @ParameterizedTest
    @MethodSource("studentSchoolDataProvider")
    public void testGetStudentSchool(Student student, String expectedSchool) {
        String school = studentService.getStudentSchool(student);
        assertThat(school).isEqualTo(expectedSchool);
    }
}
