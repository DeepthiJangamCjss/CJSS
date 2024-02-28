package com.example.ManyToManyJDBC.models;

import com.example.ManyToManyJDBC.entity.Customer;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
    private int productId;
    private  String productName;
    private int price;
    private List<Customer> customerList=new ArrayList<>();

    public ProductModel(String productName, int price) {
        this.productName = productName;
        this.price = price;
        this.customerList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
