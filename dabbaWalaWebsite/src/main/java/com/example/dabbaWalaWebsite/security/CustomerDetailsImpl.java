//package com.example.dabbaWalaWebsite.security;
//
//
//import com.example.dabbaWalaWebsite.entity.Customer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.Collections;
//
//public class CustomerDetailsImpl implements UserDetails {
//    @Autowired
//    private Customer customer;
//    public CustomerDetailsImpl(Customer customer){
//        this.customer=customer;
//    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singleton(new SimpleGrantedAuthority("CUSTOMER"));
//    }
//
//    @Override
//    public String getPassword() {
//        return customer.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return customer.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
