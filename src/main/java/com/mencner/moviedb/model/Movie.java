package com.mencner.moviedb.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "movie")
public class Movie implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = NAME, nullable = false)
    private String name;

    @Column(name = YEAR, nullable = false)
    private int year;

    @Column(name = GENRE, nullable = false)
    private String genre;

    @Column(name = DIRECTOR, nullable = false)
    private String director;

    @Column(name = EVALUATION, nullable = false)
    private float evaluation;

    public static final String NAME = "name";
    public static final String YEAR = "year";
    public static final String DIRECTOR = "director";
    public static final String EVALUATION = "evaluation";
    private static final String GENRE = "genre";

    protected Movie() {

    }

    public Movie(String name, int year, String genre, String director, float evaluation) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.director = director;
        this.evaluation = evaluation;
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

    public float getEvaluation() {
        return this.evaluation;
    }

    public void setEvaluation(float evaluation) {
        this.evaluation = evaluation;
    }
}
