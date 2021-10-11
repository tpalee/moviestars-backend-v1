package com.example.Moviestars.repository;

import com.example.Moviestars.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootTest
public class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;

    @Test

    //goede naamconventie
    public void findAllByMovieTitleTest(){
        Collection<Movie> movies=new ArrayList<>();
    movies=movieRepository.findAllByMovieTitle("Terminator");
        System.out.println(movies.toArray()[0]);
    }


}
