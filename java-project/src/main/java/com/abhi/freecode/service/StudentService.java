package com.abhi.freecode.service;

import com.abhi.freecode.dto.StudentRequest;
import com.abhi.freecode.dto.StudentResponse;
import com.abhi.freecode.entity.Student;
import com.abhi.freecode.mapper.StudentMapper;
import com.abhi.freecode.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentResponse> getStudents() {
        var students = this.studentRepository.findAll();
        return students.stream().map(
                StudentMapper::toStudentResponse
        ).toList();
    }

    public StudentResponse getStudent(Integer id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        return StudentMapper.toStudentResponse(student);
    }

    public StudentResponse saveStudent(StudentRequest studentRequest) {
        var studentEntity = StudentMapper.toStudentEntity(studentRequest);
        return StudentMapper.toStudentResponse(this.studentRepository.save(studentEntity));
    }

    public StudentResponse updateStudent(Integer id, StudentRequest studentRequest) {
        var student = this.getStudent(id);
        var updateStudent = Student.builder()
                .id(student.id())
                .firstName(!studentRequest.firstName().isEmpty() ? studentRequest.firstName() : student.name().split(" ")[0])
                .lastName(!studentRequest.lastName().isEmpty() ? studentRequest.lastName() : student.name().split(" ")[1])
                .email(!student.email().isEmpty() ? studentRequest.email() : student.email())
                .age(!String.valueOf(studentRequest.age()).isEmpty() ? studentRequest.age() : student.age())
                .build();
        var updatedStudent = this.studentRepository.save(updateStudent);
        return StudentMapper.toStudentResponse(updatedStudent);
    }

    public void deleteStudent(Integer id) {
//        var student = StudentMapper.toStudentEntity(this.getStudent(id));
        this.studentRepository.deleteById(id);
    }

}
