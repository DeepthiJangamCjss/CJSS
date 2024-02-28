package com.example.ManyToOneJDBC.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int teacherId;
    private String teacherName;
    private int age;

    public Teacher(String teacherName, int age) {
        this.teacherName = teacherName;
        this.age = age;
    }

    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
    private List<Course> courses;

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", age=" + age +
                '}';
    }
}
