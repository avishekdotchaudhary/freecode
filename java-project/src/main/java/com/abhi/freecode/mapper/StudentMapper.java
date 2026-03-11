package com.abhi.freecode.mapper;

import com.abhi.freecode.dto.StudentRequest;
import com.abhi.freecode.dto.StudentResponse;
import com.abhi.freecode.entity.School;
import com.abhi.freecode.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class StudentMapper {

    public static StudentResponse toStudentResponse(Student student) {
        return new StudentResponse(student.getId(), student.getFirstName() + " " + student.getLastName(), student.getEmail(), student.getAge(), student.getSchool().getId());
    }

    public static Student respToStudentEntity(StudentResponse studentResponse){
        if(studentResponse == null) {
            throw new NullPointerException("The Student Response is null");
        }
        return Student.builder()
                .firstName(studentResponse.name().split(" ")[0])
                .lastName(studentResponse.name().split(" ")[1])
                .email(studentResponse.email())
                .age(studentResponse.age())
                .school(School.builder().id(studentResponse.schoolId()).build())
                .build();
    }

    public static Student reqToStudentEntity(StudentRequest studentRequest){
        if(studentRequest == null) {
            throw new NullPointerException("The Student Request is null");
        }
        return Student.builder()
                .firstName(studentRequest.firstName())
                .lastName(studentRequest.lastName())
                .email(studentRequest.email())
                .age(studentRequest.age())
                .build();
    }


}
