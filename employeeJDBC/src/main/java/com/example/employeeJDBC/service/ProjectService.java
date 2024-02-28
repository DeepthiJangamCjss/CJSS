package com.example.employeeJDBC.service;

import com.example.employeeJDBC.Repository.EmployeeRepo;
import com.example.employeeJDBC.Repository.ProjectRepo;
import com.example.employeeJDBC.entity.Employee;
import com.example.employeeJDBC.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;

    public void addProject(Project project) {
        projectRepo.save(project);
    }
}
