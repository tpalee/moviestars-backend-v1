package com.example.Moviestars.repository;
import com.example.Moviestars.model.Movie;
import com.example.Moviestars.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByMovie(Movie movie);

}
