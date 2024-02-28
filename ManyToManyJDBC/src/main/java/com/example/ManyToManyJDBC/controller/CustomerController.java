package com.example.ManyToManyJDBC.controller;

import com.example.ManyToManyJDBC.entity.Customer;
import com.example.ManyToManyJDBC.entity.Product;
import com.example.ManyToManyJDBC.models.CustomerModel;
import com.example.ManyToManyJDBC.models.ProductModel;
import com.example.ManyToManyJDBC.service.CustomerService;
import com.example.ManyToManyJDBC.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    ProductService productService;

    @RequestMapping("/")
    public String startPage(){
        return "start";
    }

    @RequestMapping("/addCustomer")
    public String addCustomer(Model model){
        CustomerModel customerModel=new CustomerModel();
        model.addAttribute("customerModel",customerModel);
        return "addCustomer";
    }

    @RequestMapping("/saveCustomer")
    public String saveCustomer(CustomerModel customerModel,String customerName,int age,String city){
        customerModel=new CustomerModel(customerName,age,city);
        customerService.saveCustomer(customerModel);
        return "start";
    }

    @RequestMapping("/viewCustomers")
    public String viewCustomers(Model model){
        ArrayList<CustomerModel> customerModelList=customerService.getCustomersList();
        System.out.println(customerModelList);
        model.addAttribute("customerModelList",customerModelList);
        return "viewAllCustomers";
    }
    @RequestMapping("/addProduct")
    public String addroduct(Model model){
        ProductModel productModel=new ProductModel();
        model.addAttribute("productModel",productModel);
        return "addProduct";
    }
    @RequestMapping("/saveProduct")
    public String saveproduct(ProductModel productModel,String productName,int price){
        productModel=new ProductModel(productName,price);
        productService.saveProduct(productModel);
        return "start";
    }
    @RequestMapping("/viewProducts")
    public String viewProducts(Model model){
        ArrayList<ProductModel> productModelList=productService.getProductsList();
        System.out.println(productModelList);
        model.addAttribute("productModelList",productModelList);
        return "viewAllProducts";
    }

    @RequestMapping("/viewCustomerdetails")
    public String viewSpecificCustomerDetails(int customerId,Model model){
        CustomerModel customerModel=customerService.getCustomerById(customerId);
        List<ProductModel> allProductsList= productService.getProductsList();
        model.addAttribute("customerModel",customerModel);
        model.addAttribute("allProductsList",allProductsList);
        return "viewSpecificCustomerDetails";
    }

    @RequestMapping("/customerBuyProducts")
    public String buySpecificCustomerDetails(int customerId,Model model){
        CustomerModel customerModel=customerService.getCustomerById(customerId);
        List<ProductModel> allProductsList= productService.getProductsList();
        model.addAttribute("customerModel",customerModel);
        model.addAttribute("allProductsList",allProductsList);
        System.out.println(allProductsList);
        System.out.println(customerModel.getProductList());
        return "buyProduct";
    }

    @RequestMapping("/buyProductByCustomer")
    public String buyProductByCustomer(int productId,int customerId,Model model){
        customerService.buyProduct(productId,customerId);

        CustomerModel customerModel=customerService.getCustomerById(customerId);
        List<ProductModel> allProductsList= productService.getProductsList();
        model.addAttribute("customerModel",customerModel);
        model.addAttribute("allProductsList",allProductsList);
        return "viewSpecificCustomerDetails";
    }

    @RequestMapping("/removeProductByCustomer")
    public String removeProductByCustomer(int productId,int customerId,Model model){
        customerService.removeProduct(productId,customerId);

        CustomerModel customerModel=customerService.getCustomerById(customerId);
        List<ProductModel> allProductsList= productService.getProductsList();
        model.addAttribute("customerModel",customerModel);
        model.addAttribute("allProductsList",allProductsList);
        return "viewSpecificCustomerDetails";
    }

    @RequestMapping("/viewProductDetails")
    public String viewSpecificProductDetails(int productId,Model model){
        ProductModel productModel=customerService.getProductById(productId);

        List<CustomerModel> allCustomersList= customerService.getCustomersList();
        model.addAttribute("productModel",productModel);
        model.addAttribute("allCustomersList",allCustomersList);
        return "viewSpecificProductDetails";
    }

    @RequestMapping("/deleteProduct")
    public String deleteProduct(int productId,Model model){
        customerService.deleteProduct(productId);

        ArrayList<ProductModel> productModelList=productService.getProductsList();
        System.out.println(productModelList);
        model.addAttribute("productModelList",productModelList);
        return "viewAllProducts";
    }

    @RequestMapping("/deleteCustomer")
    public String deleteCustomer(int customerId,Model model){
        customerService.deleteCustomer(customerId);

        ArrayList<CustomerModel> customerModelList=customerService.getCustomersList();
        System.out.println(customerModelList);
        model.addAttribute("customerModelList",customerModelList);
        return "viewAllCustomers";
    }
}
