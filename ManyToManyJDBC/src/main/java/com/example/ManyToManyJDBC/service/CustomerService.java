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
public class CustomerService {
    @Autowired
    ProductRepository productRepo;

    @Autowired
    CustomerRepository customerRepo;
    public void saveCustomer(CustomerModel customerModel) {
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerModel,customer);
        customerRepo.save(customer);

        System.out.println(customer);
    }

    public ArrayList<CustomerModel> getCustomersList() {
        List<Customer> customerList=customerRepo.findAll();
        List<CustomerModel> customerModelList=new ArrayList<>();
        customerList.forEach(customer -> {
            CustomerModel customerModel=new CustomerModel();
            BeanUtils.copyProperties(customer,customerModel);
            customerModelList.add(customerModel);
        });
        return (ArrayList<CustomerModel>) customerModelList;
    }

    public CustomerModel getCustomerById(int customerId) {
        Customer customer=customerRepo.getReferenceById(customerId);
        CustomerModel customerModel=new CustomerModel();
        BeanUtils.copyProperties(customer,customerModel);
        return customerModel;
    }

    public void buyProduct(int productId, int customerId) {
        Customer customer=customerRepo.getReferenceById(customerId);
        Product product=productRepo.getReferenceById(productId);

        List<Product> productList = customer.getProductList();
        List<Customer> customerList=product.getCustomerList();

        productList.add(product);
        customerList.add(customer);

        customer.setProductList(productList);
        product.setCustomerList(customerList);

        customerRepo.save(customer);
        productRepo.save(product);
    }

    public void removeProduct(int productId, int customerId) {
        Customer customer=customerRepo.getReferenceById(customerId);
        Product product=productRepo.getReferenceById(productId);

        List<Product> productList = customer.getProductList();
        List<Customer> customerList=product.getCustomerList();

        productList.remove(product);
        customerList.remove(customer);

        customer.setProductList(productList);
        product.setCustomerList(customerList);

        customerRepo.save(customer);
        productRepo.save(product);
    }

    public ProductModel getProductById(int productId) {
        Product product=productRepo.getReferenceById(productId);
        ProductModel productModel=new ProductModel();
        BeanUtils.copyProperties(product,productModel);
        return productModel;
    }

    public void deleteProduct(int productId) {
        Product product=productRepo.getReferenceById(productId);
        List<Customer> customerList=product.getCustomerList();

        for(Customer customer: customerList){
            List<Product> productList=customer.getProductList();
            if(productList.contains(product)){
                productList.remove(product);
                customer.setProductList(productList);
                customerRepo.save(customer);
            }
        }

        product.setCustomerList(new ArrayList<>());
        productRepo.delete(product);
    }

    public void deleteCustomer(int customerId) {
        Customer customer=customerRepo.getReferenceById(customerId);
        List<Product> productList=customer.getProductList();

        for(Product product: productList){
            List<Customer> customerList=product.getCustomerList();
            if(customerList.contains(customer)){
                customerList.remove(customer);
                product.setCustomerList(customerList);
                productRepo.save(product);
            }
        }

        customer.setProductList(new ArrayList<>());
        customerRepo.delete(customer);
    }
}
