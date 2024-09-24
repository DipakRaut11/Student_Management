package com.test.test.school;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.test.test.student.StudentModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SchoolModel {

    @Id
    @GeneratedValue
    private Long id;
    private String name;


    @OneToMany(
            mappedBy = "schoolEntity",
            cascade = CascadeType.ALL

    )
    @JsonManagedReference
    private List<StudentModel> students;

}
