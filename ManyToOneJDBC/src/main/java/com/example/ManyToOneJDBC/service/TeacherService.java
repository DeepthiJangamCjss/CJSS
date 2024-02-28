package com.example.ManyToOneJDBC.service;

import com.example.ManyToOneJDBC.entity.Course;
import com.example.ManyToOneJDBC.entity.Teacher;
import com.example.ManyToOneJDBC.models.CourseModel;
import com.example.ManyToOneJDBC.models.TeacherModel;
import com.example.ManyToOneJDBC.repository.CourseRepository;
import com.example.ManyToOneJDBC.repository.TeacherRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.XMLFormatter;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository repo;
    @Autowired
    CourseRepository courseRepo;
    public TeacherModel saveTeacher(TeacherModel teacherModel) {
        Teacher teacher=new Teacher();
        BeanUtils.copyProperties(teacherModel,teacher);
        repo.save(teacher);
        teacherModel.setTeacherId(teacher.getTeacherId());
        return teacherModel;
    }

    public TeacherModel saveCourse(int teacherId, CourseModel courseModel) {
        Course course=new Course();
        BeanUtils.copyProperties(courseModel,course);

        Teacher teacher=repo.findById(teacherId).get();
        List<Course> courseList = teacher.getCourses();
        courseList.add(course);
        teacher.setCourses(courseList);

        course.setTeacher(teacher);
        repo.save(teacher);
        TeacherModel teacherModel=new TeacherModel();
        BeanUtils.copyProperties(teacher,teacherModel);
        return teacherModel;
    }

    public ArrayList<TeacherModel> getTeacherdetails() {
        List<Teacher> teachersList=repo.findAll();
        ArrayList<TeacherModel> teacherModelList=new ArrayList<>();
        teachersList.forEach(teacher -> {
            TeacherModel teacherModel=new TeacherModel();
            BeanUtils.copyProperties(teacher,teacherModel);
            teacherModelList.add(teacherModel);
        });
        return teacherModelList;
    }

    public TeacherModel getTeacherById(int teacherId) {
        List<Teacher> teachersList=repo.findAll();
        Teacher teacher= teachersList.stream().filter(teacherObj -> teacherObj.getTeacherId()==teacherId).findFirst().orElse(null);
        TeacherModel teacherModel=new TeacherModel();
        BeanUtils.copyProperties(teacher,teacherModel);
        return teacherModel;

    }

    public void deleteTeacher(int teacherId) {
        Teacher teacher= repo.findById(teacherId).orElse(null);
        if(teacher!=null){
            repo.delete(teacher);
        }
    }

    public void deleteCourse(int teacherId, int courseId) {
        Teacher teacher=repo.findById(teacherId).orElse(null);
        Course course=courseRepo.getReferenceById(courseId);
        courseRepo.delete(course);
    }

    public Course getCourseById(int courseId) {
        Course course=courseRepo.getReferenceById(courseId);
        return course;
    }

    public void updateCourse(Course course) {
        Course updateCourse = courseRepo.getReferenceById(course.getCourseId());
        if(updateCourse!=null){
            updateCourse.setCourseName(course.getCourseName());
            updateCourse.setCourseYear(course.getCourseYear());
            courseRepo.save(updateCourse);
        }
    }
}
