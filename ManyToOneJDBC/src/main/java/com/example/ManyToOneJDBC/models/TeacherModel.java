package com.example.ManyToOneJDBC.models;

import com.example.ManyToOneJDBC.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@ToString
public class TeacherModel {
    private int teacherId;
    private String teacherName;
    private int age;
    private List<Course> courses;
    public TeacherModel(){
        courses=new ArrayList<>();
    }
}
