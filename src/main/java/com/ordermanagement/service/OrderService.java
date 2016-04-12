package com.ordermanagement.service;

import com.ordermanagement.repository.entity.Order;
import org.springframework.stereotype.Service;

/**
 * Created by Julian on 01.03.2016.
 */
public interface OrderService {

    Iterable<Order> getAllOrders();

    void saveOrder(Order order);

    void deleteOrder(Order order);

}
