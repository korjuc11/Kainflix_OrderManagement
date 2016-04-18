package com.ordermanagement.service;

import com.ordermanagement.repository.CustomerOrderRelationRepository;
import com.ordermanagement.repository.entity.Customer;
import com.ordermanagement.repository.entity.CustomerOrderRelation;

/**
 * Created by Juergen on 18.04.2016.
 */
public interface CustomerOrderRelationService {

    public CustomerOrderRelation findById(long id);

    Iterable<CustomerOrderRelation> getAllCustomerOrderRelations();

    void saveCustomerOrderRelation(CustomerOrderRelation customerOrderRelation);

    void deleteCustomerOrderRelation(CustomerOrderRelation customerOrderRelation);
}
