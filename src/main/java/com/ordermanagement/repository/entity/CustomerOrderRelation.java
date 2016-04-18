package com.ordermanagement.repository.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Juergen on 18.04.2016.
 */
@Entity
@Table
public class CustomerOrderRelation implements Serializable {

    @EmbeddedId
    private CustomerOrderID customerOrderID;

    public CustomerOrderRelation() {
    }

    public CustomerOrderRelation(CustomerOrderID customerOrderID) {
        this.customerOrderID = customerOrderID;
    }

    public CustomerOrderID getCustomerOrderID() {
        return customerOrderID;
    }

    public void setCustomerOrderID(CustomerOrderID customerOrderID) {
        this.customerOrderID = customerOrderID;
    }
}
