package com.ordermanagement.controller;

import com.ordermanagement.repository.entity.*;
import com.ordermanagement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
    private CustomerOrderRelationService customerOrderRelationService;

    @Autowired
    private OrderMovieRelationService orderMovieRelationService;

    @Autowired
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.POST, value = "/cart")
    public long createOrder(@RequestBody Map<String, Object> payload, HttpServletResponse response) {
        try {
            int customerId = (int) payload.get("customerId");

            OrderNew newOrder = null;

            Customer customer = customerService.findById(customerId);
            newOrder = new OrderNew();
            orderService.saveOrder(newOrder);
            customerService.save(customer);
            customerOrderRelationService.saveCustomerOrderRelation(new CustomerOrderRelation(new CustomerOrderID(customerId, newOrder.getOrderID())));

            response.setStatus(HttpStatus.OK.value());
            return newOrder.getOrderID();
        } catch (Exception ex) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
            return 0;
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/cart")
    public void addMovie(@RequestBody Map<String, Object> payload, HttpServletResponse response) {
        int orderId;
        int movieId;
        try {
            orderId = (int) payload.get("orderId");
            movieId = (int) payload.get("movieId");

            boolean orderFound = false;

            for (CustomerOrderRelation customerOrderRelation : customerOrderRelationService.getAllCustomerOrderRelations()) {
                if (customerOrderRelation.getCustomerOrderID().getOrderId() == orderId) {
                    OrderNew order = orderService.findById(customerOrderRelation.getCustomerOrderID().getOrderId());
                    order.setStatusFlagOpen();
                    // ??? Film von Product Management bekommen ???
                    Movie movie = new Movie(movieId, "newMovie");
                    movieService.saveMovie(movie);
                    orderMovieRelationService.saveOrderMovieRelation(new OrderMovieRelation(new OrderMovieID(order.getOrderID(), movie.getMovieId())));
                    orderFound = true;
                    response.setStatus(HttpStatus.OK.value());
                }
            }

            if (!orderFound) {
                response.setStatus(HttpStatus.NOT_FOUND.value());
            }

        } catch (Exception ex) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/cart")
    public void deleteMovie(@RequestBody Map<String, Object> payload, HttpServletResponse response) {
        int orderId;
        int movieId;
        try {
            orderId = (int) payload.get("orderId");
            movieId = (int) payload.get("movieId");

            boolean notFound = true;

            for (OrderMovieRelation orderMovieRelation : orderMovieRelationService.getAllOrderMovieRelations()) {
                if (orderMovieRelation.getOrderMovieID().getOrderId() == orderId && orderMovieRelation.getOrderMovieID().getMovieId() == movieId) {
                    orderMovieRelationService.deleteOrderMovieRelation(orderMovieRelation);
                    movieService.deleteMovie(movieService.findById(movieId));
                    notFound = false;
                    response.setStatus(HttpStatus.OK.value());
                }
            }

            if (notFound) {
                response.setStatus(HttpStatus.NOT_FOUND.value());
            }
        } catch (Exception ex) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cart")
    @ResponseBody
    public List<Object> readOrder(@RequestParam int orderId, HttpServletResponse response) {
        try {
            if (orderService.findById(orderId) == null) {
                response.setStatus(HttpStatus.NOT_FOUND.value());
                return null;
            } else {
                OrderNew currentOrder = orderService.findById(orderId);
                response.setStatus(HttpStatus.OK.value());
                LinkedList<Object> objects = new LinkedList<>();
                for (CustomerOrderRelation customerOrderRelation : customerOrderRelationService.getAllCustomerOrderRelations()) {
                    if (customerOrderRelation.getCustomerOrderID().getOrderId() == orderId) {
                        objects.add(customerOrderRelation.getCustomerOrderID().getCustomerId());
                    }
                }
                for (OrderMovieRelation orderMovieRelation : orderMovieRelationService.getAllOrderMovieRelations()) {
                    if (orderMovieRelation.getOrderMovieID().getOrderId() == orderId) {
                        objects.add(movieService.findById(orderMovieRelation.getOrderMovieID().getMovieId()));
                    }
                }
                objects.add(currentOrder.getStatusFlag());
                return objects;
            }
        } catch (Exception ex) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
            return null;
        }
    }

    public double calculateTotalPrice(OrderNew order)
    {
        double sum = 0.0;

        for(OrderMovieRelation orderMovieRelation : orderMovieRelationService.getAllOrderMovieRelations())
        {
            if(orderMovieRelation.getOrderMovieID().getOrderId() == order.getOrderID())
            {
                sum += movieService.findById(orderMovieRelation.getOrderMovieID().getMovieId()).getPrice();
            }
        }

        return sum;
    }

    public void setStatusFlagToFinish(OrderNew order)
    {
        OrderNew orderNew = orderService.findById(order.getOrderID());
        orderNew.setStatusFlagFinished();
        orderService.saveOrder(orderNew);
    }
}
