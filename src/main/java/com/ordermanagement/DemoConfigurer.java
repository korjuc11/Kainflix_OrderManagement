package com.ordermanagement;

import com.ordermanagement.repository.CustomerRepository;
import com.ordermanagement.repository.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Julian on 01.03.2016.
 */
@Component
public class DemoConfigurer {

    @Autowired
    private CustomerRepository customerRepository;

    @PostConstruct
    public void createDemoData() {
        Customer customer1 = new Customer();
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customerRepository.save(customer2);
    }
}
