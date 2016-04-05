package com.ordermanagement.repository;

import com.ordermanagement.repository.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Julian on 05.04.2016.
 */
@Repository
public interface MovieRepository extends CrudRepository<Movie,Long>{
}
