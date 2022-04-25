package com.project.foodOderingSystem.service;

import com.project.foodOderingSystem.dto.OrderDto;
import com.project.foodOderingSystem.entity.Order;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


public interface OrderService {
    public void addOrder(OrderDto orderDto);
    public List<Order> getAllOrders();
    public Order getOrderById(int id);
    public Order updateOrder(OrderDto orderDto,int id);
    public void cancelOrder(int id);
    public List<Order> getOrderByCustomerId(int customerId);
    //acceptOrder
    //cancelOrder
}
