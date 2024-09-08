package com.workintech.s19d1.controller;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.service.ActorService;
import lombok.AllArgsConstructor;
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
    public Actor save(@RequestBody Actor actor){
        return actorService.save(actor);
    }

    @PutMapping("/{id}")
    public Actor update(@PathVariable long id,@RequestBody Actor actor){
        return actorService.update(id,actor);
    }

    @DeleteMapping("/{id}")
    public Actor delete(@PathVariable long id){
        Actor actor=actorService.findById(id);
        return actorService.delete(actor);
    }
}
