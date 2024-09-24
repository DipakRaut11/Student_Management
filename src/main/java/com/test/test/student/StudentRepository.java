package com.test.test.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentModel, Long> {
    List<StudentModel> findByName(String name);
}
