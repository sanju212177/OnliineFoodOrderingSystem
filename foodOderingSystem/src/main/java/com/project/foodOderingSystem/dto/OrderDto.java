package com.project.foodOderingSystem.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(amount, customerId, date, endTime, startTime, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDto other = (OrderDto) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& customerId == other.customerId && Objects.equals(date, other.date)
				&& Objects.equals(endTime, other.endTime) && Objects.equals(startTime, other.startTime)
				&& Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "OrderDto [status=" + status + ", date=" + date + ", amount=" + amount + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", customerId=" + customerId + "]";
	}

    
}