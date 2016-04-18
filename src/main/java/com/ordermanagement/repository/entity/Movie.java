package com.ordermanagement.repository.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.security.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Julian on 05.04.2016.
 */
@Entity
@Table
public class Movie implements Serializable {

    @Id
    @Column
    private long movieId;

    @Column
    private String name;

    @Column
    private Date releaseDate;

    @Column
    private int duration;

    @Column
    private Rating rating;

    @Column
    private float price;

    public Movie() {
    }

    public Movie(int movieId, String description) {
        this.movieId = movieId;
        this.name = description;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleasedate() {
        return releaseDate;
    }

    public void setReleasedate(Date releasedate) {
        this.releaseDate = releasedate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
