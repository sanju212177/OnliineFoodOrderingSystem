package com.project.foodOderingSystem.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AddressDto {
    @NotBlank(message = "Street can't be empty")
    @NotNull(message = "Street can't be empty")
    private String street;
    @NotBlank(message = "City can't be empty")
    @NotNull(message = "City can't be empty")
    private String city;
    public String getStreet(){
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public AddressDto() {
    }
  
}