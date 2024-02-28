package USERS.TEACHERS;

import USERS.TEACHERS.services.TeacherServices;

import java.util.ArrayList;
import java.util.List;

public class Teacher{
    private String username;
    private String password;
    int teacherId;
    String teacherName;
    List<String> teachingCourses;
    public Teacher(){}
    public Teacher(String teacherName,int teacherId,String username,String password){
        this.teacherName=teacherName;
        this.teacherId=teacherId;
        this.username=username;
        this.password=password;
        teachingCourses=new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getTeacherName(){
        return teacherName;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public List<String> getTeachingCourses() {
        return teachingCourses;
    }
}
