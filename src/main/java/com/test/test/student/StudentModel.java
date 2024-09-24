package com.test.test.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.test.test.school.SchoolModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentModel {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;
    private int age;

    @ManyToOne
    @JoinColumn(name = "school_id")
    @JsonBackReference
    private SchoolModel schoolEntity;
}
