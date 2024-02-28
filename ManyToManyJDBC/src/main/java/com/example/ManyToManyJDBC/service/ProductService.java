package com.example.ManyToManyJDBC.service;

import com.example.ManyToManyJDBC.entity.Customer;
import com.example.ManyToManyJDBC.entity.Product;
import com.example.ManyToManyJDBC.models.CustomerModel;
import com.example.ManyToManyJDBC.models.ProductModel;
import com.example.ManyToManyJDBC.repository.CustomerRepository;
import com.example.ManyToManyJDBC.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepo;

    public void saveProduct(ProductModel productModel) {
        Product product=new Product();
        BeanUtils.copyProperties(productModel,product);
        productRepo.save(product);

        System.out.println(product);
    }

    public ArrayList<ProductModel> getProductsList() {
        List<Product> customerList=productRepo.findAll();
        List<ProductModel> productModelList=new ArrayList<>();
        customerList.forEach(product -> {
            ProductModel productModel=new ProductModel();
            BeanUtils.copyProperties(product,productModel);
            productModelList.add(productModel);
        });
        System.out.println(productModelList);
        return (ArrayList<ProductModel>) productModelList;
    }

}
