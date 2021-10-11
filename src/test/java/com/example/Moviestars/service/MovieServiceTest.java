package com.example.Moviestars.service;

import com.example.Moviestars.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

@SpringBootTest
public class MovieServiceTest {

    @Autowired
    MovieService movieService;

    @Test
    public void testfindAllbyTitle(){
        Collection<Movie>movies=movieService.getMovies("Terminator");
        System.out.println(movies.toArray()[0]);
    }

}
