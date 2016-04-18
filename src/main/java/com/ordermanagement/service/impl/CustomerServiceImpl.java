package com.ordermanagement.service.impl;

import java.util.Iterator;
import java.util.List;

import com.ordermanagement.repository.CustomerRepository;
import com.ordermanagement.repository.entity.Customer;
import com.ordermanagement.service.CustomerService;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Julian on 05.04.2016.
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findById(long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }
}