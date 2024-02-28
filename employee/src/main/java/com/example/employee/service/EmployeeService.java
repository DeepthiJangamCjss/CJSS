package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class EmployeeService {
    Employee employee;

    @Autowired
    private EmployeeRepo repo;
    public EmployeeRepo getRepo() {
        return repo;
    }

    public void setRepo(EmployeeRepo repo) {
        this.repo = repo;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public ArrayList<Employee> getEmployeeList(){
        return repo.getEmployeeArrayList();
    }

    public HashMap<Integer,Employee> getEmployeeMap(){
        return repo.getEmployeeMap();
    }

    public void addEmployee(Employee employee){
//        ArrayList<Employee> employeeArrayList=repo.getEmployeeArrayList();
//        employeeArrayList.add(employee);;
//        repo.setEmployeeArrayList(employeeArrayList);
        HashMap<Integer,Employee> employeeHashMap=repo.getEmployeeMap();
        employeeHashMap.put(employee.getEmpId(), employee);
        repo.setEmployeeMap(employeeHashMap);
    }

    public boolean deleteEmployee(int employeeId){
        if(repo.getEmployeeMap().get(employeeId)==null){
            return false;
        }
        HashMap<Integer,Employee> employeeHashMap=repo.getEmployeeMap();
        employeeHashMap.remove(employeeId);
        return true;
    }

    public Employee findEmployee(int employeeId) {
        return repo.getEmployeeMap().get(employeeId);
    }

    public Object getEmployeeFullName(int employeeId) {
        Employee employee=repo.getEmployeeMap().get(employeeId);
        String fname=employee.getFirstName();
        String lname=employee.getLastName();
        return lname+" "+fname;
    }
}
