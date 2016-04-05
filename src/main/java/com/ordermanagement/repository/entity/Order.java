package com.ordermanagement.repository.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Julian on 01.03.2016.
 */
@Entity
@Table
public class Order implements Serializable {

    @Id
    @Column
    private int customerId;


    @Id
    @Column
    private int orderID;


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
}
