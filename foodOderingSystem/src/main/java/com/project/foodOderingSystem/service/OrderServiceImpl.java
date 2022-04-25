package com.project.foodOderingSystem.service;

import com.project.foodOderingSystem.dto.OrderDto;
import com.project.foodOderingSystem.entity.FoodItems;
import com.project.foodOderingSystem.entity.Order;
import com.project.foodOderingSystem.exception.OrderNotFoundException;
import com.project.foodOderingSystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl  implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void addOrder(OrderDto orderDto) {
        Order order=new Order();
        order.setCustomerId(orderDto.getCustomerId());
        order.setStartTime(orderDto.getStartTime());
        order.setEndTime(orderDto.getEndTime());
        order.setStatus(orderDto.getStatus());
        order.setAmount(orderDto.getAmount());
        order.setDate(orderDto.getDate());

        orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {

        return new ArrayList<>(orderRepository.findAll());
    }

    @Override
    public Order getOrderById(int id) {
        Order order;
        order = orderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("Order with this id="+id+" is not found"));

        return order;
    }

    @Override
    public Order updateOrder(OrderDto orderDto, int id) {
        Order order;
        order = orderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("Order with this id="+id+" is not found"));
        if(orderDto.getCustomerId() != 0)
        order.setCustomerId(orderDto.getCustomerId());
       
        if(orderDto.getStartTime()!=null)
        order.setStartTime(orderDto.getStartTime());
      
        if(orderDto.getEndTime()!=null)
        order.setEndTime(orderDto.getEndTime());
     
        
        if(orderDto.getStatus()!=null)	
        order.setStatus(orderDto.getStatus());
        
    
        if(orderDto.getAmount()!= 0.0)
        order.setAmount(orderDto.getAmount());
        
        if(orderDto.getDate()!=null)
        order.setDate(orderDto.getDate());


        return orderRepository.save(order);

    }
    
    @Override
    public List<Order> getOrderByCustomerId(int customerId) {
        List <Order> orderList=orderRepository.findByCustomerId(customerId);
        return orderList;
    }

    @Override
    public void cancelOrder(int id) {
        Order order=orderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("Order with this id="+id+" is not found"));
        orderRepository.deleteById(id);

    }
}

