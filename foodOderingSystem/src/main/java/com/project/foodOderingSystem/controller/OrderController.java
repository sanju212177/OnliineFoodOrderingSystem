package com.project.foodOderingSystem.controller;

import com.project.foodOderingSystem.dto.OrderDto;
import com.project.foodOderingSystem.entity.Order;
import com.project.foodOderingSystem.service.OrderService;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/addOrder")
    public ResponseEntity<String> createOrder(@RequestBody OrderDto orderDto) throws Exception{
    	orderDto.setStartTime(LocalDateTime.now());
    	  LocalDateTime dateTime = LocalDateTime.now().plus(Duration.of(30, ChronoUnit.MINUTES));
    	  orderDto.setEndTime(dateTime);
        orderDto.setStatus("pending");
        orderDto.setDate(LocalDate.now());
        orderService.addOrder(orderDto);
        
        RazorpayClient client=new RazorpayClient("rzp_test_syNtpIejUJ1PGG","U4QKAo055SMF81EsJsbUy8Mq");

        JSONObject ob =new JSONObject();
        ob.put("amount",orderDto.getAmount()*100);
        ob.put("currency","INR");
        ob.put("receipt","txn_452587");

        com.razorpay.Order od=client.Orders.create(ob);
        System.out.println(od);
        return new ResponseEntity<>(od.toString(),HttpStatus.OK);
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
    @GetMapping("/getByCustomerId/{customerId}")
    public ResponseEntity<List<Order>> getOrderByCustomerId(@PathVariable("customerId") int customerId){
        return new ResponseEntity<>(orderService.getOrderByCustomerId(customerId),HttpStatus.OK);
    }

}
