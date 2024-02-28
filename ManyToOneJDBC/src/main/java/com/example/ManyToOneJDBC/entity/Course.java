package com.example.ManyToOneJDBC.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int courseId;
    private String courseName;
    private int courseYear;

    public Course(String courseName, int courseYear) {
        this.courseName = courseName;
        this.courseYear = courseYear;
    }

    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    public Course(int courseId, String courseName, int courseYear) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseYear = courseYear;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseYear=" + courseYear +
                '}';
    }
}
