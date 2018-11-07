package com.mencner.moviedb.repository;

import com.mencner.moviedb.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
    List<Movie> findAll();
    Optional<Movie> findById(Long id);
    List<Movie> findByNameContaining(String subName);
}
