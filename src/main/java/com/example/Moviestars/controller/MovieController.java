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

    //search movies
    @GetMapping(value = "")
    public ResponseEntity<Object>searchMovies(@RequestParam(name="title", defaultValue="") String name){
            return ResponseEntity.ok().body(movieService.getMovies(name));
    }

    //get movie by Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(movieService.getMovieById(id));
    }

    // get rating of the movie
    @GetMapping(value = "/{id}/rating")
    public ResponseEntity<Double> getAverage(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(movieService.getAverageRating(id));
    }

    //create a new movie
    @PostMapping(value = "")
    public ResponseEntity<Object> createMovie(@RequestBody Movie movie) {
        long newId = movieService.createMovie(movie);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    //update an existing movie
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateMovie(@PathVariable("id") long id, @RequestBody Movie movie) {
        movieService.updateMovie(id, movie);
        return ResponseEntity.noContent().build();
    }

    //delete movie
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteMovie(@PathVariable("id") int id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

    //get all reviews of a movie
    @GetMapping(value = "/{id}/reviews")
    public ResponseEntity getReviews(@PathVariable("id") int id) {
        Iterable<Review> movieReviews=movieService.getReviews(id);
        return ResponseEntity.ok(movieReviews);
    }
}
