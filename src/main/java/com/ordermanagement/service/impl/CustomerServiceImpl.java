package com.ordermanagement.service.impl;

import com.ordermanagement.repository.CustomerRepository;
import com.ordermanagement.repository.entity.Customer;
import com.ordermanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Julian on 05.04.2016.
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }
}
