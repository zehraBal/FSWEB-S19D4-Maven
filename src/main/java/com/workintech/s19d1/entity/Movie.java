package com.workintech.s19d1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "movie",schema="public")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="director_name")
    private String directorName;

    @Column(name="rating")
    private double rating;

    @Column(name="release_date")
    private LocalDate releaseDate;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name="actor",schema = "public",joinColumns = @JoinColumn(name = "movie_id"),inverseJoinColumns = @JoinColumn(name="actor_id"))
    private List<Actor> actors=new ArrayList<>();

    public void addActor(Actor actor){
        actors.add(actor);
    }
}
