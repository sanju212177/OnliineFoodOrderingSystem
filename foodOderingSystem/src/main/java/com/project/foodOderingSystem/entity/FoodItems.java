package com.project.foodOderingSystem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "food_items")
public class FoodItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int foodId;

    private String foodName;

    //private String imageUrl;

    private double price;

    private int quantity;

    private String info;

    private String image;

    public FoodItems(int foodId, String foodName, double price, int quantity, String info, String image) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.price = price;
        this.quantity = quantity;
        this.info = info;
        this.image = image;
    }
    
    
    public FoodItems() {
	}

	public int getFoodId() {
		return foodId;
	}


	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}


	public String getFoodName() {
		return foodName;
	}


	public void setFoodName(String foodName) {
		this.foodName = foodName;
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


	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String string) {
		this.image = string;
	}


	@Override
	public int hashCode() {
		return Objects.hash(foodId, foodName, image, info, price, quantity);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FoodItems other = (FoodItems) obj;
		return foodId == other.foodId && Objects.equals(foodName, other.foodName) && Objects.equals(image, other.image)
				&& Objects.equals(info, other.info)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && quantity == other.quantity;
	}


	@Override
	public String toString() {
		return "FoodItems [foodId=" + foodId + ", foodName=" + foodName + ", price=" + price + ", quantity=" + quantity
				+ ", info=" + info + ", image=" + image + "]";
	}

    
	
}
