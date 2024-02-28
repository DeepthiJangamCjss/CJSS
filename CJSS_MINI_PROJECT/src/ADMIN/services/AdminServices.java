package ADMIN.services;

import ADMIN.Admin;
import DATABASE.UsersData;
import USERS.STUDENT.Student;
import USERS.STUDENT.services.StudentServices;
import USERS.TEACHERS.services.TeacherServices;
import USERS.TEACHERS.Teacher;
import DATABASE.CoursesData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AdminServices {
    public void login(){
        Admin admin=new Admin();
        Scanner sc=new Scanner(System.in);
        System.out.print("ENTER USERNAME : ");
        String username=sc.next();
        if(admin.getUsername().equals(username)){
            System.out.print("ENTER PASSWORD : ");
            String password=sc.next();
            if(password.equals(admin.getPassword())){
                System.out.println("LOGIN SUCCESSFUL");
                boolean logout=false;
                do{
                    System.out.println();
                    System.out.println("1.VIEW ALL COURSES DETAILS  \n2.ADD COURSES  \n3.MODIFY COURSES  \n4.DELETE COURSES");
                    System.out.println("5.VIEW ALL STUDENTS  \n6.VIEW ANY STUDENT DETAILS  \n7.DELETE STUDENT ");
                    System.out.println("8.VIEW ALL TEACHERS  \n9.VIEW ANY TEACHER DETAILS  \n10.DELETE TEACHER   \n11.GET STUDENTS BY COURSE NAME \n12.EACH STUDENT AND REGISTERED COURSES \n13.LOGOUT\n");
                    System.out.print("ENTER YOUR CHOICE : ");
                    int adminChoice = sc.nextInt();
                    System.out.println();
                    switch (adminChoice){
                        case 1:
                            viewCourses();
                            break;
                        case 2:
                            addCourses();
                            break;
                        case 3:
                            modifyCourses();
                            break;
                        case 4:
                            deleteCourses();
                            break;
                        case 5:
                            viewAllStudents();
                            break;
                        case 6:
                            viewAnyStudentDetails();
                            break;
                        case 7:
                            deleteStudent();
                            break;
                        case 8:
                            viewAllTeachers();
                            break;
                        case 9:
                            viewAnyTeacherDetails();
                            break;
                        case 10:
                            deleteTeacher();
                            break;
                        case 11:
                            getStudentByCourse();
                            break;
                        case 12:
                            eachStudentRegisteredCourses();
                            break;
                        case 13:
                            logout=true;
                            break;
                        default:
                            System.out.println("INVALID INPUT");
                    }
                }while(!logout);

            } else {
                System.out.println("INCORRECT PASSWORD");
            }
        } else {
            System.out.println("USERNAME DOESN'T MATCH");
        }
    }
    public void viewCourses(){
        HashMap<Integer,String> courseDetails= CoursesData.courseDetails;
        courseDetails.keySet().stream().forEach(courseId -> System.out.println("COURSE ID : "+courseId+" COURSE NAME : "+courseDetails.get(courseId)));
    }
    public void addCourses(){
        HashMap<Integer,String> courseDetails= CoursesData.courseDetails;
        Scanner scanner=new Scanner(System.in);
        System.out.print("ENTER COURSE ID : ");
        int courseId = scanner.nextInt();
        boolean isPresentCourseId = courseDetails.keySet().stream().anyMatch(x-> x==courseId);
        if(isPresentCourseId){
            System.out.println("THIS COURSE ID IS ALREADY TAKEN. CANNOT ADD THIS COURSE ID.");
        } else {
            System.out.print("ENTER COURSE NAME : ");
            String courseName = scanner.next();
            courseDetails.put(courseId,courseName);
        }
    }
    public void modifyCourses(){
        HashMap<Integer,String> courseDetails= CoursesData.courseDetails;
        Scanner scanner=new Scanner(System.in);
        System.out.print("ENTER COURSE ID : ");
        int courseId = scanner.nextInt();
        boolean isPresentCourseId = courseDetails.keySet().stream().anyMatch(x-> x==courseId);
        if( !isPresentCourseId){
            System.out.println("THIS COURSE ID IS NOT AVAILABLE \nCANNOT MODIFY IT");
        } else {
            System.out.print("ENTER COURSE NAME : ");
            String courseName = scanner.next();
            courseDetails.put(courseId,courseName);
        }
    }
    public void deleteCourses(){
        HashMap<Integer,String> courseDetails= CoursesData.courseDetails;
        Scanner scanner=new Scanner(System.in);
        System.out.print("ENTER COURSE ID : ");
        int courseId = scanner.nextInt();
        boolean isPresentCourseId = courseDetails.keySet().stream().anyMatch(x-> x==courseId);
        if( !isPresentCourseId){
            System.out.println("THIS COURSE ID IS NOT AVAILABLE \nCANNOT PERFORM DELETE ACTION ON IT");
        } else {
            System.out.println("COURSE "+courseDetails.get(courseId)+", HAS BEEN DELETED SUCCESSFULLY");
            courseDetails.remove(courseId);
        }
    }
    public void viewAllStudents(){
        ArrayList<Student> studentsList= UsersData.studentsList;
        if(!studentsList.isEmpty()){
            studentsList.stream().forEach(studentObj -> {
                System.out.println("ROLL NUMBER : "+studentObj.getRollNumber()+", NAME : "+studentObj.getStudentName());
            });
        } else {
            System.out.println("STUDENTS NOT AVAILABLE");
        }
    }
    public void viewAnyStudentDetails(){
        ArrayList<Student> studentArrayList=UsersData.studentsList;
        Scanner scanner=new Scanner(System.in);
        System.out.println("ENTER NAME : ");
        String studentName = scanner.next();
        boolean nameFound=false;
        StudentServices std;
        for(Student studentObj: studentArrayList){
            if(studentObj.getStudentName().equals(studentName)){
                nameFound=true;
                std=new StudentServices(studentObj);
                std.getDetails();
                break;
            }
        }
        if(!nameFound){
            System.out.println("STUDENT NOT PRESENT");
        }
    }

    public void deleteStudent(){
        ArrayList<Student> studentArrayList=UsersData.studentsList;
        Scanner scanner=new Scanner(System.in);
        System.out.println("ENTER NAME : ");
        String studentName = scanner.next();
        boolean nameFound=false;
        for(Student studentObj: studentArrayList){
            if(studentObj.getStudentName().equals(studentName)){
                nameFound=true;
                studentArrayList.remove(studentObj);
                System.out.println(studentName+" DELETED SUCCESSFULLY");
                break;
            }
        }
        if(!nameFound){
            System.out.println("STUDENT NOT PRESENT\nCANNOT PREFORM DELETE OPERATION");
        }
    }
    public void viewAllTeachers(){
        ArrayList<Teacher> studentsList= UsersData.teachersList;
        if(!studentsList.isEmpty()){
            studentsList.stream().forEach(teacherObj ->{
                System.out.println("ID : "+teacherObj.getTeacherId()+", NAME : "+teacherObj.getTeacherName());
            });
        } else {
            System.out.println("TEACHERS NOT AVAILABLE");
        }
    }
    public void viewAnyTeacherDetails(){
        ArrayList<Teacher> teacherArrayList=UsersData.teachersList;
        Scanner scanner=new Scanner(System.in);
        System.out.println("ENTER NAME : ");
        String teacherName = scanner.next();
        TeacherServices t;
        boolean nameFound=false;
        for(Teacher teacherObj: teacherArrayList){
            if(teacherObj.getTeacherName().equals(teacherName)){
                nameFound=true;
                t=new TeacherServices(teacherObj);
                t.getDetails();
                break;
            }
        }
        if(!nameFound){
            System.out.println("TEACHER WITH THAT NAME IS NOT AVAILABLE");
        }
    }

    public void deleteTeacher(){
        ArrayList<Teacher> teacherArrayList=UsersData.teachersList;
        Scanner scanner=new Scanner(System.in);
        System.out.println("ENTER NAME : ");
        String teacherName = scanner.next();
        boolean nameFound=false;
        for(Teacher teacherObj:teacherArrayList){
            if(teacherObj.getTeacherName().equals(teacherName)){
                nameFound=true;
                teacherArrayList.remove(teacherObj);
                System.out.println(teacherName+" DELETED SUCCESSFULLY");
                break;
            }
        }
        if(!nameFound){
            System.out.println("TEACHER NOT PRESENT\nCANNOT PREFORM DELETE OPERATION");
        }
    }

    void getStudentByCourse(){
        ArrayList<Student> studentArrayList=UsersData.studentsList;
        Scanner scanner=new Scanner(System.in);
        System.out.print("COURSE NAME : ");
        String courseName=scanner.next();
        ArrayList<String> students= new ArrayList<>();
        studentArrayList.stream().forEach(studentObj-> {
            if(studentObj.getRegisteredCourses().contains(courseName)){
                students.add(studentObj.getStudentName());
            }
        });
        if(!students.isEmpty()){
            System.out.println("STUDENTS ENROLLED IN THIS COURSE ARE : "+students);
        } else {
            System.out.println("NO STUDENT ENROLLED IN THIS COURSE");
        }
    }

    void eachStudentRegisteredCourses(){
        ArrayList<Student> studentsList=UsersData.studentsList;
        if(!studentsList.isEmpty()){
            studentsList.forEach(studentObj ->{
                System.out.println("\nNAME : "+studentObj.getStudentName());
                System.out.println("REGISTERED COURSES : "+studentObj.getRegisteredCourses());
            });
        } else {
            System.out.println("NO STUDENTS AVAILABLE");
        }
    }
}
