package com.test.test.student;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@AllArgsConstructor
public class StudentController {

    // Injecting the StudentService class
    private final StudentService studentServicer;

    // Creating a new student
    @PostMapping("/student")
    public StudentResponse create(@Valid @RequestBody StudentDto studentDto) {

        // Saving the student to the database
        return studentServicer.saveStudent(studentDto);

    }



    // Getting all students
    @GetMapping("/student")
    public List<StudentResponse> list(){
        return studentServicer.getAllStudents();
    }

    // Getting a student by id
    @GetMapping("/student/{id}")
    public StudentResponse getStudentById(@PathVariable("id") Long id){
        return studentServicer.getStudentById(id);
    }

    // Getting a student by name
    @GetMapping("/student/name/{name}")
    public List<StudentResponse> getStudentByName(@PathVariable("name") String name){
        return studentServicer.getStudentByName(name);
    }

    // Deleting a student by id
    @DeleteMapping("/student/{id}")
    public void deleteStudent(Long id){
        studentServicer.delete(id);
    }


    // Handling validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

        // Creating a map to store the errors
        var errors = new HashMap<String, String>();
        // Iterating through the errors
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            // Getting the field name and error message
            var fieldName =  ((FieldError) error).getField();
            errors.put(fieldName, error.getDefaultMessage());
        });
        // Returning the errors with a bad request status
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}