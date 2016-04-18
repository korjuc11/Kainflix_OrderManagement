package com.ordermanagement;

import com.ordermanagement.repository.CustomerRepository;
import com.ordermanagement.repository.entity.*;
import com.ordermanagement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

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
    private CustomerOrderRelationService customerOrderRelationService;

    @Autowired
    private OrderMovieRelationService orderMovieRelationService;

    @Autowired
    private MovieService movieService;

    @PostConstruct
    public void createDemoData() {
        Customer customer1 = new Customer();
        customerService.save(customer1);

        OrderNew order1 = new OrderNew();
        orderService.saveOrder(order1);

        CustomerOrderRelation cor = new CustomerOrderRelation(new CustomerOrderID(customer1.getCustomerId(), order1.getOrderID()));
        customerOrderRelationService.saveCustomerOrderRelation(cor);

        Customer customer2 = new Customer();
        customerService.save(customer2);

        Movie movie1 = new Movie();
        movie1.setName("Avengers");
        movie1.setPrice(12.0f);
        movie1.setDuration(124);
        movie1.setReleasedate(new Date(2013,06,02));
        movieService.saveMovie(movie1);

        OrderMovieRelation omr = new OrderMovieRelation(new OrderMovieID(order1.getOrderID(), movie1.getMovieId()));
        orderMovieRelationService.saveOrderMovieRelation(omr);

    }
}
