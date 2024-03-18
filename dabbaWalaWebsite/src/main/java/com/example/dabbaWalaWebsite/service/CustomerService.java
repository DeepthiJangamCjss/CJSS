package com.example.dabbaWalaWebsite.service;

import com.example.dabbaWalaWebsite.conversions.ModelEntityConversions;
import com.example.dabbaWalaWebsite.entity.*;
import com.example.dabbaWalaWebsite.models.*;
import com.example.dabbaWalaWebsite.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private LocationRepo locationRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private RestaurantRepo restaurantRepo;
    @Autowired
    private RecepieRepo recepieRepo;
    @Autowired
    private ModelEntityConversions converter;
    @Autowired
    private CustomerOrderRepo customerOrderRepo;

    public CustomerModel getCustomerByUsername(String username) {
        Customer customer=customerRepo.findByUsername(username);
        CustomerModel customerModel=converter.customerEntityToModel(customer);
        return customerModel;
    }

    public boolean addCustomer(CustomerModel customerModel) {
        Customer customerFound = customerRepo.findByUsername(customerModel.getUsername());
        if(customerFound!=null){
            //return "User with this username Already Exists. Try with other username";
            return false;
        }
        Customer customer=converter.customerModelToEntity(customerModel);
        customerRepo.save(customer);
        return true;
        //return "Customer added Successfully";
    }

    public CustomerModel getCustomerDetails(int customerId) {
        boolean customerFound= customerRepo.existsById(customerId);
        if(customerFound){
            Customer customer= customerRepo.getReferenceById(customerId);
            return converter.customerEntityToModel(customer);
        }
        return null;
    }

    public boolean authenticateCustomer(String username, String password) {
        Customer customer=customerRepo.findByUsername(username);
        return customer!=null && customer.getPassword().equals(password);
    }

    public List<RestaurantModel> getRestautantModelsList() {
        List<RestaurantModel> restaurantModelList=new ArrayList<>();
        List<Restaurant> restaurantList=restaurantRepo.findAll();
        restaurantList.forEach(restaurant -> restaurantModelList.add(converter.restaurantEntityToModel(restaurant)));
        System.out.println(restaurantModelList);
        return restaurantModelList;
    }

    public List<RecepieModel> getRecepiesForRestaurant(int restaurantId) {
        List<RecepieModel> recepieModelList=new ArrayList<>();
        Restaurant restaurant=restaurantRepo.getReferenceById(restaurantId);
        List<Recepie> recepieList=restaurant.getRecepieList();
        recepieList.forEach(recepie -> recepieModelList.add(converter.recepieEntityToModel(recepie)));
        return recepieModelList;
    }

    public RestaurantModel getRestaurantModelById(int restaurantId) {
        Restaurant restaurant=restaurantRepo.getReferenceById(restaurantId);
        return converter.restaurantEntityToModel(restaurant);
    }

    public double getPriceAfterDiscount(int customerId, int recipeId) {
        Customer customer=customerRepo.getReferenceById(customerId);
        Recepie recepie=recepieRepo.getReferenceById(recipeId);
        if(customer.getMembershipType().equals("Normal")) {
            //Normal users has 10% discount
            return  (double) recepie.getPrice()*10/100;
        } else {
            //platinum users has 15% discount
            return (double) recepie.getPrice() -(double) recepie.getPrice()*15/100;
        }

    }

    public RecepieModel getRecepieModel(int recipeId) {
        Recepie recepie=recepieRepo.getReferenceById(recipeId);
        return converter.recepieEntityToModel(recepie);
    }

    public LocationModel getlocationModelById(int locationId) {
        Location location=locationRepo.getReferenceById(locationId);
        return converter.locationEntityToModel(location);
    }

    public void confirmOrder(int customerId, int locationId, int recipeId, double price) {

        CustomerOrder customerOrder=new CustomerOrder();
        customerOrder.setAmount(price);

        Recepie recepie=recepieRepo.getReferenceById(recipeId);
        customerOrder.setRecepieId(recipeId);
        customerOrder.setRecepieName(recepie.getRecepieName());

        customerOrder.setRestaurantId(recepie.getRestaurant().getRestaurantId());
        customerOrder.setRestaurantName(recepie.getRestaurant().getRestaurantName());

        customerOrder.setRestaurantOwnerId(recepie.getRestaurant().getRestaurantOwner().getOwnerId());
        customerOrder.setRestaurantOwnerName(recepie.getRestaurant().getRestaurantOwner().getOwnerName());

        Location location=locationRepo.getReferenceById(locationId);
        customerOrder.setLocationId(locationId);
        customerOrder.setLocationName(location.getStreet()+", "+location.getCity()+", "+location.getState());

        Customer customer=customerRepo.getReferenceById(customerId);
        customerOrder.setCustomer(customer);


        customerOrderRepo.save(customerOrder);
    }

//    public HashMap<CustomerOrderModel, LocationModel> getCustomerOrderDetails(int customerId) {
//        Customer customer=customerRepo.getReferenceById(customerId);
//        HashMap<CustomerOrderModel,LocationModel> orderDetailsMap=new HashMap<>();
//        customer.getOrderList().forEach(customerOrder -> {
//            CustomerOrderModel customerOrderModel=converter.customerOrderEntityToModel(customerOrder);
//            Location location=locationRepo.getReferenceById(customerOrder.getLocationId());
//            LocationModel locationModel=converter.locationEntityToModel(location);
//            orderDetailsMap.put(customerOrderModel,locationModel);
//        });
//        return orderDetailsMap;
//    }

    public List<CustomerOrderModel> getCustomerOrderModelList(int customerId) {
        Customer customer=customerRepo.getReferenceById(customerId);
        List<CustomerOrderModel> customerOrderModelList=new ArrayList<>();
        customer.getOrderList().forEach(customerOrder -> customerOrderModelList.add(converter.customerOrderEntityToModel(customerOrder)));
        return customerOrderModelList;
    }
}
