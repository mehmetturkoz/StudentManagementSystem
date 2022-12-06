package com.AA_college.student_management_system.model.service;

import com.AA_college.student_management_system.model.entity.Student;
import com.AA_college.student_management_system.utility.ExceptionMessageType;
import com.AA_college.student_management_system.utility.Util;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService extends AbstractStudentService{


    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findByID(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(ExceptionMessageType.FIND_BY_ID.getValue()));
        return student;
    }

    @Override
    public Student save(Student entity) {
        try {
            return studentRepository.save(entity);
        }catch (IllegalArgumentException e){
            Util.showGeneralExceptionInfo(e);
            return null;
        }catch (OptimisticLockingFailureException e){
            Util.showGeneralExceptionInfo(e);
            return null;
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            studentRepository.deleteById(id);
        }catch (IllegalArgumentException e){
            Util.showGeneralExceptionInfo(e);
        }
    }

    @Override
    public Student edit(Student entity) {
        try {
        return studentRepository.save(entity);
        } catch (IllegalArgumentException e) {
        Util.showGeneralExceptionInfo(e);
        return null;
        }
    }
}
