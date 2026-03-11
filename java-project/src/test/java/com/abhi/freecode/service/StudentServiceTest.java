package com.abhi.freecode.service;

import com.abhi.freecode.dto.StudentRequest;
import com.abhi.freecode.dto.StudentResponse;
import com.abhi.freecode.entity.School;
import com.abhi.freecode.entity.Student;
import com.abhi.freecode.entity.StudentProfile;
import com.abhi.freecode.mapper.StudentMapper;
import com.abhi.freecode.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_successfully_save_students(){
        //Given
        StudentRequest studentRequest = new StudentRequest(
                "John",
                "Doe",
                "john@gmail.com",
                20
        );
        Student student = new Student(
                "John",
                "Doe",
                "john@gmail.com",
                20
        );

        Student saveStudent = new Student(
                "John",
                "Doe",
                "john@gmail.com",
                20
        );

        //Mock the calls
        when(StudentMapper.reqToStudentEntity(studentRequest)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(saveStudent);
        when(StudentMapper.toStudentResponse(saveStudent)).thenReturn(new StudentResponse(1, "John Doe", "john@gmail.com", 20, 1));

        //When
        StudentResponse studentResp = studentService.saveStudent(studentRequest);

        //Then
        assertEquals(studentRequest.firstName(), studentResp.name().split(" ")[0]);
        assertEquals(studentRequest.lastName(), studentResp.name().split(" ")[1]);
        assertEquals(studentRequest.email(), studentResp.email());
        assertEquals(studentRequest.age(), studentResp.age());
    }

}