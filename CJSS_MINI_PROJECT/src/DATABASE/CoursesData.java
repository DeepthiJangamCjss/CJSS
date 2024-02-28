package DATABASE;

import java.util.HashMap;

public class CoursesData {
    public static HashMap<Integer,String> courseDetails=new HashMap<>();
    public CoursesData(){
        courseDetails.put(1,"Java");
        courseDetails.put(2, "Python");
        courseDetails.put(3, "DSA");
        courseDetails.put(4, "React");
        courseDetails.put(5, "Java Script");
        courseDetails.put(6, "MySQL");
        courseDetails.put(7,"PPS");
    }
}
