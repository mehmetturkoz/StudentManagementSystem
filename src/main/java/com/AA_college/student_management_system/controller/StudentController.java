package com.AA_college.student_management_system.controller;

import com.AA_college.student_management_system.model.entity.Student;
import com.AA_college.student_management_system.model.service.AbstractStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private AbstractStudentService studentService;

    @GetMapping("/students")
    public String listStudent(Model model){
        List<Student> students = studentService.getAll();
        model.addAttribute("students",students);
        return "students";
    }
    @GetMapping("/students/new")
    public  String createStudentForm(Model model){

        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";
    }
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.save(student);
        return "redirect:/students";
    }
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Integer id,Model model){
        model.addAttribute("student",studentService.findByID(id));
        return "edit_student";
    }
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Integer id,
                                @ModelAttribute("student") Student student,
                                Model model){
        Student existingStudent = studentService.findByID(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        studentService.edit(existingStudent);
        return "redirect:/students";
    }
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Integer id){
        studentService.delete(id);
        return "redirect:/students";
    }
}
