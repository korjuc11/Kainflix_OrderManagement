package com.ordermanagement.repository.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by Julian on 05.04.2016.
 */
@Entity
@Table
public class Customer implements Serializable {

    @Id
    @Column
    @GeneratedValue
    private int customerId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    private LinkedList<Order> orders;

    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addOrder(Order order)
    {
        orders.add(order);
    }
}
