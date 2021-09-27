package com.example.Moviestars.repository;


import com.example.Moviestars.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    public Collection<Movie> findAllByMovieTitle(String name);
}
