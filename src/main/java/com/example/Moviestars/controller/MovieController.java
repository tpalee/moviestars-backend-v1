package com.example.Moviestars.controller;
import com.example.Moviestars.model.Movie;
import com.example.Moviestars.model.Review;
import com.example.Moviestars.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> getMovies() {
            return ResponseEntity.ok().body(movieService.getMovies());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Movie>> getCustomer(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(movieService.getMovieById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createMovie(@RequestBody Movie movie) {
        long newId = movieService.createMovie(movie);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateMovie(@PathVariable("id") long id, @RequestBody Movie movie) {
        movieService.updateMovie(id, movie);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteMovie(@PathVariable("id") int id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping(value = "/{id}/reviews")
    public ResponseEntity getReviews(@PathVariable("id") int id) {
        Iterable<Review> movieReviews=movieService.getReviews(id);
        return ResponseEntity.ok(movieReviews);
    }








}
