package com.ordermanagement.service.impl;

import com.ordermanagement.repository.CustomerOrderRelationRepository;
import com.ordermanagement.repository.entity.CustomerOrderRelation;
import com.ordermanagement.service.CustomerOrderRelationService;
import com.ordermanagement.service.CustomerService;
import com.ordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Juergen on 18.04.2016.
 */
@Service
public class CustomerOrderRelationServiceImpl implements CustomerOrderRelationService {

    @Autowired
    private CustomerOrderRelationRepository customerOrderRelationRepository;

    @Override
    public CustomerOrderRelation findById(long id) {
        return customerOrderRelationRepository.findOne(id);
    }

    @Override
    public Iterable<CustomerOrderRelation> getAllCustomerOrderRelations() {
        return customerOrderRelationRepository.findAll();
    }

    @Override
    public void saveCustomerOrderRelation(CustomerOrderRelation customerOrderRelation) {
        customerOrderRelationRepository.save(customerOrderRelation);
    }

    @Override
    public void deleteCustomerOrderRelation(CustomerOrderRelation customerOrderRelation) {
        customerOrderRelationRepository.delete(customerOrderRelation);
    }
}
