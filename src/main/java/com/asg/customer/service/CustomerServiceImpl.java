package com.asg.customer.service;

import com.asg.customer.entity.Customer;
import com.asg.customer.repository.Customerrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private Customerrepository customerrepository;

    @Override
    public List<Customer> getAllCustomers() {
            return customerrepository.findAll();
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerrepository.delete(customer);
    }

    @Override
    public Optional<Customer> getCustomerById(long id) {

        return customerrepository.findById(id);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerrepository.save(customer);
    }
}
