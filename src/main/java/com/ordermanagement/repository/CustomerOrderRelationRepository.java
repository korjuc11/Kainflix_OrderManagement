package com.ordermanagement.repository;

import com.ordermanagement.repository.entity.CustomerOrderRelation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Juergen on 18.04.2016.
 */
@Repository
public interface CustomerOrderRelationRepository extends CrudRepository<CustomerOrderRelation, Long> {
}