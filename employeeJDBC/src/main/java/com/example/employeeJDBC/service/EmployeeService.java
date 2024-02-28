package com.example.employeeJDBC.service;

import com.example.employeeJDBC.Repository.EmployeeRepo;
import com.example.employeeJDBC.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public void addEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return  employeeRepo.findAll();
    }

    public void deleteEmployee(int id) {
        Employee employee=employeeRepo.getReferenceById(id);
        System.out.println(employee);
        employeeRepo.delete(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    public Employee getEmployeeById(int id) {
        return employeeRepo.getReferenceById(id);
    }
}
