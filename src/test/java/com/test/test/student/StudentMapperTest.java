package com.test.test.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class StudentMapperTest {

   // private StudentMapper studentMapper = new StudentMapper();

    //or

    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        studentMapper = new StudentMapper();
    }

    @Test
    public void shouldMapSTudentDtoToStudentModel(){

        //Create a new StudentDto object with the given parameters
        StudentDto dto = new StudentDto("TEST",
                "Setup",
                2L);

        //Map the StudentDto object to a StudentModel object
        StudentModel studentModel = studentMapper.toResponse(dto);

        //Assert that the name and email of the StudentDto object are equal to the name and email of the StudentModel object
        assertEquals(dto.name(), studentModel.getName());
        assertEquals(dto.email(), studentModel.getEmail());

        //Assert that the schoolEntity of the StudentModel object is not null and that the id of the schoolEntity is equal to the id of the StudentDto object
        assertNotNull(studentModel.getSchoolEntity());
        assertEquals(dto.scId(), studentModel.getSchoolEntity().getId());

    }

    @Test
    public void should_throw_null_pointer_exception_when_studentDto_is_null(){
        //Assert that a NullPointerException is thrown when the StudentDto object is null
        var exp = assertThrows(NullPointerException.class,()->studentMapper.toResponse(null));
        //Assert that the message of the NullPointerException is equal to the given message
        assertEquals("The student dto should not be null",exp.getMessage());

    }

    @Test
    public void shouldMapModelToResponse(){
        //Create a new StudentModel object
        StudentModel model = new StudentModel();
        //Set the name and email of the StudentModel object
        model.setName("ssss");
        model.setEmail("Setup");

        //Map the StudentModel object to a StudentResponse object
        StudentResponse studentResponse = studentMapper.toEntity(model);

        //Assert that the name and email of the StudentModel object are equal to the name and email of the StudentResponse object
        assertEquals(studentResponse.name(),model.getName());
        assertEquals( studentResponse.email(),model.getEmail());

    }




}