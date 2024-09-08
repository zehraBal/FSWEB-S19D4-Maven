package com.workintech.s19d1.dto;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class MovieRequest {
    private Movie movie;
    private List<Actor> actor;
}
