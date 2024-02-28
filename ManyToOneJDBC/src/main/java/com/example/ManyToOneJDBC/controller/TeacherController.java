package com.example.ManyToOneJDBC.controller;

import com.example.ManyToOneJDBC.entity.Course;
import com.example.ManyToOneJDBC.models.CourseModel;
import com.example.ManyToOneJDBC.models.TeacherModel;
import com.example.ManyToOneJDBC.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    TeacherService service;


    @RequestMapping("/")
    public String startPage(){
        return "start";
    }

    @RequestMapping("/addTeacher")
    public String addTeacher(Model model){
        TeacherModel teacherModel=new TeacherModel();
        model.addAttribute("teacherModel",teacherModel);
        return "addTeacher";
    }

    @RequestMapping("/saveTeacher")
    public String saveTeacher(TeacherModel teacherModel,String teacherName,int age,Model model){
        teacherModel.setTeacherName(teacherName);
        teacherModel.setAge(age);
        TeacherModel teacherModel1= service.saveTeacher(teacherModel);
        model.addAttribute("teacherModel",teacherModel);
        System.out.println(teacherModel1);
        return "teacherDetails";
    }

    @RequestMapping("/addCourses")
    public String addCourses(int teacherId,Model model){
        model.addAttribute("teacherId",teacherId);
        return "addCourses";
    }

    @RequestMapping("/saveCourse")
    public String saveCourse(int teacherId,String courseName,int year,Model model){
        CourseModel courseModel=new CourseModel(courseName,year);
        System.out.println(courseModel);
        System.out.println(teacherId);
        TeacherModel teacherModel= service.saveCourse(teacherId,courseModel);
        model.addAttribute("teacherModel",teacherModel);
        System.out.println(teacherModel);
        return "teacherDetails";
    }

    @RequestMapping("/viewTeachers")
    public String viewAllTeachers(Model model){
        ArrayList<TeacherModel> teacherModelList=service.getTeacherdetails();
        model.addAttribute("teacherModelList",teacherModelList);
        return "viewAllTeachers";
    }

    @RequestMapping("/viewTeacherDetails")
    public String viewSpecificTeacherDetails(int teacherId,Model model){
        TeacherModel teacherModel=service.getTeacherById(teacherId);
        model.addAttribute("teacherModel",teacherModel);
        return "viewSpecificTeacher";
    }

    @RequestMapping("/deleteteacher")
    public String deleteteacher(int teacherId,Model model){
        service.deleteTeacher(teacherId);
        ArrayList<TeacherModel> teacherModelList=service.getTeacherdetails();
        model.addAttribute("teacherModelList",teacherModelList);
        return "viewAllTeachers";
    }

    @RequestMapping("/deleteCourse")
    public String deleteCourse(int teacherId,int courseId,Model model){
        TeacherModel teacherModel=service.getTeacherById(teacherId);
        model.addAttribute("teacherModel",teacherModel);
        service.deleteCourse(teacherId,courseId);
        return "viewSpecificTeacher";
    }

    @RequestMapping("/updateCourse")
    public String updateCourse(@RequestParam("courseId") int courseId,int teacherId,Model model){
        Course course= service.getCourseById(courseId);
        model.addAttribute("course",course);
        model.addAttribute("teacherId",teacherId);
        return "updateCourse";
    }

    @RequestMapping("/updateCourseDetails")
    public String updateCourseDetails(@RequestParam int teacherId,int courseId,String courseName,int year,Model model){
        Course course=new Course(courseId,courseName,year);
        service.updateCourse(course);
        TeacherModel teacherModel=service.getTeacherById(teacherId);
        model.addAttribute(teacherModel);
        return "viewSpecificTeacher";
    }
}
