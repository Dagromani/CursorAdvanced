package com.example.HW9.web;

import com.example.HW9.entity.UniversityGroup;
import com.example.HW9.service.TeacherService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/teacheradd")
    public void addGroupToTeacher(@RequestBody UniversityGroup universityGroup, @RequestParam Long id) {
        teacherService.addGroupToTeacher(universityGroup, id);
    }

    @DeleteMapping("/deletegroupfromteacher")
    public void deleteGroupFromTeacher(@RequestParam Long groupId) {
        teacherService.deleteGroupFromTeacher(groupId);
    }

    @GetMapping("/teachernumberofgroups")
    public int teacherNumberOfGroups(@RequestParam Long teacherId) {
        return teacherService.teacherNumberOfGroups(teacherId);
    }
}
