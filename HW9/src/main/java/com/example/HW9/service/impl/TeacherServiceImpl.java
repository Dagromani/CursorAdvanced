package com.example.HW9.service.impl;

import com.example.HW9.entity.Teacher;
import com.example.HW9.entity.UniversityGroup;
import com.example.HW9.repository.TeacherRepository;
import com.example.HW9.repository.UniversityGroupRepository;
import com.example.HW9.service.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final UniversityGroupRepository universityGroupRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository, UniversityGroupRepository universityGroupRepository) {
        this.teacherRepository = teacherRepository;
        this.universityGroupRepository = universityGroupRepository;
    }

    @Override
    public void addGroupToTeacher(UniversityGroup universityGroup, Long id) {
        Teacher teacher = teacherRepository.findById(id).get();
        teacher.addUniversityGroup(universityGroup);
        universityGroupRepository.save(universityGroup);
        teacherRepository.save(teacher);
    }

    @Override
    public void deleteGroupFromTeacher(Long groupId) {
        Teacher teacher = universityGroupRepository.findById(groupId).get().getTeacher();
        teacher.removeUniversityGroup(universityGroupRepository.findById(groupId).get());
        teacherRepository.save(teacher);
    }

    @Override
    public int teacherNumberOfGroups(Long teacherId) {
        return teacherRepository.findById(teacherId).get().getUniversityGroups().size();
    }
}
