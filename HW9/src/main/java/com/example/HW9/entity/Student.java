package com.example.HW9.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String secondName;
    private String gender;

    @ManyToOne
    @JoinColumn(name = "universitygroup_id")
    @JsonBackReference
    private UniversityGroup universityGroup;

    public Student() {
    }

    public Student(String firstName, String secondName, String gender) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.gender = gender;
    }

    public Student(String firstName, String secondName, String gender, UniversityGroup universityGroup) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.gender = gender;
        this.universityGroup = universityGroup;
    }

    public Student(Long id, String firstName, String secondName, String gender, UniversityGroup universityGroup) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.gender = gender;
        this.universityGroup = universityGroup;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public UniversityGroup getUniversityGroup() {
        return universityGroup;
    }

    public void setUniversityGroup(UniversityGroup universityGroup) {
        this.universityGroup = universityGroup;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
