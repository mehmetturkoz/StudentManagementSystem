package com.AA_college.student_management_system.model.service;

import com.AA_college.student_management_system.model.entity.Student;
import com.AA_college.student_management_system.model.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractStudentService implements EntityService<Student,Integer> {

    @Autowired
    protected StudentRepository studentRepository;
}
