package com.example.HW9.web;

import com.example.HW9.entity.Student;
import com.example.HW9.service.UniversityGroupService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/group")
public class UniversityGroupController {

    private final UniversityGroupService universityGroupService;


    public UniversityGroupController(UniversityGroupService universityGroupService) {
        this.universityGroupService = universityGroupService;
    }

    @PostMapping("/groupadd")
    public void addStudentToGroup(@RequestBody Student student ,@RequestParam Long id) {
        universityGroupService.addStudentToGroup(student , id);
    }

    @DeleteMapping("/deletestudentfromgroup")
    public void deleteStudentFromGroup(@RequestParam Long id){
        universityGroupService.deleteStudentFromGroup(id);
    }
}
