package com.ordermanagement.repository.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Julian on 05.04.2016.
 */
@Entity
@Table
public class Product implements Serializable {

    @Id
    @GeneratedValue
    @Column
    private int productId;

    @Column
    private String description;


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
