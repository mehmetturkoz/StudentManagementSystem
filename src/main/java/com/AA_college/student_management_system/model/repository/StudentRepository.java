package com.AA_college.student_management_system.model.repository;

import com.AA_college.student_management_system.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student,Integer> {

}
