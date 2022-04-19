package com.project.foodOderingSystem.controller;

import com.project.foodOderingSystem.dto.OrderDto;
import com.project.foodOderingSystem.entity.Order;
import com.project.foodOderingSystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/addOrder")
    public ResponseEntity<String> createOrder(@RequestBody OrderDto orderDto){
        orderService.addOrder(orderDto);
        return new ResponseEntity<String>("Order added.", HttpStatus.CREATED);
    }

    @GetMapping("/getAllOrder")
    public ResponseEntity<List<Order>> getAllOrders(){
        return new ResponseEntity<>(orderService.getAllOrders(),HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") int id){
        return  new ResponseEntity<>(orderService.getOrderById(id),HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateOrder(@RequestBody OrderDto orderDto, @PathVariable("id") int id){
        orderService.updateOrder(orderDto,id);

        return new ResponseEntity<>("updated successfully",HttpStatus.ACCEPTED);
    }

}
