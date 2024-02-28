package com.example.ManyToManyJDBC.models;

import com.example.ManyToManyJDBC.entity.Product;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerModel {
    private int customerId;
    private String customerName;
    private int age;
    private String city;
    private List<Product> productList=new ArrayList<>();

    public CustomerModel(String customerName, int age, String city) {
        this.customerName = customerName;
        this.age = age;
        this.city = city;
        productList=new ArrayList<>();
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
