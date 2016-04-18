package com.ordermanagement.repository.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Julian on 05.04.2016.
 */
@Entity
@Table
public class Movie implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column
    private int movieId;

    @Column
    private String description;

    //@ManyToMany(mappedBy = "movies")
    /*private Set<Order> orders;

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders)
    {
        this.orders = orders;
    }*/

    public Movie() {
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
