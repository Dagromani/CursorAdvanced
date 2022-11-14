package com.example.HW9.service;

import com.example.HW9.entity.Student;

public interface UniversityGroupService {

    void addStudentToGroup(Student student , Long id);

    void deleteStudentFromGroup(Long studentId);
}
