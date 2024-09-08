package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.exceptions.ApiException;
import com.workintech.s19d1.repository.ActorRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class ActorServiceImpl implements ActorService{

    private ActorRepository actorRepository;

    @Override
    public Actor save(Actor actor) {
       return actorRepository.save(actor);
    }

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor update(long id, Actor actor) {
        Actor oldActor=findById(id);
        if (oldActor == null) {
            throw new ApiException("Actor not found with id: " + id,HttpStatus.NOT_FOUND);
        }

        oldActor.setMovies(actor.getMovies());
//        oldActor.setFirstName(actor.getFirstName());
//        oldActor.setLastName(actor.getLastName());
//        oldActor.setBirthDate(actor.getBirthDate());
//        oldActor.setGender(actor.getGender());
        actorRepository.save(oldActor);
        return oldActor;

    }

    @Override
    public Actor findById(long id) {
        return actorRepository.findById(id).orElseThrow(()-> new ApiException("actor is not found with id: "+id, HttpStatus.NOT_FOUND));
    }

    @Override
    public Actor delete(Actor actor) {
      actorRepository.delete(actor);
      return actor;
    }
}
