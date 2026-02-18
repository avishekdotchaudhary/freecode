package com.abhi.freecode.service;

import com.abhi.freecode.dto.StudentRequest;
import com.abhi.freecode.dto.StudentResponse;
import com.abhi.freecode.entity.Student;
import com.abhi.freecode.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponse getStudent(Integer id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        return new StudentResponse(
                student.getId(),
            student.getFirstName() + " " + student.getLastName(),
                student.getEmail(),
                student.getAge()
        );
    }

    public List<StudentResponse> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        return students.stream().map(student -> new StudentResponse(
                student.getId(),
                student.getFirstName() + " " + student.getLastName(),
                student.getEmail(),
                student.getAge()
        )).toList();
    }

    public Student saveStudent(Student studentRequest) {
//        com.abhi.freecode.entity.Student student = studentRepository.save(Student.builder()
//                .firstName(studentRequest.firstName())
//                .lastName(studentRequest.lastName())
//                .email(studentRequest.email())
//                .age(studentRequest.age())
//                .build());
//        return new StudentResponse(
//                student.getId(),
//            student.getFirstName() + " " + student.getLastName(),
//                student.getEmail(),
//                student.getAge()
//        );
        return studentRepository.save(studentRequest);
    }

}
