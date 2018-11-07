package com.mencner.moviedb.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "movie")
public class Movie implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(name = "director", nullable = false)
    private String director;

    protected Movie() {

    }

    public Movie(String name, int year, String genre, String director) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
