package com.example.employee.Controller;


import com.example.employee.model.Employee;
import com.example.employee.repo.EmployeeRepo;
import com.example.employee.service.EmployeeService;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @RequestMapping("/")
    public String employee(){
        return "start";
    }

    @RequestMapping("/add")
    public String addEmp(){
        return "addEmployee";
    }

    @RequestMapping("/addEmployee")
    public String addEmloyee(@RequestParam("empId") int empId, Model model){
        Employee employee=service.findEmployee(empId);
        model.addAttribute("addEmployee",employee);
        model.addAttribute("employeeId",empId);
        return "addEmployeeSuccess";
    }

    @RequestMapping("/addEmployeeSuccess")
    public String addEmployeeSuccess(int empId, String firstName, String lastName, String role, Model model){
        Employee employee=new Employee(empId,firstName,lastName,role);
        model.addAttribute("addEmployee",employee);
        model.addAttribute("employee",employee);
        System.out.println(employee.getEmpId());
        service.addEmployee(employee);
        return "start";
    }

    @RequestMapping("/viewEmployees")
    public String viewAllEmployees(Model model){
//        ArrayList<Employee> employeeArrayList= service.getEmployeeList();
//        model.addAttribute("employeeList",employeeArrayList);

        HashMap<Integer,Employee> employeeMap=service.getEmployeeMap();
        model.addAttribute("employeeMap",employeeMap);
        System.out.println(employeeMap);
        return "allEmployees";
    }

    @RequestMapping("/searchEmployee")
    public String searchEmployee(Model model){
        return "searchEmployee";
    }

    @RequestMapping("/searchEmployeeResult")
    public String searchEmployeeResult(@RequestParam("employeeId") int employeeId, Model model){
        Employee employee=service.findEmployee(employeeId);
        model.addAttribute("searchEmployee",employee);
        return "searchEmployeeResult";
    }

    @RequestMapping("/updateEmployee")
    public String updateEmployee(Model model){
        return "updateEmployee";
    }

    @RequestMapping("/updateEmployeeResult")
    public String updateEmployeeResult(@RequestParam("employeeId") int employeeId, Model model){
        Employee employee=service.findEmployee(employeeId);
        model.addAttribute("updateEmployee",employee);
        return "updateEmployeeResult";
    }

    @RequestMapping("/updateEmployeeSuccess")
    public String updateEmployeeSuccess(int empId,String firstName, String lastName, String role, Model model){
        Employee employee=new Employee(empId,firstName,lastName,role);
        service.addEmployee(employee);
        return "updateEmployeeSuccess";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(){
        return "deleteEmployee";
    }

    @RequestMapping("/deleteEmployeeResult")
    public String deleteEmployeeResult(@RequestParam("employeeId") int employeeId,Model model){
        if(service.findEmployee(employeeId)!=null){
            model.addAttribute("employeeName",service.getEmployeeFullName(employeeId));;
        }
        boolean deletedEmployee=service.deleteEmployee(employeeId);
        model.addAttribute("deletedEmployee",deletedEmployee);
        return "deleteEmployeeResult";
    }

    @RequestMapping("/viewAnyEmployee")
    public String viewAnyEmployeeData(Model model){
        HashMap<Integer,Employee> employeeMap=service.getEmployeeMap();
        model.addAttribute("employeeMap",employeeMap);
        return "anyEmployee";
    }
}
