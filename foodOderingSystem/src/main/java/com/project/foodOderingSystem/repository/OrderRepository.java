package com.project.foodOderingSystem.repository;

import com.project.foodOderingSystem.entity.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
	
	@Query(value = "SELECT * FROM customer_orders WHERE customer_id = :customerId",nativeQuery = true)
    List<Order> findByCustomerId(@Param("customerId") int customerId);
}
