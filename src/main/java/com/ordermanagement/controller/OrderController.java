package com.ordermanagement.controller;

import com.ordermanagement.repository.entity.Customer;
import com.ordermanagement.repository.entity.Movie;
import com.ordermanagement.repository.entity.Order;
import com.ordermanagement.service.CustomerService;
import com.ordermanagement.service.MovieService;
import com.ordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Set;

/**
 * Created by Julian on 01.03.2016.
 */

@RestController
public class OrderController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private MovieService movieService;

    private int orderId = 1;

    @RequestMapping(method = RequestMethod.POST, value = "/cart")
    public int createOrder(@RequestBody Map<String, Object> payload, HttpServletResponse response) {
        int customerId = (int) payload.get("customerId");

        boolean customerExists = false;

        Order newOrder = null;

        for (Customer customer : customerService.getAllCustomers()) {
            if (customer.getCustomerId() == customerId) {
                newOrder = new Order(orderId++);
                customer.addOrder(newOrder);
                customerService.saveCustomer(customer);
                customerExists = true;
            }
        }

        if (customerExists) {
            response.setStatus(HttpStatus.OK.value());
            return newOrder.getOrderID();
        } else {
            response.setStatus(HttpStatus.NO_CONTENT.value());
        }

        return 0;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/cart")
    public void addMovie(@RequestBody Map<String, Object> payload, HttpServletResponse response) {
        int orderId = (int) payload.get("orderId");
        int movieId = (int) payload.get("movieId");

        boolean noContent = true;

        for (Customer customer : customerService.getAllCustomers()) {
            for (Order order : customer.getOrders()) {
                if (order.getOrderID() == orderId) {

                    order.setStatusFlagOpen();

                    for (Movie movie : movieService.getAllMovies()) {
                        if (movie.getMovieId() == movieId) {
                            order.addMovie(movie);
                            noContent = false;
                            response.setStatus(HttpStatus.OK.value());
                        }
                    }
                }
            }
        }

        if (noContent) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/cart")
    public void deleteMovie(@RequestBody Map<String, Object> payload, HttpServletResponse response) {
        int orderId = (int) payload.get("orderId");
        int movieId = (int) payload.get("movieId");


        response.setStatus(HttpStatus.OK.value());
        response.setStatus(HttpStatus.NO_CONTENT.value());
        response.setStatus(HttpStatus.NOT_FOUND.value());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cart")
    public Order readOrder(@RequestBody Map<String, Object> payload, HttpServletResponse response) {
        int orderId = (int) payload.get("orderId");

        response.setStatus(HttpStatus.OK.value());
        response.setStatus(HttpStatus.NO_CONTENT.value());
        response.setStatus(HttpStatus.NOT_FOUND.value());

        return null;
    }
}
