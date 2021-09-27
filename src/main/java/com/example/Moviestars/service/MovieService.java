package com.example.Moviestars.service;


import com.example.Moviestars.exception.RecordNotFoundException;
import com.example.Moviestars.model.Movie;
import com.example.Moviestars.model.Review;
import com.example.Moviestars.repository.MovieRepository;
import com.example.Moviestars.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class MovieService{

    private MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;

    //constructor
    @Autowired
    public MovieService(MovieRepository movieRepository, ReviewRepository reviewRepository){
        this.movieRepository=movieRepository;
        this.reviewRepository = reviewRepository;
    }

    //get all the movies
    public Collection<Movie> getMovies() {
        return movieRepository.findAll();
    }


    //find all movies by title
    public Collection<Movie> getMoviesByMovieTitle(String name) {
        return movieRepository.findAllByMovieTitle(name);
    }

    //create a new movie
    public long createMovie(Movie movie) {
        Movie newMovie = movieRepository.save(movie);
        return newMovie.getId();
    }

    //update an existing movie
    public void updateMovie(long id, Movie newMovie) {
        if (!movieRepository.existsById(id)) throw new RecordNotFoundException();
        Movie movie = movieRepository.findById(id).get();
        movie.setMovieTitle(newMovie.getMovieTitle());
        movie.setMovieGenre(newMovie.getMovieGenre());
        movie.setMovieDescription(newMovie.getMovieDescription());
        movie.setMovieTrailer(newMovie.getMovieTrailer());
        movie.setMovieImage(newMovie.getMovieImage());
        movieRepository.save(movie);
    }

    //delete a movie by id
    public void deleteMovie(long id) {
        if (!movieRepository.existsById(id)) throw new RecordNotFoundException();
        movieRepository.deleteById(id);
    }

    //find a movie by id
    public Optional<Movie> getMovieById(long id) {
        if (!movieRepository.existsById(id)) throw new RecordNotFoundException();
        return movieRepository.findById(id);
    }




    public boolean MoviesExistsById(long id) {
        return false;
    }


    public Iterable<Review> getReviews(long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            return movie.get().getReviews();
        }
        else {
            throw new RecordNotFoundException();
        }


    }
}
