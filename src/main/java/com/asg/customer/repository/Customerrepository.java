package com.asg.customer.repository;

import com.asg.customer.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface Customerrepository extends JpaRepository<Customer,Long> {


}
