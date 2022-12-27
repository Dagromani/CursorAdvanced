package com.example.HW9.service;

import com.example.HW9.entity.Student;
import java.util.List;

public interface StudentService {

    List<Student> showAllStudentsForCertainTeacher(Long teacherId);
}
