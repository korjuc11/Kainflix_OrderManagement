package com.ordermanagement.service;

import com.ordermanagement.repository.entity.Customer;
import org.springframework.stereotype.Service;

/**
 * Created by Julian on 05.04.2016.
 */

public interface CustomerService {

    Iterable<Customer> getAllCustomers();

    void saveCustomer(Customer customer);

    void deleteCustomer(Customer customer);

}
