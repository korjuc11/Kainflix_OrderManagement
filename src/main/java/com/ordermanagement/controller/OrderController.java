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

    @RequestMapping(method = RequestMethod.POST, value="/cart")
    public int create(@RequestBody Map<String, Object> payload, HttpServletResponse response)
    {
        int customerId = (int) payload.get("customerId");

        //Customer c = new Customer();
        //customerService.saveCustomer(c);

        boolean customerExists = false;

        Order newOrder = null;

        for(Customer customer : customerService.getAllCustomers())
        {
            if(customer.getCustomerId() == customerId)
            {
                int maxId = 1;
                for(Order order : customer.getOrders())
                {
                    if(order.getId() > maxId)
                    {
                        maxId = order.getId()+1;
                    }
                }
                newOrder = new Order(maxId);
                customer.addOrder(newOrder);
                customerService.saveCustomer(customer);
                customerExists = true;
            }
        }

        if(customerExists)
        {
            response.setStatus(HttpStatus.OK.value());
            return newOrder.getId();
        }
        else
        {
            response.setStatus(HttpStatus.NO_CONTENT.value());
        }

        return 0;
    }

    @RequestMapping(method=RequestMethod.PUT, value="/cart")
    public void add(@RequestBody Map<String, Object> payload, HttpServletResponse response) {
        int orderId = (int) payload.get("orderId");
        int movieId = (int) payload.get("movieId");

        response.setStatus(HttpStatus.OK.value());
        response.setStatus(HttpStatus.NO_CONTENT.value());
        /*for (Order order : orderService.getAllOrders()) {
            if (order.getId() == orderId) {

                Set<Movie> moviesSet = order.getMovies();
                Movie movie = new Movie();
                movie.setMovieId(movieId);
                movie.setDescription("");
                moviesSet.add(movie);

            }

            else{
                order = new Order();
                Set<Movie> movies = order.getMovies();
                Movie movie = new Movie();
                movie.setMovieId(movieId);
                movies.add(movie);
            }
        }*/
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/cart")
    public void delete(@RequestBody Map<String, Object> payload, HttpServletResponse response)
    {
        int orderId = (int) payload.get("orderId");
        int movieId = (int) payload.get("movieId");

        response.setStatus(HttpStatus.OK.value());
        response.setStatus(HttpStatus.NO_CONTENT.value());
        response.setStatus(HttpStatus.NOT_FOUND.value());
    }

    @RequestMapping(method=RequestMethod.GET, value="/cart")
    public Order read(@RequestBody Map<String, Object> payload, HttpServletResponse response)
    {
        int orderId = (int) payload.get("orderId");

        response.setStatus(HttpStatus.OK.value());
        response.setStatus(HttpStatus.NO_CONTENT.value());
        response.setStatus(HttpStatus.NOT_FOUND.value());

        return null;
    }
}
