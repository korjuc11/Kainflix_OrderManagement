package com.ordermanagement.repository.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Juergen on 18.04.2016.
 */
@Embeddable
public class OrderMovieID implements Serializable {

    private long orderId;
    private long movieId;

    public OrderMovieID() {
    }

    public OrderMovieID(long orderId, long movieId) {
        this.orderId = orderId;
        this.movieId = movieId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }
}