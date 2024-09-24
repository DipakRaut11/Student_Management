package com.test.test.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    //which service we want to test
    @InjectMocks
    private StudentService studentService;


    //declear the dependencies that the service needs

    //Mock is of org.mockito
    @Mock
    private StudentRepository repository;
    @Mock
    private StudentMapper mapper;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

    }

    @Test
    public void should_successfully_save_student() {

        StudentDto dto = new StudentDto(
                "aaa",
                "ddd",
                1L


        );

        StudentModel student = new StudentModel(
                null,
                "aaa",
                "ddd",
                22,
                null

        );

        StudentModel savedStudent = new StudentModel(
                null,
                "aaa",
                "ddd",
                22,
                null

        );
        savedStudent.setId(1L);


        //Mock the call
        when(mapper.toResponse(dto)).thenReturn(student);

        when(repository.save(student)).thenReturn(savedStudent);

        when(mapper.toEntity(savedStudent)).thenReturn(
                new StudentResponse(
                        "aaa",
                        "ddd"
                       )
        );

        //when
        StudentResponse response = studentService.saveStudent(dto);

        //then
        assertEquals(dto.name(), response.name());
        assertEquals(dto.email(), response.email());
       // assertEquals(dto.age(), response.age());


        verify(mapper, times(1))
                .toResponse(dto);
        verify(repository, times(1))
                .save(student);
        verify(mapper, times(1))
                .toEntity(savedStudent);

    }




}