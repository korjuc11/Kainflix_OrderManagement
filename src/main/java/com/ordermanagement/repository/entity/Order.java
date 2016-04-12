package com.ordermanagement.repository.entity;

import org.hibernate.jpa.internal.schemagen.JpaSchemaGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by Julian on 01.03.2016.
 */
@Entity
@Table
public class Order implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column
    private int orderID;

    @Column
    private String description;

    public Order() {
    }

    private Customer customer;

    public int getId()
    {
        return this.orderID;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setId(int id)
    {
        this.orderID =id;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}