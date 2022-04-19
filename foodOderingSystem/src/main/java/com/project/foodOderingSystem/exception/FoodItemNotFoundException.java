package com.project.foodOderingSystem.exception;

public class FoodItemNotFoundException extends RuntimeException {
    public FoodItemNotFoundException(String s) {
        super(s);
    }
}