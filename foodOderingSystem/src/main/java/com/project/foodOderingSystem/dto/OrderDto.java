package com.project.foodOderingSystem.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.project.foodOderingSystem.entity.Customer;
import com.project.foodOderingSystem.entity.FoodItems;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {

    private String status;

    private LocalDate date;

    private double amount;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
    
    private List<Integer> foodItemIdList;
    
    private int customerId;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public List<Integer> getFoodItemIdList() {
		return foodItemIdList;
	}

	public void setFoodItemIdList(List<Integer> foodItemIdList) {
		this.foodItemIdList = foodItemIdList;
	}
    
    
}