package com.ordermanagement.controller;

import com.ordermanagement.repository.entity.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.HttpMethodConstraint;

/**
 * Created by Julian on 01.03.2016.
 */

@RestController
public class OrderController {

    @RequestMapping("/")
    public ModelAndView index(ModelAndView model)
    {
        model.setViewName("index");
        return model;
    }


    @RequestMapping(method = RequestMethod.POST, value="/cart")
    public ModelAndView create(@RequestBody int customerid)
    {
        return null;
    }

    @RequestMapping(method=RequestMethod.PUT, value="/cart")
    public void add(ModelAndView model)
    {

    }

    @RequestMapping(method=RequestMethod.DELETE, value="/cart")
    public void add(@RequestBody int orderId, @RequestBody int movieId)
    {

    }

    @RequestMapping(method=RequestMethod.GET, value="/cart")
    public Order add(@RequestBody int orderId)
    {
        return null;
    }
}
