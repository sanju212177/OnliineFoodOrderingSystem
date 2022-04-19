package com.project.foodOderingSystem.repository;

import com.project.foodOderingSystem.entity.FoodItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemsRepository extends JpaRepository<FoodItems,Integer> {

    @Query(value ="select * from food_items f where f.food_name =food_name",nativeQuery = true)
    List<FoodItems> findByFoodName(@Param("name") String name);
}
