package com.example.ManyToOneJDBC.models;

import com.example.ManyToOneJDBC.entity.Teacher;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseModel {
    private int courseId;
    private  String courseName;
    private int courseYear;
    private Teacher teacher;

    public CourseModel(String courseName, int year) {
        this.courseName=courseName;
        this.courseYear=year;
    }
}
