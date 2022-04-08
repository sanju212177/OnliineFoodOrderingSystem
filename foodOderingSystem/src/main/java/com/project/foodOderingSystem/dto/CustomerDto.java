package com.project.foodOderingSystem.dto;

import com.project.foodOderingSystem.entity.Address;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter
@Setter
public class CustomerDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;
    @NotBlank(message = "First name cannot be blank")
    @Size(min=3,message= "First name should have atleast 3 characters")
    @Pattern(regexp = "^[A-Za-z]+$", message = "First name should contain only alphabets")
    private String customerName;
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Enter a valid email address")
    private String CustomerEmail;
    @NotNull(message = "Phone number cannot be blank")
    @NotBlank(message = "Phone number cannot be blank")
    @Size(min=10,max=10,message = "Phone number should have 10 digits")
    @Pattern(regexp = "^[0-9]+$", message = "Phone number should contain only digits")
    private String phoneNumber;
    @Valid
    @NotNull(message = "Address cannot be blank")
    private Address address;

    public CustomerDto(){

    }

}
