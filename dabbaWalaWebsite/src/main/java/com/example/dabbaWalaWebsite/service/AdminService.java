package com.example.dabbaWalaWebsite.service;

import com.example.dabbaWalaWebsite.conversions.ModelEntityConversions;
import com.example.dabbaWalaWebsite.entity.*;
import com.example.dabbaWalaWebsite.models.*;
import com.example.dabbaWalaWebsite.repository.CustomerRepo;
import com.example.dabbaWalaWebsite.repository.LocationRepo;
import com.example.dabbaWalaWebsite.repository.RestaurantOwnerRepo;
import com.example.dabbaWalaWebsite.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminModel adminModel;
    @Autowired
    private LocationRepo locationRepo;
    @Autowired
    private RestaurantRepo restaurantRepo;

    @Autowired
    private RestaurantOwnerRepo restaurantOwnerRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelEntityConversions converter;


    public String addLocation(LocationModel locationModel) {
        boolean isAvailable = locationRepo.checkIfAvailable(locationModel.getStreet(), locationModel.getCity(), locationModel.getState());
        if(isAvailable){
            return "Location Already available. Cannot add again";
        }

        Location location= converter.locationModelToEntity(locationModel);
        locationRepo.save(location);
        return "Location added successfully";
    }

    public List<LocationModel> getAllLocations() {
        List<Location> locationList=locationRepo.findAll();
        List<LocationModel> locationModels=new ArrayList<>();
        locationList.forEach(location -> locationModels.add(converter.locationEntityToModel(location)));
        return locationModels;
    }

    public boolean authenticateAdmin(String username, String password) {
        return adminModel.getUsername().equals(username) && adminModel.getPassword().equals(password);
    }

    public void saveLocation(LocationModel locationModel) {
        boolean isAvailable = locationRepo.checkIfAvailable(locationModel.getStreet(), locationModel.getCity(), locationModel.getState());
        if(isAvailable){
            return ;
        }
        Location location= converter.locationModelToEntity(locationModel);
        locationRepo.save(location);
    }

    public void deleteLocation(int locationId) {
        Location location=locationRepo.getReferenceById(locationId);
        List<Restaurant> restaurantList=location.getRestaurantList();
        restaurantList.forEach(restaurant -> {
            List<Location> restaurantLocations=restaurant.getLocationList();
            restaurantLocations.remove(location);
            restaurant.setLocationList(restaurantLocations);
            restaurantRepo.save(restaurant);
        });
        locationRepo.delete(locationRepo.getReferenceById(locationId));
    }

    public List<RestaurantModel> getAllRestaurants() {
        List<Restaurant> restaurantList= restaurantRepo.findAll();
        List<RestaurantModel> restaurantModelList=new ArrayList<>();
        restaurantList.stream().forEach(restaurant -> restaurantModelList.add(converter.restaurantEntityToModel(restaurant)));
        return restaurantModelList;
    }

    public List<RestaurantOwnerModel> getAllRestaurantowners() {
        List<RestaurantOwnerModel> restaurantOwnerModelList=new ArrayList<>();
        List<RestaurantOwner> restaurantOwnerList=restaurantOwnerRepo.findAll();
        restaurantOwnerList.forEach(restaurantOwner -> restaurantOwnerModelList.add(converter.restaurantOwnerEntityToModel(restaurantOwner)));
        return restaurantOwnerModelList;
    }

    public List<CustomerModel> getAllCustomersList() {
        List<CustomerModel> customerModelList=new ArrayList<>();
        List<Customer> customerList=customerRepo.findAll();
        customerList.forEach(customer -> customerModelList.add(converter.customerEntityToModel(customer)));
        return customerModelList;
    }


    public void meth(){
        RestaurantModel restaurantModel=new RestaurantModel();
        restaurantModel.getRestaurantName();
        restaurantModel.getRestaurantId();
        restaurantModel.getStreet();
        restaurantModel.getCity();
        restaurantModel.getState();


        restaurantModel.getRecepieList();
        Recepie recepie=new Recepie();
        recepie.getRecepieId();
        recepie.getRecepieName();
        recepie.getPrice();
        recepie.isPremiumRecepie();

        restaurantModel.getLocationList();
        Location location=new Location();
        location.getLocationId();
        location.getStreet();
        location.getState();

        CustomerModel customerModel=new CustomerModel();
        customerModel.getCustomerId();
        customerModel.getName();
        customerModel.getAge();
        customerModel.getEmail();
        customerModel.getMembershipType();

        RestaurantOwnerModel restaurantOwnerModel=new RestaurantOwnerModel();
        restaurantOwnerModel.getOwnerId();
        restaurantOwnerModel.getOwnerName();
        restaurantOwnerModel.getRestaurantList();

        CustomerOrderModel customerOrderModel=new CustomerOrderModel();
        customerOrderModel.getAmount();
        customerOrderModel.getOrderId();
        customerOrderModel.getRecepieId();
        customerOrderModel.getOwnerApproved();
        customerOrderModel.getRestaurantName();
        customerOrderModel.getRestaurantOwnerName();
        customerOrderModel.getRecepieName();
        customerOrderModel.getLocationName();
        customerOrderModel.getCustomer().getName();


        LocationModel locationModel=new LocationModel();
        locationModel.getStreet();
        locationModel.getCity();
        locationModel.getState();

    }
}
