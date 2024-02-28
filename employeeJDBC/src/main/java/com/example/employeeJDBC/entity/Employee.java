package com.example.employeeJDBC.entity;
import com.example.employeeJDBC.entity.Project;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String firstName;
    private String lastName;
    private String role;

    @Embedded
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Project project;

    public Employee(String firstName, String lastName, String role, Address address, Project project) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.address = address;
        this.project = project;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                ", address=" + address +
                '}';
    }
}
