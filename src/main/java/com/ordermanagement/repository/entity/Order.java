package com.ordermanagement.repository.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Julian on 01.03.2016.
 */
@Entity
@Table
public class Order implements Serializable {

    @Id
    @Column
    private int orderID;

    @Column
    private String description;

    private LinkedList<Movie> movies;

    @Column
    private String statusFlag;

    @Column
    private float totalPrice;

    //@ManyToMany(mappedBy="movies")
    /*private Set<Movie> movies;


    public Set<Movie> getMovies()
    {
        return movies;
    }

    public void setMovies(Set<Movie> movies)
    {
        this.movies = movies;
    }*/

    public Order() {
        movies = new LinkedList<>();
    }

    public Order(int orderID) {
        movies = new LinkedList<>();
        this.orderID = orderID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LinkedList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(LinkedList<Movie> movies) {
        this.movies = movies;
    }

    public String getStatusFlag() {
        return statusFlag;
    }

    public void setStatusFlag(String statusFlag) {
        this.statusFlag = statusFlag;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public boolean removeMovie(Movie movie) {
        if (movies.contains(movie)) {
            movies.remove(movie);
            return true;
        }
        return false;
    }

    public void setStatusFlagOpen() {
        statusFlag = "open";
    }

    public void setStatusFlagFinished() {
        statusFlag = "finished";
    }

    public float getTotalPrice() {
        float sum=0;
        for(Movie movie:getMovies())
        {
            sum+=movie.getPrice();
        }
        return sum;
    }


}