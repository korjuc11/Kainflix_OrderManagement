package com.ordermanagement.repository.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Julian on 01.03.2016.
 */
@Entity
@Table
public class OrderNew implements Serializable {

    @Id
    @Column
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long orderID;

    @Column
    private String description;

    @Column
    private String statusFlag;

    public OrderNew() {
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderId){this.orderID = orderId;}
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatusFlag() {
        return statusFlag;
    }

    public void setStatusFlag(String statusFlag) {
        this.statusFlag = statusFlag;
    }

    public void setStatusFlagOpen() {
        statusFlag = "open";
    }

    public void setStatusFlagFinished() {
        statusFlag = "finished";
    }
}