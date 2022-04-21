package com.project.foodOderingSystem.service;

import com.project.foodOderingSystem.dto.FoodItemsDto;
import com.project.foodOderingSystem.entity.FoodItems;

import java.util.List;

public interface FoodItemsService {
    public void addFoodItem(FoodItemsDto foodItemsDto);
    public List<FoodItems> getAllFoodItems();
    public void deleteFoodItem(int id);
    public FoodItems updateFoodItem(FoodItemsDto foodItemsDto, int id);
    public List<FoodItems> getFoodItemsByName(String name);
    public FoodItems getFoodItemById(int id);
	public void updateQuantity(FoodItemsDto foodItemsDto, int id);
	public Integer getQuantity(int id);
}