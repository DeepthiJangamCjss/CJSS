package com.example.dabbaWalaWebsite.models;

import com.example.dabbaWalaWebsite.entity.Restaurant;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LocationModel {
    private int locationId;
    private String street;
    @NotNull(message = "city should not be null")
    @NotBlank(message = "city should not be blank")
    private String city;
    @NotNull(message = "state should not be null")
    @NotBlank(message = "state should not be blank")
    private String state;
    private List<Restaurant> restaurantList=new ArrayList<>();

    @Override
    public String toString() {
        return "LocationModel{" +
                "locationId=" + locationId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
