package com.ordermanagement.repository.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by Julian on 05.04.2016.
 */
@Entity
@Table
public class Movie implements Serializable {

    @Id
    @GeneratedValue
    @Column
    private int movieId;

    @Column
    private String description;

    private LinkedList<Order> orders;

    public Movie() {
    }

    public int setProductId() {
        return movieId;
    }

    public void setMovieId(int productId) {
        this.movieId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
