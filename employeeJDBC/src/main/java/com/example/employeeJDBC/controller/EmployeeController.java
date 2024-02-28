package com.example.employeeJDBC.controller;

import com.example.employeeJDBC.entity.Address;
import com.example.employeeJDBC.entity.Employee;
import com.example.employeeJDBC.entity.Project;
import com.example.employeeJDBC.service.EmployeeService;
import com.example.employeeJDBC.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller

public class EmployeeController {
    @Autowired
    EmployeeService service;
    @Autowired
    ProjectService projectService;

    @RequestMapping("/")
    public String startApp(){
        System.out.println("start");
        return "start";
    }

    @RequestMapping("/add")
    public String add(){
        return "addEmployee";
    }

    @RequestMapping(path="/addProject")
    public String addNewProject(String firstName, String lastName, String role, Address address, Project project, Model model){
        System.out.println(address);
        System.out.println(project);
        Employee employee=new Employee(firstName,lastName,role,address,project);

        System.out.println(project);
        model.addAttribute("employee",employee);
        System.out.println(employee);
        projectService.addProject(project);
        return "displayEmployee";
    }

    @RequestMapping(path="/addEmployee")
    public String addNewEmployee(String firstName, String lastName, String role, Address address, Project project, Model model){
        System.out.println(address);
        System.out.println(project);
        Employee employee=new Employee(firstName,lastName,role,address,project);

        System.out.println(project);
        model.addAttribute("employee",employee);
        System.out.println(employee);

        service.addEmployee(employee);
        return "displayEmployee";
    }

    @RequestMapping("/viewEmp")
    public String getAllEmployees(Model model){
        List<Employee> employees= service.getAllEmployees();
        model.addAttribute("employeesList",employees);
        System.out.println(employees);
        return "viewEmployees";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id,Model model){
        service.deleteEmployee(id);

        List<Employee> employees= service.getAllEmployees();
        model.addAttribute("employeesList",employees);
        return "redirect:/viewEmp";
    }
    @RequestMapping("/updateEmployee")
    public String updateEmployee(@RequestParam("empId") int id,Model model){
        model.addAttribute("empId",id);
        Employee employee= service.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "updateEmployee";
    }

    @RequestMapping("/updateEmployeeDetails")
    public String updateEmployeeDetails(int empId,String firstName, String lastName, String role, String street,String city,Project project, Model model){
        Address address=new Address(street,city);
        Employee employee=new Employee(empId,firstName,lastName,role,address,project);
        employee.setEmpId(empId);
        service.updateEmployee(employee);
        return "start";
    }
}
