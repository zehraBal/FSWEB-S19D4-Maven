package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Movie;

import java.util.List;

public interface MovieService {
    Movie save(Movie movie);
    List<Movie> findAll();
    Movie findById(long id);
    Movie update(long id,Movie movie);
    Movie delete(Movie movie);
}
