package com.ordermanagement.controller;

import com.ordermanagement.repository.entity.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Julian on 01.03.2016.
 */

@RestController
public class OrderController {

    @RequestMapping(method = RequestMethod.POST, value="/cart")
    public int create(@RequestBody int customerId, HttpServletResponse response)
    {
        int orderId = 0;

        response.setStatus(HttpStatus.OK.value());
        //response.setStatus(HttpStatus.NO_CONTENT.value());

        return orderId;
    }

    @RequestMapping(method=RequestMethod.PUT, value="/cart")
    public void add(@RequestBody int orderId, @RequestBody int movieId, HttpServletResponse response)
    {
        response.setStatus(HttpStatus.OK.value());
        response.setStatus(HttpStatus.NO_CONTENT.value());
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/cart")
    public void delete(@RequestBody int orderId, @RequestBody int movieId, HttpServletResponse response)
    {
        response.setStatus(HttpStatus.OK.value());
        response.setStatus(HttpStatus.NO_CONTENT.value());
        response.setStatus(HttpStatus.NOT_FOUND.value());
    }

    @RequestMapping(method=RequestMethod.GET, value="/cart")
    public Order read(@RequestBody int orderId, HttpServletResponse response)
    {
        response.setStatus(HttpStatus.OK.value());
        response.setStatus(HttpStatus.NO_CONTENT.value());
        response.setStatus(HttpStatus.NOT_FOUND.value());

        return null;
    }
}
