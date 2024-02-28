package USERS.TEACHERS.services;

import DATABASE.CoursesData;
import DATABASE.UsersData;
import USERS.TEACHERS.Teacher;
import USERS.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TeacherServices implements User {
    Teacher teacher;
    public TeacherServices(Teacher teacher){
        this.teacher=teacher;
    }
    public TeacherServices(){}
    @Override
    public void register() {
        Scanner sc=new Scanner(System.in);
        System.out.print("ENTER USERNAME : ");
        String username=sc.next();

        ArrayList<Teacher> teachersList= UsersData.teachersList;
        if(!teachersList.isEmpty()){
            boolean userNameExists= teachersList.stream().anyMatch(obj->obj.getUsername().equals(username));
            if(userNameExists){
                System.out.println("USERNAME ALREADY EXISTS!!!");
            } else {
                System.out.print("PASSWORD : ");
                String password=sc.next();
                System.out.println("ENTER BELOW DETAILS");
                System.out.print("\nENTER NAME : ");
                String teacherName=sc.next();
                System.out.print("ENTER TEACHER ID : ");
                int teacherId=sc.nextInt();
                Teacher obj=new Teacher(teacherName,teacherId,username,password);
                teachersList.add(obj);
                System.out.println("YOUR ACCOUNT CREATED SUCCESSFULLY\n");
            }
        } else {
            System.out.print("PASSWORD : ");
            String password=sc.next();
            System.out.println("ENTER BELOW DETAILS");
            System.out.print("\nENTER NAME : ");
            String teacherName=sc.next();
            System.out.print("ENTER TEACHER ID : ");
            int teacherId=sc.nextInt();
            Teacher obj=new Teacher(teacherName,teacherId,username,password);
            teachersList.add(obj);
        }
    }

    @Override
    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER USERNAME : ");
        String username = sc.next();
        ArrayList<Teacher> teachersList = UsersData.teachersList;
        if (!teachersList.isEmpty()) {
            boolean userNameExists = teachersList.stream().anyMatch(obj -> obj.getUsername().equals(username));
            if (userNameExists) {
                System.out.print("PASSWORD : ");
                String password = sc.next();
                Teacher matchedTeacher = teachersList.stream()
                        .filter(obj -> obj.getUsername().equals(username) && obj.getPassword().equals(password))
                        .findFirst()
                        .orElse(null);

                if (matchedTeacher != null) {
                    System.out.println("LOGIN SUCCESSFUL");
                    boolean logout=false;
                    teacher=matchedTeacher;
                    do {
                        System.out.println("\n1.VIEW DETAILS");
                        System.out.println("2.VIEW ALL COURSES");
                        System.out.println("3.REGISTER FOR COURSES TO TEACH");
                        System.out.println("4.TEACHING COURSES");
                        System.out.println("5.LOGOUT");
                        System.out.print("ENTER CHOICE :  ");
                        int studentChoice = sc.nextInt();
                        System.out.println();
                        switch (studentChoice) {
                            case 1:
                                getDetails();
                                break;
                            case 2:
                                displayCourses();
                                break;
                            case 3:
                                registerCourses();
                                break;
                            case 4:
                                printTeachingCourses();
                                break;
                            case 5:
                                logout = true;
                                System.out.println("LOGGED OUT SUCCESSFULLY");
                                break;
                            default:
                                System.out.println("INVALID CHOICE");
                        }
                    } while (!logout);
                } else {
                    System.out.println("INCORRECT PASSWORD");
                }
            } else {
                System.out.println("USERNAME DOESN'T EXIST");
            }
        } else {
            System.out.println("USERNAME DOESN'T EXIST");
        }
    }

    @Override
    public void getDetails() {
        System.out.println("NAME : "+teacher.getTeacherName());
        System.out.println("ID : "+teacher.getTeacherId());
        System.out.println("TEACHING COURSES : ");
        List<String> teachingCourses= teacher.getTeachingCourses();
        if(!teachingCourses.isEmpty()){
            for(String course: teachingCourses){
                System.out.print(course+"  ");
            }
        }
    }
    public void displayCourses(){
        System.out.println("COURSES AVAILABLE");
        HashMap<Integer,String> courseDetails= CoursesData.courseDetails;
        courseDetails.keySet().stream().forEach(courseId -> System.out.println("COURSE ID : "+courseId+"  COURSE NAME : "+courseDetails.get(courseId)));
    }
    public void registerCourses(){
        List<String> teachingCourses= teacher.getTeachingCourses();
        Scanner scanner=new Scanner(System.in);
        System.out.println("ENTER COURSE ID TO REGISTER : ");
        int courseId = scanner.nextInt();
        HashMap<Integer,String> courseDetails=CoursesData.courseDetails;
        if (courseDetails.containsKey(courseId)) {
            String course = courseDetails.get(courseId);
            System.out.println("You have successfully registered for the course: " + course);
            teachingCourses.add(course);
        } else {
            System.out.println("THIS COURSE ID IS NOT AVAILABLE");
        }
    }
    public void printTeachingCourses(){
        List<String> teachingCourses= teacher.getTeachingCourses();
        if(!teachingCourses.isEmpty()){
            for(String course: teachingCourses){
                System.out.println(course);
            }
        } else {
            System.out.println("NOT REGISTERED FOR ANY COURSES TO TEACH");
        }
        System.out.println();
    }

}
