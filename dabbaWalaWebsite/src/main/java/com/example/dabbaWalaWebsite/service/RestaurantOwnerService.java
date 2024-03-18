package com.example.dabbaWalaWebsite.service;

import com.example.dabbaWalaWebsite.conversions.ModelEntityConversions;
import com.example.dabbaWalaWebsite.entity.*;
import com.example.dabbaWalaWebsite.models.*;
import com.example.dabbaWalaWebsite.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantOwnerService {
    @Autowired
    private CustomerOrderRepo customerOrderRepo;
    @Autowired
    private RestaurantOwnerRepo restaurantOwnerRepo;
    @Autowired
    private RestaurantRepo restaurantRepo;
    @Autowired
    private RecepieRepo recepieRepo;
    @Autowired
    private LocationRepo locationRepo;

    @Autowired
    private ModelEntityConversions converter;

    public boolean addRestaurantOwner(RestaurantOwnerModel restaurantOwnerModel) {
        boolean ownerExists = restaurantOwnerRepo.existsByUsername(restaurantOwnerModel.getUsername());
        if(ownerExists){
            return false;
            //return "Owner with this username already exists. Try with other username";
        }
        RestaurantOwner restaurantOwner=converter.restaurantOwnerModelToEntity(restaurantOwnerModel);
        restaurantOwnerRepo.save(restaurantOwner);
        return true;
        //return "Restaurant Owner registered successfully";
    }


    public RestaurantOwnerModel getOwnerDetails(int ownerId) {
        if(restaurantOwnerRepo.findById(ownerId).isPresent()){
            RestaurantOwner restaurantOwner=restaurantOwnerRepo.getReferenceById(ownerId);
            return converter.restaurantOwnerEntityToModel(restaurantOwner);
        }
        return null;
    }
    public String addRestaurant(int ownerId,RestaurantModel restaurantModel) {
        boolean restaurantOwnerFound=restaurantOwnerRepo.existsById(ownerId);
        if(!restaurantOwnerFound){
            return "Restaurant Owner id is not present";
        }
        Restaurant existingRestaurant = restaurantRepo.findByRestaurantName(restaurantModel.getRestaurantName());
        if (existingRestaurant != null) {
            return "Restaurant with this name already exists. Try with another name.";
        }
        RestaurantOwner restaurantOwner=restaurantOwnerRepo.getReferenceById(ownerId);
        Restaurant restaurant = converter.restaurantModelToEntity(restaurantModel);
        List<Restaurant> restaurantList=restaurantOwner.getRestaurantList();
        restaurant.setRestaurantOwner(restaurantOwner);
        restaurantList.add(restaurant);
        restaurantOwner.setRestaurantList(restaurantList);
        restaurantOwnerRepo.save(restaurantOwner);
        return "Restaurant added successfully";
    }

    public RestaurantModel getRestaurantDetails(int restaurantId) {
        boolean restaurantExists = restaurantRepo.existsById(restaurantId);
        if (restaurantExists) {
            Restaurant restaurant = restaurantRepo.findById(restaurantId).orElse(null);
            if (restaurant != null) {
                return converter.restaurantEntityToModel(restaurant);
            }
        }
        return null;
    }

    public String addRecepie(int ownerId,int restaurantId, RecepieModel recepieModel) {
        boolean restaurantOwnerFound=restaurantOwnerRepo.existsById(ownerId);
        if(!restaurantOwnerFound){
            return "Restaurant Owner id is not present";
        }
        boolean restaurantFound= restaurantRepo.existsById(restaurantId);
        if(!restaurantFound){
            return "restaurant with this id is not Available";
        }
        Recepie recepie=converter.recepieModelToEntity(recepieModel);
        Restaurant restaurant=restaurantRepo.getReferenceById(restaurantId);
        if(recepie==null){
            return "Recepie not added";
        }
        recepie.setRestaurant(restaurant);
        recepieRepo.save(recepie);
        return  recepie.getRecepieName()+" Added Successfully";
    }

    public RestaurantOwnerModel getRestaurantByUsername(String username) {
        RestaurantOwner restaurantOwner=restaurantOwnerRepo.findByUsername(username);
        return converter.restaurantOwnerEntityToModel(restaurantOwner);
    }

    public RestaurantOwnerModel getRestaurantOwnerByUsername(String username) {
        RestaurantOwner restaurantOwner=restaurantOwnerRepo.findByUsername(username);
        RestaurantOwnerModel restaurantOwnerModel=converter.restaurantOwnerEntityToModel(restaurantOwner);
        return restaurantOwnerModel;
    }

    public boolean authenticateRestauratOwner(String username, String password) {
        RestaurantOwner restaurantOwner=restaurantOwnerRepo.findByUsername(username);
        return restaurantOwner!=null && restaurantOwner.getPassword().equals(password);
    }

    public void saveRestaurant(RestaurantOwnerModel restaurantOwnerModel, RestaurantModel restaurantModel) {
        //Restaurant availableRestaurant = restaurantRepo.findByRestaurantName(restaurantModel.getRestaurantName());
        Boolean restaurantNamePresent=existsByRestaurantName(restaurantModel.getRestaurantName());
        //if the restaurant is already present check for location.
        //If location is different save the restaurant
        System.out.println(restaurantNamePresent);
        RestaurantOwner owner= converter.restaurantOwnerModelToEntity(restaurantOwnerModel);
        System.out.println(owner);
        List<Restaurant> ownerRestaurantList= owner.getRestaurantList();
        if(restaurantNamePresent){
            List<Restaurant> restaurantList=restaurantRepo.findAll();
            //checking if the restaurant present at that location
            boolean restaurantAvailable = restaurantList.stream()
                    .anyMatch(restaurant ->
                            restaurant.getRestaurantName().equals(restaurantModel.getRestaurantName()) &&
                                    restaurant.getCity().equals(restaurantModel.getCity()) &&
                                    restaurant.getStreet().equals(restaurantModel.getStreet()) &&
                                    restaurant.getState().equals(restaurantModel.getState())
                    );
            //if present do not save here
            if(restaurantAvailable){
                return;
            }
            Restaurant restaurant=converter.restaurantModelToEntity(restaurantModel);
            ownerRestaurantList.add(restaurant);
            restaurant.setRestaurantOwner(owner);
            owner.setRestaurantList(ownerRestaurantList);
            restaurantRepo.save(restaurant);
            restaurantOwnerRepo.saveAndFlush(owner);
            return;
        }
        //If restaurant Name is not there then save the restaurant

        Restaurant newRestaurant=converter.restaurantModelToEntity(restaurantModel);
        ownerRestaurantList.add(newRestaurant);
        System.out.println(newRestaurant);
        newRestaurant.setRestaurantOwner(owner);
        restaurantOwnerRepo.saveAndFlush(owner);
        restaurantRepo.save(newRestaurant);
    }

    private Boolean existsByRestaurantName(String restaurantName) {
        List<Restaurant> restaurantList=restaurantRepo.findAll();
        return restaurantList.stream().anyMatch(restaurant -> restaurant.getRestaurantName().equals((restaurantName)));
    }


    public void deleteRestaurant(int restaurantId) {
        boolean restautantIdPresent=restaurantRepo.findById(restaurantId).isPresent();
        if(restautantIdPresent){
            Restaurant restaurant=restaurantRepo.getReferenceById(restaurantId);
            List<Recepie> recepieList=restaurant.getRecepieList();
            recepieList.stream().forEach(recepie ->{
                recepie.setRestaurant(new Restaurant());
                recepieRepo.delete(recepie);
            });
            restaurant.setRecepieList(new ArrayList<>());

            restaurant.setLocationList(new ArrayList<>());
            System.out.println(restaurant);

            restaurant.setRestaurantOwner(new RestaurantOwner());
            restaurantRepo.delete(restaurant);
        }
    }

//    public void saveRestaurant(RestaurantOwnerModel restaurantOwnerModel, RestaurantModel restaurantModel) {
//        Restaurant restaurant=restaurantModelToEntity(restaurantModel);
//        RestaurantOwner restaurantOwner=restaurantOwnerModelToEntity(restaurantOwnerModel);
//
//        restaurant.setRestaurantOwner(restaurantOwner);
//
//        List<Restaurant> restaurantList= restaurantOwner.getRestaurantList();
//        restaurantList.add(restaurant);
//        restaurantOwner.setRestaurantList(restaurantList);
//
//        restaurantOwnerRepo.save(restaurantOwner);
//    }
//    @Transactional
//    public void saveRestaurant(RestaurantOwnerModel restaurantOwnerModel, RestaurantModel restaurantModel) {
//        // Convert RestaurantOwnerModel and RestaurantModel to entities
//        Restaurant restaurant = restaurantModelToEntity(restaurantModel);
//        RestaurantOwner restaurantOwner = restaurantOwnerModelToEntity(restaurantOwnerModel);
//
//        // Check if the restaurantOwner already exists in the database
//        if (restaurantOwner.getOwnerId() != 0) {
//            // If it exists, fetch the managed entity from the database
//            RestaurantOwner existingOwner = restaurantOwnerRepo.findById(restaurantOwner.getOwnerId()).orElse(null);
//            if (existingOwner != null) {
//                restaurant.setRestaurantOwner(restaurantOwner);
//                // Add the restaurant to the existing owner's list
//                List<Restaurant> restaurantList = existingOwner.getRestaurantList();
//                restaurantList.add(restaurant);
//                existingOwner.setRestaurantList(restaurantList);
//
//                // Save the existing owner (with the updated restaurant list)
//                restaurantOwnerRepo.save(existingOwner);
//            }
//        } else {
//            // If the owner doesn't exist yet, save the new owner along with the restaurant
//            restaurant.setRestaurantOwner(restaurantOwner);
//            restaurantOwner.getRestaurantList().add(restaurant);
//
//            // Save the owner along with the restaurant
//            restaurantOwnerRepo.save(restaurantOwner);
//        }
//    }

    public RestaurantModel getRestaurantById(int restaurantId) {
        return converter.restaurantEntityToModel(restaurantRepo.getReferenceById(restaurantId));
    }

    public void meth(){
    }

    public List<Location> getAllLocations() {
        return locationRepo.findAll();
    }

    public void addLocationToRestaurant(int restaurantId, int locationId) {
        Restaurant restaurant=restaurantRepo.getReferenceById(restaurantId);
        Location location=locationRepo.getReferenceById(locationId);

        List<Location> locationList= restaurant.getLocationList();
        locationList.add(location);
        restaurant.setLocationList(locationList);

        List<Restaurant> restaurantList=location.getRestaurantList();
        restaurantList.add(restaurant);
        location.setRestaurantList(restaurantList);

        locationRepo.save(location);
        restaurantRepo.save(restaurant);
    }

    public void removeLocationFromRestaurant(int restaurantId, int locationId) {
        Restaurant restaurant=restaurantRepo.getReferenceById(restaurantId);
        Location location=locationRepo.getReferenceById(locationId);

        List<Location> locationList= restaurant.getLocationList();
        locationList.remove(location);
        restaurant.setLocationList(locationList);

        List<Restaurant> restaurantList=location.getRestaurantList();
        restaurantList.remove(restaurant);
        location.setRestaurantList(restaurantList);

        locationRepo.save(location);
        restaurantRepo.save(restaurant);
    }

    public Restaurant getRestaurantEntityById(int restaurantId) {
        return restaurantRepo.getReferenceById(restaurantId);
    }

    private boolean checkRecipeAvailable(Restaurant restaurant,String recepieName, boolean premiumRecepie) {
        List<Recepie> recepieList=restaurant.getRecepieList();
        String lowercaseRecepieName = recepieName.toLowerCase();
        return recepieList.stream().anyMatch(recepie -> recepie.getRecepieName().toLowerCase().equals(lowercaseRecepieName) && recepie.isPremiumRecepie()==premiumRecepie);
    }
    public void addRecepieToRestaurant(RecepieModel recepieModel) {
        boolean isRecipeAvailable = checkRecipeAvailable(recepieModel.getRestaurant(),recepieModel.getRecepieName(),recepieModel.isPremiumRecepie());
        if(isRecipeAvailable){
            return;
        }
        Recepie recepie=converter.recepieModelToEntity(recepieModel);
        Restaurant restaurant=recepie.getRestaurant();

        List<Recepie> recepieList= restaurant.getRecepieList();
        recepieList.add(recepie);

        restaurantRepo.save(restaurant);
        recepieRepo.save(recepie);
    }


    public int getRestaurantIdFromRecepie(int recepieId) {
        Restaurant restaurant=recepieRepo.getReferenceById(recepieId).getRestaurant();
        return restaurant.getRestaurantId();
    }

    public void deleteRecepieFromRestaurant(int recepieId) {
        Recepie recepie=recepieRepo.getReferenceById(recepieId);
        Restaurant restaurant=recepie.getRestaurant();

        List<Recepie> recepieList= restaurant.getRecepieList();
        recepieList.remove(recepie);

        restaurantRepo.save(restaurant);
        recepieRepo.delete(recepie);
    }

    public List<CustomerOrderModel> getCustomerOrderList(int restaurantId) {
        List<CustomerOrderModel> customerOrderModelList=new ArrayList<>();
        customerOrderRepo.findAll().forEach(customerOrder -> {
            if(customerOrder.getRestaurantId()==restaurantId){
                customerOrderModelList.add(converter.customerOrderEntityToModel(customerOrder));
            }
        });
        return customerOrderModelList;
    }

    public void deliverOrder(int orderId) {
        CustomerOrder customerOrder=customerOrderRepo.getReferenceById(orderId);
        Customer customer=customerOrder.getCustomer();
        double price=customerOrder.getAmount();
        double balance=customer.getAccountBalance()-price;
        customer.setAccountBalance(balance);
        customerOrder.setOwnerApproved("DELIVERED");
        customerOrderRepo.save(customerOrder);
    }

    public void cancelOrder(int orderId) {
        CustomerOrder customerOrder=customerOrderRepo.getReferenceById(orderId);
        customerOrder.setOwnerApproved("CANCELLED");
        customerOrderRepo.save(customerOrder);
    }
}
