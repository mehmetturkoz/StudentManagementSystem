package com.AA_college.student_management_system.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "STUDENTS")
@Entity
public class Student {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID")
    @Id
    private Integer studentID;

    @Column(name = "FIRST_NAME",nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME",nullable = false)
    private String lastName;

    @Column(name = "EMAIL",nullable = false)
    private String email;

}
