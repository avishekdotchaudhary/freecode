package com.abhi.freecode.controller;
import com.abhi.freecode.dto.StudentRequest;
import com.abhi.freecode.dto.StudentResponse;
import com.abhi.freecode.entity.Student;
import com.abhi.freecode.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students/")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<StudentResponse> getAll() {
        return studentService.getStudents();
    }

    @GetMapping("{id}")
    public StudentResponse get(@PathVariable("id") Integer id) {
        return studentService.getStudent(id);
    }

    @PostMapping()
    public StudentResponse post(@RequestBody StudentRequest studentRequest){
        return studentService.saveStudent(studentRequest);
    }

    @PutMapping("{id}")
    public StudentResponse update(@PathVariable("id") Integer id, @RequestBody StudentRequest studentRequest){
        return studentService.updateStudent(id, studentRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id){
        this.studentService.deleteStudent(id);
    }
}
