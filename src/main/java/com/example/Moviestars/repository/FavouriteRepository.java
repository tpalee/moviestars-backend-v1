package com.example.Moviestars.repository;

import com.example.Moviestars.model.Favourite;
import com.example.Moviestars.model.FavouriteKey;
import com.example.Moviestars.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, FavouriteKey> {
    public List<Favourite> findAllByMovie(Movie movie);
}
