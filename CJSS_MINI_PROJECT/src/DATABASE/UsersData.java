package DATABASE;

import java.util.ArrayList;
import USERS.STUDENT.Student;
import USERS.TEACHERS.Teacher;
public class UsersData {
    public static ArrayList<Student> studentsList=new ArrayList<>();
    public static ArrayList<Teacher> teachersList=new ArrayList<>();
    public UsersData() {
        Student std1 = new Student("Deepthi", 31, "CSE", "Deepthi", "D12");
        Student std2 = new Student("Shreshti", 38, "ECE", "Shreshti", "123");
        Student std3 = new Student("Prasanna", 25, "EEE", "Prasanna", "abc");
        Student std4 = new Student("Soumika", 21, "CSE", "Soumika", "a11");
        studentsList.add(std1);
        studentsList.add(std2);
        studentsList.add(std3);
        studentsList.add(std4);
        Teacher t1 = new Teacher("Sannitha", 1, "Sannitha", "Sanni@1");
        Teacher t2 = new Teacher("Ravi", 2, "Ravi", "ravikumar");
        Teacher t3 = new Teacher("Raghava", 3, "Raghava", "rockstar");
        Teacher t4 = new Teacher("Rishitha", 4, "Rishitha", "rishi");
        teachersList.add(t1);
        teachersList.add(t2);
        teachersList.add(t3);
        teachersList.add(t4);
    }
}
