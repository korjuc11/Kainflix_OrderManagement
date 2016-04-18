package com.ordermanagement.repository.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Juergen on 18.04.2016.
 */
@Embeddable
public class CustomerOrderID implements Serializable{

    private long customerId;
    private long orderId;

    public CustomerOrderID() {
    }

    public CustomerOrderID(long customerId, long orderId) {
        this.customerId = customerId;
        this.orderId = orderId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
}
