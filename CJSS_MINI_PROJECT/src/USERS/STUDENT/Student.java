package USERS.STUDENT;

import java.util.ArrayList;
import java.util.List;

import USERS.STUDENT.services.StudentServices;

public class Student{
    private String studentName;
    private int rollNumber;
    private String branch;
    private List<String> registeredCourses=new ArrayList<>();
    private String username;
    private String password;
    public Student(String studentName, int rollNumber, String branch, String username, String password) {
        this.username = username;
        this.password = password;
        this.studentName = studentName;
        this.branch = branch;
        this.rollNumber = rollNumber;
    }

    public Student() {

    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getStudentName(){
        return studentName;
    }

    public String getBranch() {
        return branch;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public List<String> getRegisteredCourses(){
        return registeredCourses;
    }

}
