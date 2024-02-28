package com.example.mappingProject.models;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@Component
public class AdminModel {
    String username;
    String password;
    AdminModel(){
        username="Deepthi";
        password="Deepthi";
    }

    @Override
    public String toString() {
        return "AdminModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
