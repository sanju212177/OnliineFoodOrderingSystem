package com.project.foodOderingSystem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class FoodItemsDto implements Serializable {

    @NotBlank(message = "Food name cannot be blank")
    @Size(min=3,message= "First name should have atleast 3 characters")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Food name should contain only alphabets")
    private String foodName;

    private String image;

    @NotBlank(message = "Info cannot be blank")
    private String info;

    @DecimalMax("10000.0") @DecimalMin("0.0")
//    @NotNull(message = "price must be in between 0.0-10000.0")
    private double price;

    @Max(value = 1000,message = "please enter less then equal to 1000")
//    @NotNull(message = "quantity cannot be null")
    private int quantity;

    public FoodItemsDto(String foodName, String image, String info, double price, int quantity) {
        this.foodName = foodName;
        this.image = image;
        this.info = info;
        this.price = price;
        this.quantity = quantity;
    }
    
     public FoodItemsDto(){
    	
    }
    
    public String getFoodName() {
		return foodName;
	}



	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public String getInfo() {
		return info;
	}



	public void setInfo(String info) {
		this.info = info;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(foodName, image, info, price, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FoodItemsDto other = (FoodItemsDto) obj;
		return Objects.equals(foodName, other.foodName) && Objects.equals(image, other.image)
				&& Objects.equals(info, other.info)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && quantity == other.quantity;
	}

	@Override
	public String toString() {
		return "FoodItemsDto [foodName=" + foodName + ", image=" + image + ", info=" + info + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}

    
}
