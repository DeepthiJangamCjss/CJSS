package com.example.employee.repo;

import com.example.employee.EmployeeApplication;
import com.example.employee.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class EmployeeRepo {
    ArrayList<Employee> employeeArrayList=new ArrayList<>();
    HashMap<Integer,Employee> employeeMap=new HashMap<>();

    EmployeeRepo(){
        employeeMap.put(1,new Employee(1,"Deepthi","Jangam","Java Developer"));
        employeeMap.put(2,new Employee(2,"Shreshti","Yemla","React developer"));
        employeeMap.put(3,new Employee(3,"Soumika","Sunkari","FullStack Developer"));
        employeeMap.put(4,new Employee(4,"Rishitha","Peddolla","Testing"));
        employeeMap.put(5,new Employee(5,"Prasanna","Gandham","Hr"));
    }

    public ArrayList<Employee> getEmployeeArrayList() {
        return employeeArrayList;
    }

    public void setEmployeeArrayList(ArrayList<Employee> employeeArrayList) {
        this.employeeArrayList = employeeArrayList;
    }

    public HashMap<Integer, Employee> getEmployeeMap() {
        return employeeMap;
    }

    public void setEmployeeMap(HashMap<Integer, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }

    @Override
    public String toString() {
        return "EmployeeRepo{" +
                "employeeArrayList=" + employeeArrayList +
                ", employeeMap=" + employeeMap +
                '}';
    }
}
