package com.ordermanagement.service;

import com.ordermanagement.repository.entity.Movie;
import org.springframework.stereotype.Service;

/**
 * Created by Julian on 05.04.2016.
 */
public interface MovieService {

    public Movie findById(long id);
    Iterable<Movie> getAllMovies();
    void saveMovie(Movie movie);
    void deleteMovie(Movie movie);
}
