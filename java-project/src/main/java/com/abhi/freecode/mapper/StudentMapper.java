package com.abhi.freecode.mapper;

import com.abhi.freecode.dto.StudentRequest;
import com.abhi.freecode.dto.StudentResponse;
import com.abhi.freecode.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class StudentMapper {

    public static StudentResponse toStudentResponse(Student student) {
        return new StudentResponse(student.getId(), student.getFirstName() + " " + student.getLastName(), student.getEmail(), student.getAge());
    }

    public static Student toStudentEntity(StudentResponse studentResponse){
        return Student.builder()
                .firstName(studentResponse.name().split(" ")[0])
                .lastName(studentResponse.name().split(" ")[1])
                .email(studentResponse.email())
                .age(studentResponse.age())
                .build();
    }

    public static Student toStudentEntity(StudentRequest studentRequest){
        return Student.builder()
                .firstName(studentRequest.firstName())
                .lastName(studentRequest.lastName())
                .email(studentRequest.email())
                .age(studentRequest.age())
                .build();
    }


}
