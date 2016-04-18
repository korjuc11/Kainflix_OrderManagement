package com.ordermanagement.service;

import com.ordermanagement.repository.entity.CustomerOrderRelation;
import com.ordermanagement.repository.entity.OrderMovieRelation;

/**
 * Created by Juergen on 18.04.2016.
 */
public interface OrderMovieRelationService {

    public OrderMovieRelation findById(long id);

    Iterable<OrderMovieRelation> getAllOrderMovieRelations();

    void saveOrderMovieRelation(OrderMovieRelation orderMovieRelation);

    void deleteOrderMovieRelation(OrderMovieRelation orderMovieRelation);
}
