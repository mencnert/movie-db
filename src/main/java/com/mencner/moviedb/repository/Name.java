package com.mencner.moviedb.repository;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "NAMES")
public class Name implements Serializable {

    @Id
    @Column(name="id")
    private Long id;

    @Column(name = "name")
    private String name;

    protected Name() {

    }

    public Name(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
