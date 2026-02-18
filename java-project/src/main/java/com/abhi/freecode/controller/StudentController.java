package com.abhi.freecode.controller;
import com.abhi.freecode.dto.StudentRequest;
import com.abhi.freecode.dto.StudentResponse;
import com.abhi.freecode.entity.Student;
import com.abhi.freecode.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public StudentResponse getStudent(@PathVariable("id") Integer id) {
        return studentService.getStudent(id);
    }

    @PostMapping("/students")
    public Student post(@RequestBody Student studentRequest){
        return studentService.saveStudent(studentRequest);
    }
}
