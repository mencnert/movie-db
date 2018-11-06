package com.mencner.moviedb.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NamesDao extends CrudRepository<Name, Long> {
    List<Name> findAll();
}
