package com.ordermanagement.repository;

import com.ordermanagement.repository.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Julian on 01.03.2016.
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
