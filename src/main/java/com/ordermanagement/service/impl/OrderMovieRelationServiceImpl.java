package com.ordermanagement.service.impl;

import com.ordermanagement.repository.OrderMovieRelationRepository;
import com.ordermanagement.repository.entity.OrderMovieRelation;
import com.ordermanagement.service.OrderMovieRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Juergen on 18.04.2016.
 */
@Service
public class OrderMovieRelationServiceImpl implements OrderMovieRelationService {

    @Autowired
    private OrderMovieRelationRepository orderMovieRelationRepository;

    @Override
    public OrderMovieRelation findById(long id) {
        return orderMovieRelationRepository.findOne(id);
    }

    @Override
    public Iterable<OrderMovieRelation> getAllOrderMovieRelations() {
        return orderMovieRelationRepository.findAll();
    }

    @Override
    public void saveOrderMovieRelation(OrderMovieRelation orderMovieRelation) {
        orderMovieRelationRepository.save(orderMovieRelation);
    }

    @Override
    public void deleteOrderMovieRelation(OrderMovieRelation orderMovieRelation) {
        orderMovieRelationRepository.delete(orderMovieRelation);
    }
}
