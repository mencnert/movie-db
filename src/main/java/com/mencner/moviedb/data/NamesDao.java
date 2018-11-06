package com.mencner.moviedb.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NamesDao extends CrudRepository<Name, Integer> {
    List<Name> findAll();
}
