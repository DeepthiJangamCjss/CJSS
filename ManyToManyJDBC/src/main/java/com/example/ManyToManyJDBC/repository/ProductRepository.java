package com.example.ManyToManyJDBC.repository;

import com.example.ManyToManyJDBC.entity.Customer;
import com.example.ManyToManyJDBC.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

}
