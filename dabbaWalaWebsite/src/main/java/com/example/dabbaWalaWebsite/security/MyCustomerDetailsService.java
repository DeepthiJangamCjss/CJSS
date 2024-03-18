//package com.example.dabbaWalaWebsite.security;
//
//import com.example.dabbaWalaWebsite.entity.Customer;
//import com.example.dabbaWalaWebsite.repository.CustomerRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MyCustomerDetailsService implements UserDetailsService {
//    @Autowired
//    private CustomerRepo customerRepo;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Customer customer=customerRepo.findByUsername(username);
//        if(customer==null){
//            throw new UsernameNotFoundException("customer username not found");
//        }
//        return new CustomerDetailsImpl(customer);
//    }
//}
