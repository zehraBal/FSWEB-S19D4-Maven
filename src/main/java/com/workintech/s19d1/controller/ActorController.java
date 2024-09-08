package com.workintech.s19d1.controller;

import com.workintech.s19d1.dto.ActorRequest;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.exceptions.ApiException;
import com.workintech.s19d1.service.ActorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/actor")
public class ActorController {

    private ActorService actorService;

    @GetMapping
    public List<Actor> getAll(){
        return actorService.findAll();
    }

    @GetMapping("/{id}")
    public Actor get(@PathVariable long id){
        return actorService.findById(id);
    }

    @PostMapping
    public Actor save(@RequestBody ActorRequest actorRequest){
        Actor actor =actorRequest.getActor();
        List<Movie> movies=actorRequest.getMovies();
        for(Movie movie:movies){
            actor.addMovie(movie);
        }
        return actorService.save(actor);
    }

    @PutMapping("/{id}")
    public Actor update(@RequestBody Actor actor,@PathVariable long id){
        return actorService.update(id,actor);
    }

    @DeleteMapping("/{id}")
    public Actor delete(@PathVariable long id){
        Actor actor=actorService.findById(id);
        if(actor==null){
            throw new ApiException("There is not an actor with given id", HttpStatus.BAD_REQUEST);
        }
        return actorService.delete(actor);
    }
}
