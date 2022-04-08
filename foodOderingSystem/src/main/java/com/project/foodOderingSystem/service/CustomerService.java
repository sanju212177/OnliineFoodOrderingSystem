package com.project.foodOderingSystem.service;

import com.project.foodOderingSystem.dto.CustomerDto;
import com.project.foodOderingSystem.entity.Customer;
import java.util.List;

public interface CustomerService {
    void createCustomer(CustomerDto customer);

    List<Customer> readCustomer();

    void updateCustomer(Customer customer);

    void deleteCustomer(int customerId);

    Customer getCustomerById(int customerId);

}
