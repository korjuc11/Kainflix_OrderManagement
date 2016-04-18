package com.ordermanagement.service;

import com.ordermanagement.repository.entity.Customer;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Julian on 05.04.2016.
 */

public interface CustomerService {

    public Customer findById(long id);

    public Iterable<Customer> findAll();

    public void save(Customer customer);

    public void delete(Customer customer);

}