package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.exceptions.ApiException;
import com.workintech.s19d1.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MovieServiceImpl implements MovieService{

    private MovieRepository movieRepository;


    @Override
    public Movie save(Movie movie) {
       return movieRepository.save(movie);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(long id) {
        return movieRepository.findById(id).orElseThrow(()-> new ApiException("Movie is not found with id: "+id, HttpStatus.NOT_FOUND));
    }

    @Override
    public Movie update(long id, Movie movie) {
        Movie oldMovie=findById(id);
        oldMovie.setActors(movie.getActors());
        oldMovie.setRating(movie.getRating());
        oldMovie.setDirectorName(movie.getDirectorName());
        oldMovie.setReleaseDate(movie.getReleaseDate());
        oldMovie.setName(movie.getName());
        movieRepository.save(oldMovie);
        return oldMovie;
    }

    @Override
    public Movie delete(Movie movie) {
       movieRepository.delete(movie);
        return movie;
    }
}
