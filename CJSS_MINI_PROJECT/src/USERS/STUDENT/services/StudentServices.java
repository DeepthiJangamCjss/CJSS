package USERS.STUDENT.services;

import DATABASE.CoursesData;
import DATABASE.UsersData;
import USERS.STUDENT.Student;
import USERS.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class StudentServices  implements User {
    Student student;
    public StudentServices(){}
    public StudentServices(Student studentObj){
        this.student=studentObj;
    }
    @Override
    public void register() {
        Scanner sc=new Scanner(System.in);
        System.out.print("ENTER USERNAME : ");
        String username=sc.next();

        ArrayList<Student> studentsList= UsersData.studentsList;
        if(!studentsList.isEmpty()){
            boolean userNameExists= studentsList.stream().anyMatch(obj->obj.getUsername().equals(username));
            if(userNameExists){
                System.out.println("USERNAME ALREADY EXISTS!!!");
            } else {
                System.out.print("PASSWORD : ");
                String password=sc.next();
                System.out.println("ENTER BELOW DETAILS");
                System.out.print("\nENTER NAME : ");
                String studentName=sc.next();
                System.out.print("ENTER ROLL NUMBER : ");
                int rollNumber=sc.nextInt();
                System.out.print("ENTER BRANCH : ");
                String branch=sc.next();
                Student obj=new Student(studentName,rollNumber,branch,username,password);
                studentsList.add(obj);
                System.out.println("YOUR ACCOUNT CREATED SUCCESSFULLY\n");
            }
        } else {
            System.out.print("PASSWORD : ");
            String password=sc.next();
            System.out.println("ENTER BELOW DETAILS");
            System.out.print("\nENTER NAME : ");
            String studentName=sc.next();
            System.out.print("ENTER ROLL NUMBER : ");
            int rollNumber=sc.nextInt();
            System.out.print("ENTER BRANCH : ");
            String branch=sc.next();
            Student obj=new Student(studentName,rollNumber,branch,username,password);
            studentsList.add(obj);
        }
    }

    @Override
    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER USERNAME : ");
        String username = sc.next();
        ArrayList<Student> studentsList = UsersData.studentsList;
        if (!studentsList.isEmpty()) {
            boolean userNameExists = studentsList.stream().anyMatch(obj -> obj.getUsername().equals(username));
            if (userNameExists) {
                System.out.print("PASSWORD : ");
                String password = sc.next();
                Student matchedStudent = studentsList.stream()
                        .filter(obj -> obj.getUsername().equals(username) && obj.getPassword().equals(password))
                        .findFirst()
                        .orElse(null);

                if (matchedStudent != null) {
                    System.out.println("LOGIN SUCCESSFUL");
                    boolean logout=false;
                    student=matchedStudent;
                    do {
                        System.out.println("\n1.VIEW DETAILS");
                        System.out.println("2.VIEW ALL COURSES");
                        System.out.println("3.REGISTER COURSES");
                        System.out.println("4.ENROLLED COURSES");
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
                                enrolledCourses();
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
        System.out.println("NAME : "+student.getStudentName());
        System.out.println("ROLL NUMBER : "+student.getRollNumber());
        System.out.println("BRANCH : "+student.getBranch());
        List<String> registeredCourses=student.getRegisteredCourses();
        if(!registeredCourses.isEmpty()){
            System.out.println("ENROLLED COURSES : ");
            for(String course: registeredCourses){
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
        List<String> registeredCourses=student.getRegisteredCourses();
        Scanner scanner=new Scanner(System.in);
        System.out.println("ENTER COURSE ID TO REGISTER : ");
        int courseId = scanner.nextInt();
        HashMap<Integer,String> courseDetails=CoursesData.courseDetails;
        if (courseDetails.containsKey(courseId)) {
            String course = courseDetails.get(courseId);
            System.out.println("YOU HAVE SUCCESSFULLY REGISTERED FOR THE COURSE : " + course);
            registeredCourses.add(course);
        } else {
            System.out.println("THIS COURSE ID IS NOT AVAILABLE");
        }
    }
    public void enrolledCourses(){
        List<String> registeredCourses=student.getRegisteredCourses();
        if(!registeredCourses.isEmpty()){
            registeredCourses.forEach(course -> System.out.println(course));
        } else {
            System.out.println("NOT REGISTERED ANY COURSES");
        }
    }
}
