package com.test.test.student;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class StudentService {


        // Injecting the StudentRepository and StudentMapper
        private StudentRepository studentRepository;
        private StudentMapper studentMapper;

        // Saving a student
        public StudentResponse saveStudent(StudentDto studentDto){
            // Mapping the studentDto to a StudentResponse
            var student = studentMapper.toResponse(studentDto);
            // Saving the student to the repository
            var save = studentRepository.save(student);
            // Mapping the saved student to a StudentResponse
            return studentMapper.toEntity(save);
        }

        // Getting all students
        public List<StudentResponse> getAllStudents() {
            // Finding all students in the repository
            return studentRepository.findAll()
                    // Mapping each student to a StudentResponse
                    .stream()
                    .map(studentMapper::toEntity)
                    // Collecting the mapped students into a list
                    .collect(Collectors.toList());
        }


        // Getting a student by id
        public StudentResponse getStudentById(Long id){
            // Finding a student by id in the repository
            return studentRepository.findById(id)
                    // Mapping the found student to a StudentResponse
                    .map(studentMapper::toEntity)
                    // If no student is found, return null
                    .orElse(null);

        }

        // Getting a student by name
        public List<StudentResponse> getStudentByName(String name){

            // Finding students by name in the repository
            return studentRepository.findByName(name)
                    // Mapping each found student to a StudentResponse
                    .stream()
                    .map(studentMapper::toEntity)
                    // Collecting the mapped students into a list
                    .collect(Collectors.toList());

        }

        // Deleting a student by id
        public void delete(Long id){
            // Deleting a student by id from the repository
            studentRepository.deleteById(id);
        }




}