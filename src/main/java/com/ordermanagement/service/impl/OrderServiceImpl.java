package com.ordermanagement.service.impl;

import com.ordermanagement.repository.OrderRepository;
import com.ordermanagement.repository.entity.OrderNew;
import com.ordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Julian on 01.03.2016.
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderNew findById(long id) {
        return orderRepository.findOne(id);
    }

    @Override
    public Iterable<OrderNew> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void saveOrder(OrderNew orderNew) {
        orderRepository.save(orderNew);
    }

    @Override
    public void deleteOrder(OrderNew orderNew) {
        orderRepository.delete(orderNew);
    }
}
























