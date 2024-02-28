package com.example.mappingProject.entity;

import com.example.mappingProject.models.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @NotBlank(message = "username should not be blank")
    private String username;
    @NotNull(message = "password should not be null")
    private String password;
    @Size(min=5, message = "firstName should be atleast 5 characters")
    private String firstName;
    @Size(min=4, message = "lastName should be atleast 4 characters")
    private String lastName;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<PlayList> playLists=new ArrayList<>();

    @Embedded
    private Address address;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }
}
