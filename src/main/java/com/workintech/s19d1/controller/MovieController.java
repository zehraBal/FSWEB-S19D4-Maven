package com.workintech.s19d1.controller;

import com.workintech.s19d1.dto.MovieRequest;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/movie")
public class MovieController {

    private MovieService movieService;

    @GetMapping
    public List<Movie> getAll(){
        return movieService.findAll();
    }
    @GetMapping("/{id}")
    public Movie get(@PathVariable long id){
        return movieService.findById(id);
    }
    @PostMapping
    public Movie save(@RequestBody MovieRequest movieRequest){
        Movie movie=movieRequest.getMovie();
        List<Actor> actors=movieRequest.getActor();
        for(Actor actor:actors){
            movie.addActor(actor);
        }
        return movieService.save(movie);
    }
    @PutMapping("/{id}")
    public Movie update(@PathVariable long id,@RequestBody Movie movie){
        return movieService.update(id,movie);
    }
    @DeleteMapping("/{id}")
    public Movie delete(@PathVariable long id){
        Movie movie=movieService.findById(id);
        return movieService.delete(movie);
    }
}
