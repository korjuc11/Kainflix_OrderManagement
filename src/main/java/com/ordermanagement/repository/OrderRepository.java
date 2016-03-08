package com.ordermanagement.repository;

import com.ordermanagement.repository.entity.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Julian on 01.03.2016.
 */
public interface OrderRepository extends CrudRepository<Order, Long> {
}
