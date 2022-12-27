package com.example.HW9.service.impl;

import com.example.HW9.entity.Student;
import com.example.HW9.entity.UniversityGroup;
import com.example.HW9.repository.TeacherRepository;
import com.example.HW9.service.StudentService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final TeacherRepository teacherRepository;

    public StudentServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Student> showAllStudentsForCertainTeacher(Long teacherId) {
        List<Student> studentList = new ArrayList<>();
        List<UniversityGroup> universityGroups = new ArrayList<>();
        universityGroups.addAll(teacherRepository.findById(teacherId).get().getUniversityGroups());
        for (int i = 0; i < universityGroups.size(); i++) {
            studentList.addAll(universityGroups.get(i).getStudents());
        }
        return studentList;
    }
}
