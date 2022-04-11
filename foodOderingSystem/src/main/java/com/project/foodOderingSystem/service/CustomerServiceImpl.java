package com.project.foodOderingSystem.service;

import com.project.foodOderingSystem.dto.CustomerDto;
import com.project.foodOderingSystem.entity.Customer;
import com.project.foodOderingSystem.exception.CustomerNotFoundException;
import com.project.foodOderingSystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void createCustomer(CustomerDto customer) {

    }

    @Override
    public List<Customer> readCustomer() {
        List<Customer> customerList = new ArrayList<Customer>();
        customerRepository.findAll().forEach(customer -> customerList.add(customer));
        return customerList;
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.findById(customer.getCustomerId()).orElseThrow(()->new CustomerNotFoundException("Customer with ID "+customer.getCustomerId()+" not Found"));
     
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer with ID "+id+" not Found"));
        customerRepository.deleteById(id);

    }

    @Override
    public Customer getCustomerById(int customerId) {
        return customerRepository.findById(customerId).orElseThrow(()->new CustomerNotFoundException("Customer with ID "+customerId+" not Found"));
    }
}
