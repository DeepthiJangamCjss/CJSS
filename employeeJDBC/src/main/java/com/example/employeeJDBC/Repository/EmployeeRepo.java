package com.example.employeeJDBC.Repository;

import com.example.employeeJDBC.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

}
