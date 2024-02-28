package com.example.employeeJDBC.Repository;

import com.example.employeeJDBC.entity.Employee;
import com.example.employeeJDBC.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project,Integer> {
}
