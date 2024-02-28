package com.example.mappingProject.models;

import com.example.mappingProject.entity.PlayList;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private int userId;
    @NotBlank(message = "username should not be blank")
    private String username;
    @NotNull(message = "password should not be null")
    private String password;

//    @NotBlank(message = "First Name must not be empty")
//    @Size(min = 5, message = "First Name must be at least 5 characters")
    private String firstName;

//    @NotBlank(message = "Last Name must not be empty")
//    @Size(min = 4, message = "Last Name should be at least 4 characters")
    private String lastName;

    private List<PlayList> playLists=new ArrayList<>();

    @Embedded
    private Address address;

    public UserModel(String username, String password, String firstName, String lastName, Address address) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }
}
