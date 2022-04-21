package com.project.foodOderingSystem.service;

import com.project.foodOderingSystem.dto.FoodItemsDto;
import com.project.foodOderingSystem.entity.FoodItems;
import com.project.foodOderingSystem.exception.FoodItemNotFoundException;
import com.project.foodOderingSystem.repository.FoodItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodItemsServiceImpl implements FoodItemsService{

    @Autowired
    FoodItemsRepository foodItemsRepository;

    @Override
    public void addFoodItem(FoodItemsDto foodItemsDto) {
        FoodItems foodItems=new FoodItems();
        foodItems.setFoodName(foodItemsDto.getFoodName());
        foodItems.setPrice(foodItemsDto.getPrice());
        foodItems.setQuantity(foodItemsDto.getQuantity());
        foodItems.setInfo(foodItemsDto.getInfo());
        foodItems.setImage(foodItemsDto.getImage());


        foodItemsRepository.save(foodItems);
    }

    @Override
    public List<FoodItems> getAllFoodItems() {
        List<FoodItems> foodList=new ArrayList<>();
        foodItemsRepository.findAll().forEach(foodList::add);
        return foodList;
    }

    @Override
    public void deleteFoodItem(int id) {
        foodItemsRepository.findById(id).orElseThrow(()->new FoodItemNotFoundException("Food Item with id="+id+" is not found"));
        foodItemsRepository.deleteById(id);
    }

    @Override
    public FoodItems updateFoodItem(FoodItemsDto foodItemsDto, int id) {
        FoodItems foodItems=foodItemsRepository.findById(id).orElseThrow(()->new FoodItemNotFoundException("Food Item with id="+id+" is not found"));
        foodItems.setFoodName(foodItemsDto.getFoodName());
        foodItems.setPrice(foodItemsDto.getPrice());
        foodItems.setQuantity(foodItemsDto.getQuantity());
        foodItems.setInfo(foodItemsDto.getInfo());
        foodItems.setImage(foodItemsDto.getImage());
        return foodItemsRepository.save(foodItems);

    }

    @Override
    public List<FoodItems> getFoodItemsByName(String name) {
        return foodItemsRepository.findByFoodName(name);
    }

    @Override
    public FoodItems getFoodItemById(int id) {
        FoodItems foodItems=foodItemsRepository.findById(id).orElseThrow(()->new FoodItemNotFoundException("Food Item with id="+id+" is not found"));

        return foodItems;
    }

	@Override
	public void updateQuantity(FoodItemsDto foodItemsDto, int id) {
        FoodItems foodItems=foodItemsRepository.findById(id).orElseThrow(()->new FoodItemNotFoundException("Food Item with id="+id+" is not found"));
        foodItems.setQuantity(foodItemsDto.getQuantity());
        
        foodItemsRepository.save(foodItems);
		
	}

	@Override
	public Integer getQuantity(int id) {
		FoodItems foodItems=foodItemsRepository.findById(id).orElseThrow(()->new FoodItemNotFoundException("Food Item with id="+id+" is not found"));
		return foodItems.getQuantity();
	}

}

