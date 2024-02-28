import ADMIN.services.AdminServices;
import DATABASE.CoursesData;
import DATABASE.UsersData;
import USERS.STUDENT.services.StudentServices;
import USERS.TEACHERS.services.TeacherServices;
import java.util.Scanner;
public class MainImpl {
    public void doAction(){
        CoursesData c=new CoursesData();
        UsersData d=new UsersData();
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("1.Continue   2.Exit ");
            System.out.print("CHOOSE 1 or 2 : ");
            int chooseOption=scanner.nextInt();
            if(chooseOption==1){
                System.out.println("1.ADMIN   2.STUDENT   3.TEACHER");
                System.out.print("CHOOSE FROM ABOVE : ");
                try{
                    int chooseNum=scanner.nextInt();
                    System.out.println();
                    switch (chooseNum){
                        case 1:
                            AdminServices admin=new AdminServices();
                            admin.login();
                            break;
                        case 2:
                            System.out.print("1.REGISTER  2.LOGIN  3.GO BACK :  ");
                            int studentChoice=scanner.nextInt();
                            StudentServices student=new StudentServices();
                            switch (studentChoice){
                                case 1:
                                    student.register();
                                    break;
                                case 2:
                                    student.login();
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("INVALID INPUT");
                            }
                            break;
                        case 3:
                            System.out.print("1.REGISTER  2.LOGIN  3.GO BACK :  ");
                            int teacherChoice=scanner.nextInt();
                            TeacherServices teacher=new TeacherServices();
                            switch (teacherChoice){
                                case 1:
                                    teacher.register();
                                    break;
                                case 2:
                                    teacher.login();
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("INVALID INPUT");
                            }
                            break;
                        default:
                            System.out.println("Invalid Input");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if(chooseOption==2) {
                break;
            } else {
                System.out.println("Invalid Input");
            }
            System.out.println("\n");
        }
    }
}
