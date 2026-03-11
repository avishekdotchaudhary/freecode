package com.abhi.freecode.mapper;

import com.abhi.freecode.dto.StudentResponse;
import com.abhi.freecode.entity.School;
import com.abhi.freecode.entity.Student;
import com.abhi.freecode.entity.StudentProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

//    @BeforeAll
//    static void beforeAll() {
//        System.out.println("Inside before all method");
//    }
//
//    @AfterAll
//    static void afterAll() {
//        System.out.println("Inside after all method");
//    }
//
//    //This will run Before each test method
//    @BeforeEach
//    void setUp() {
//        System.out.println("Inside before each method");
//    }
//
//    @AfterEach
//    void tearDown() {
//        System.out.println("Inside after each method");
//    }
//
//    //This will run after before each method
//    @Test
//    public void testMethod1() {
//    System.out.println("My First Test");
//    }
//
//    @Test
//    public void testMethod2() {
//        System.out.println("My Second Test");
//    }

    private StudentMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentResponseToStudentEntity() {
        StudentResponse studentResponse = new StudentResponse(1, "John Doe", "johndoe@gmail.com", 20, 1);
        Student student = StudentMapper.respToStudentEntity(studentResponse);

        assertEquals(studentResponse.name().split(" ")[0], student.getFirstName());
        assertEquals(studentResponse.name().split(" ")[1], student.getLastName());
        assertEquals(studentResponse.email(), student.getEmail());
        assertEquals(studentResponse.age(), student.getAge());
        assertNotNull(student.getSchool());
        assertEquals(studentResponse.schoolId(), student.getSchool().getId());
    }

    @Test
    public void should_throw_null_pointer_exception_when_student_response_is_null(){
        var message = assertThrows(NullPointerException.class, () -> StudentMapper.respToStudentEntity(null));
        assertEquals("The Student Response is null", message.getMessage());
    }

    @Test
    public void shouldMapStudentEntityToStudentResponse() {
        School school = new School();
        school.setId(1);
        school.setName("Bal Vidya Mandir");
        Student student = new Student(1, "John", "Doe", "johndoe@gmail.com", 20, new StudentProfile(1, "Bio"), school);
        StudentResponse studentResponse = StudentMapper.toStudentResponse(student);

        assertEquals(student.getFirstName(), studentResponse.name().split(" ")[0]);
        assertEquals(student.getLastName(), studentResponse.name().split(" ")[1]);
        assertEquals(student.getEmail(), studentResponse.email());
        assertEquals(student.getAge(), studentResponse.age());
        assertEquals(student.getSchool().getId(), studentResponse.schoolId());
    }

}