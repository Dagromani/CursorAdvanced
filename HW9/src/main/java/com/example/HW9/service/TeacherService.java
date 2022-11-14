package com.example.HW9.service;

import com.example.HW9.entity.UniversityGroup;

public interface TeacherService {

    void addGroupToTeacher(UniversityGroup universityGroup, Long teacherId);

    void deleteGroupFromTeacher(Long groupId);

    int teacherNumberOfGroups(Long teacherId);
}
