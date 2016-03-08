package com.ordermanagement.repository.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Julian on 01.03.2016.
 */
@Entity
@Table
public class Order implements Serializable {

    @GeneratedValue
    @Id
    @Column
    private int orderID;

    @Column
    private String description;



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

}
