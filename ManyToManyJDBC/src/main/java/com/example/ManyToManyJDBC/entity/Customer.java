package com.example.ManyToManyJDBC.entity;

import lombok.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;
    private String customerName;
    private int age;
    private String city;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name="course_product",joinColumns = @JoinColumn(name="customer_id"),
            inverseJoinColumns = @JoinColumn(name="product_id"))
    private List<Product> productList=new ArrayList<>();

    public Customer(String customerName, int age, String city) {
        this.customerName = customerName;
        this.age = age;
        this.city = city;
        productList=new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}