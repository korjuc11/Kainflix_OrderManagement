package com.ordermanagement.repository.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Julian on 18.04.2016.
 */
@Entity
@Table
public class Rating implements Serializable {

    @Id
    @Column
    private long ratingId;

    public Rating(long ratingId) {
        this.ratingId = ratingId;
    }

    public long getRatingId() {
        return ratingId;
    }

    public void setRatingId(long ratingId) {
        this.ratingId = ratingId;
    }
}
