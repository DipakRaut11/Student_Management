package com.test.test.student;

import com.test.test.school.SchoolModel;
import org.springframework.stereotype.Service;

// This class is a service class that maps StudentDto to StudentModel and StudentModel to StudentResponse
@Service
public class StudentMapper {

    // This method maps a StudentDto to a StudentModel
    public StudentModel toResponse(StudentDto studentDto) {
        if (studentDto == null) {
            throw new NullPointerException("The student dto should not be null");
        }

        var student = new StudentModel();
        student.setName(studentDto.name().toUpperCase());
        student.setEmail(studentDto.email());

        var school = new SchoolModel();
        school.setId(studentDto.scId());

        student.setSchoolEntity(school);
        return student;

    }




    // This method maps a StudentModel to a StudentResponse
    public StudentResponse toEntity(StudentModel studentEntity) {
        return new StudentResponse(
                studentEntity.getName().toLowerCase(),
                studentEntity.getEmail()
        );
    }
}