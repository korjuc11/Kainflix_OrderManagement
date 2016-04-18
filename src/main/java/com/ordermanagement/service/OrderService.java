package com.ordermanagement.service;

import com.ordermanagement.repository.entity.OrderMovieRelation;
import com.ordermanagement.repository.entity.OrderNew;

/**
 * Created by Julian on 01.03.2016.
 */
public interface OrderService {

    public OrderNew findById(long id);

    Iterable<OrderNew> getAllOrders();

    void saveOrder(OrderNew orderNew);

    void deleteOrder(OrderNew orderNew);

}
