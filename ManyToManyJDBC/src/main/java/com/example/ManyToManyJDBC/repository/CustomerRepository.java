package com.example.ManyToManyJDBC.repository;

import com.example.ManyToManyJDBC.entity.Customer;
import com.example.ManyToManyJDBC.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
