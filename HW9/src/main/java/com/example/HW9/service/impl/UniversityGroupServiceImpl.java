package com.example.HW9.service.impl;

import com.example.HW9.entity.Student;
import com.example.HW9.entity.UniversityGroup;
import com.example.HW9.repository.StudentRepository;
import com.example.HW9.repository.UniversityGroupRepository;
import com.example.HW9.service.UniversityGroupService;
import org.springframework.stereotype.Service;

@Service
public class UniversityGroupServiceImpl implements UniversityGroupService {

    private final UniversityGroupRepository universityGroupRepository;
    private final StudentRepository studentRepository;

    public UniversityGroupServiceImpl(UniversityGroupRepository universityGroupRepository, StudentRepository studentRepository) {
        this.universityGroupRepository = universityGroupRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void addStudentToGroup(Student student, Long id) {
        UniversityGroup universityGroup = universityGroupRepository.findById(id).get();
        universityGroup.addStudent(student);
        universityGroupRepository.save(universityGroup);
    }

    @Override
    public void deleteStudentFromGroup(Long studentId) {
        UniversityGroup universityGroup = studentRepository.findById(studentId).get().getUniversityGroup();
        universityGroup.removeStudent(studentRepository.findById(studentId).get());
        universityGroupRepository.save(universityGroup);
    }
}
