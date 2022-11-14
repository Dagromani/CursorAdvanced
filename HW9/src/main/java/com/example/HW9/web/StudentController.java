package com.example.HW9.web;

import com.example.HW9.entity.Student;
import com.example.HW9.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getallstudentsforteacher")
    public List<Student> getAllStudentsForTeacher (@RequestParam Long teacherId){
        return studentService.showAllStudentsForCertainTeacher(teacherId);
    }
}
