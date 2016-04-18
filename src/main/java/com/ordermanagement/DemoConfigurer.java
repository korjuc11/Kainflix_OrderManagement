package com.ordermanagement;

import com.ordermanagement.repository.CustomerRepository;
import com.ordermanagement.repository.entity.Customer;
import com.ordermanagement.repository.entity.Movie;
import com.ordermanagement.service.CustomerService;
import com.ordermanagement.service.MovieService;
import com.ordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Julian on 01.03.2016.
 */
@Component
public class DemoConfigurer {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private MovieService movieService;

    @PostConstruct
    public void createDemoData() {
        Customer customer1 = new Customer();
        customerService.saveCustomer(customer1);

        Customer customer2 = new Customer();
        customerService.saveCustomer(customer2);

        Movie movie1 = new Movie();
        movieService.saveMovie(movie1);

    }
}
