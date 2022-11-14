package com.example.HW9.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String secondName;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<UniversityGroup> universityGroups = new ArrayList<>();

    public Teacher() {
    }

    public Teacher(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public void addUniversityGroup(UniversityGroup universityGroup) {
        this.universityGroups.add(universityGroup);
        universityGroup.setTeacher(this);
    }

    public void removeUniversityGroup(UniversityGroup universityGroup) {
        this.universityGroups.remove(universityGroup);
        universityGroup.setTeacher(null);
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

    public List<UniversityGroup> getUniversityGroups() {
        return universityGroups;
    }

    public void setUniversityGroups(List<UniversityGroup> universityGroups) {
        this.universityGroups = universityGroups;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
