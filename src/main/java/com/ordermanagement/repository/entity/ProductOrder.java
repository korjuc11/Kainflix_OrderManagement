package com.ordermanagement.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Julian on 08.03.2016.
 */
@Entity
@Table
public class ProductOrder implements Serializable {

    @Id
    @Column
    private int orderID;

    @Id
    @Column
    private int productID;


    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
}
