package com.mencner.moviedb.controller;

import com.mencner.moviedb.exception.MovieNotFoundException;
import com.mencner.moviedb.model.Movie;
import com.mencner.moviedb.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    private final String NOT_FOUND = "Movie not found.";

    @GetMapping("/movie")
    public List<Movie> getMovieByName(@RequestParam("name") String name) {
        return movieRepository.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("/movie/{movieId}")
    public Movie getMovieById(@PathVariable long movieId) {
        return movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException(NOT_FOUND));
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
                    dbMovie.setEvaluation(updatedMovie.getEvaluation());
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

    @GetMapping("/movie/feed")
    public List<Movie> feedDB() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Vykoupení z věznice Shawshank", 1994, "Drama, Krimi", "Frank Darabont", 9.5f));
        movies.add(new Movie("Pán prstenů: Společenstvo Prstenu", 2001, "Fantasy, Dobrodružný, Akční", "Peter Jackson", 9.0f));
        movies.add(new Movie("Pán prstenů: Návrat krále", 2003, "Fantasy, Dobrodružný, Akční", "Peter Jackson", 9.0f));
        movies.add(new Movie("The Dark Knight", 2008, "Akční, Drama, Krimi, Thriller", "Christopher Nolan", 9.0f));
        movies.add(new Movie("Gladiátor", 2000, "Akční, Dobrodružný, Drama", "Ridley Scott", 8.8f));
        movies.add(new Movie("The Terminator", 1984, "Akční, Sci-Fi, Thriller", "James Cameron", 8.7f));
        movies.add(new Movie("Vynález zkázy", 1958, "Dobrodružný, Fantasy, Sci-Fi", "Karel Zeman", 8.6f));
        movies.add(new Movie("Home Alone", 1990, "Rodinný, Komedie", "Chris Columbus", 8.6f));
        movies.add(new Movie("X-Men: První třída", 2011, "Akční, Dobrodružný, Sci-Fi, Thriller", "Matthew Vaughn", 8.5f));
        movies.add(new Movie("Whiplash", 2014, "Drama, Hudební", "Damien Chazelle", 8.5f));

//        movies.add(new Movie());
//        movies.add(new Movie());
//        movies.add(new Movie());
//        movies.add(new Movie());
//        movies.add(new Movie());
//        movies.add(new Movie());
//        movies.add(new Movie());
//        movies.add(new Movie());
//        movies.add(new Movie());
//        movies.add(new Movie());

        for (Movie m : movies) {
            movieRepository.save(m);
        }

        return movieRepository.findAll();
    }
}
