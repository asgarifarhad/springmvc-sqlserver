package com.asg.customer.service;

import com.asg.customer.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {
    List<Customer> getAllCustomers();

    void deleteCustomer(Customer customer);

    Optional<Customer> getCustomerById(long id);

    void saveCustomer(Customer customer);
}
