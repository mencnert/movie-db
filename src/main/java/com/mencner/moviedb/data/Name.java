package com.mencner.moviedb.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "NAMES")
public class Name implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private int id;

    @Column(nullable = false, name = "name")
    private String name;

    public Name() {

    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
