 package com.project.foodOderingSystem.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.foodOderingSystem.dto.FoodItemsDto;
import com.project.foodOderingSystem.entity.FoodItems;
import com.project.foodOderingSystem.service.FoodItemsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping
public class FoodItemsController {

    @Autowired
    private FoodItemsService foodItemsService;
    
    @Autowired
    public ImageUploadHelper imageUploadHelper;
    
     
    
    @PostMapping("/items/addItem")
    public ResponseEntity<String> addFoodItem(@RequestParam("foodItemsDto") String jsonStringFoodDto , @RequestParam("file") MultipartFile  file)throws IOException {
//        foodItemsDto.setImage(file.getBytes());
//        foodItemsService.addFoodItem(foodItemsDto);
//        return new ResponseEntity<>("Food Item added.", HttpStatus.CREATED);
//    	FoodItemsDto foodItemDto = (FoodItemsDto)foodItemsDto; 
    	
    	try {
    		if(file.isEmpty()) {
    			return new ResponseEntity<String>("File is empty!!!",HttpStatus.INTERNAL_SERVER_ERROR);
    		}
    		if(imageUploadHelper.uploadFile(file)) {
    			
    			FoodItemsDto foodItemDto = new ObjectMapper().readValue(jsonStringFoodDto, FoodItemsDto.class);
    			foodItemDto.setImage(file.getOriginalFilename());
    			foodItemsService.addFoodItem(foodItemDto);
    		    return  new  ResponseEntity<>("Item successfully added",HttpStatus.OK );
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
		}
    	

    	
    	
    	return new ResponseEntity<>("Something went wrong!!",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/items/imageDisplay/{id}")
    public String showImage(@RequestParam("id") Integer id) throws ServletException, IOException {
        FoodItems foodItems= foodItemsService.getFoodItemById(id);
		return ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(foodItems.getImage()).toUriString();
    }

    @GetMapping("/public_items/getAllItems")
    public ResponseEntity<List<FoodItems>> getAllFoodItems(){
    return new ResponseEntity<>(foodItemsService.getAllFoodItems(),HttpStatus.ACCEPTED);
    }
    @GetMapping("/items/getQuantity/{id}")
    public ResponseEntity<Integer> getQuantity(@PathVariable("id") int id){
    	return new ResponseEntity<>(foodItemsService.getQuantity(id),HttpStatus.OK);
    }

    @DeleteMapping("/items/deleteFoodItem/{id}")
    public ResponseEntity<String> deleteFoodItem(@PathVariable("id") int id){
        foodItemsService.deleteFoodItem(id);
        return new ResponseEntity<>("Item Deleted.",HttpStatus.OK);
    }

    @PutMapping("/items/update/food/item/{id}")
    public ResponseEntity<String> updateFoodItem(@RequestBody FoodItemsDto foodItemsDto, @PathVariable("id") int id){
        foodItemsService.updateFoodItem(foodItemsDto,id);
        return new ResponseEntity<>("Item Updated.",HttpStatus.ACCEPTED);
    }
    @PatchMapping("/items/updateQuantity/{id}")
    public ResponseEntity<String> updateQuantity(@RequestBody FoodItemsDto foodItemsDto, @PathVariable("id") int id){
    	System.out.println(foodItemsDto);
    	foodItemsService.updateQuantity(foodItemsDto,id);
    	return new ResponseEntity<>("Item Updated.",HttpStatus.ACCEPTED);
    }

    @GetMapping("/items/get/byName/{name}")
    public ResponseEntity<List<FoodItems>> getFoodItemsByName(@PathVariable("name") String name){
        return new ResponseEntity<>(foodItemsService.getFoodItemsByName(name),HttpStatus.OK);
    }
}
