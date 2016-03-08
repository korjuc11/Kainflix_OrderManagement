package com.ordermanagement.service.impl;

import com.ordermanagement.repository.OrderRepository;
import com.ordermanagement.repository.entity.Order;
import com.ordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Julian on 01.03.2016.
 */

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository oderRepository;

    @Override
    public Iterable<Order> getAllOrders() {
        return oderRepository.findAll();
    }

    @Override
    public void saveOrder(Order order) {
        oderRepository.save(order);
    }

    @Override
    public void deleteOrder(Order order) { oderRepository.delete(order);}
}
