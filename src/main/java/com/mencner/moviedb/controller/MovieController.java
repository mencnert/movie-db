package com.mencner.moviedb.controller;

import com.mencner.moviedb.exception.MovieNotFoundException;
import com.mencner.moviedb.model.Movie;
import com.mencner.moviedb.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    private final String NOT_FOUND = "Movie not found.";

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/movie/{movieId}")
    public Movie getMovieById(@PathVariable long movieId) throws Exception {
        return movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException(NOT_FOUND));
    }

    @GetMapping("/movie")
    public List<Movie> getMovieByName(@RequestParam("name") String name) {
        return movieRepository.findByNameContaining(name);
    }

    @PostMapping("/movie")
    public Movie createMovie(@Valid @RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @PutMapping("/movie/{movieId}")
    public Movie updateMovie(@PathVariable long movieId,
                             @Valid @RequestBody Movie updatedMovie) {
        return movieRepository.findById(movieId)
                .map(dbMovie -> {
                    dbMovie.setName(updatedMovie.getName());
                    dbMovie.setYear(updatedMovie.getYear());
                    dbMovie.setGenre(updatedMovie.getGenre());
                    dbMovie.setDirector(updatedMovie.getDirector());
                    return movieRepository.save(dbMovie);
                }).orElseThrow(() -> new MovieNotFoundException(NOT_FOUND));
    }

    @DeleteMapping("/movie/{movieId}")
    public ResponseEntity<?> deleteMovie(@PathVariable long movieId) {
        return movieRepository.findById(movieId)
                .map(movie -> {
                    movieRepository.delete(movie);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new MovieNotFoundException(NOT_FOUND));
    }
}
