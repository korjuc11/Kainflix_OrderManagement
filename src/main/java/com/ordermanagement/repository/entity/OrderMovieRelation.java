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
public class OrderMovieRelation implements Serializable {

    @EmbeddedId
    private OrderMovieID orderMovieID;

    public OrderMovieRelation() {
    }

    public OrderMovieRelation(OrderMovieID orderMovieID) {
        this.orderMovieID = orderMovieID;
    }

    public OrderMovieID getOrderMovieID() {
        return orderMovieID;
    }

    public void setOrderMovieID(OrderMovieID orderMovieID) {
        this.orderMovieID = orderMovieID;
    }
}

