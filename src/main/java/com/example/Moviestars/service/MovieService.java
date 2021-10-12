package com.example.Moviestars.service;


import com.example.Moviestars.exception.RecordNotFoundException;
import com.example.Moviestars.model.Movie;
import com.example.Moviestars.model.Review;
import com.example.Moviestars.repository.MovieRepository;
import com.example.Moviestars.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;

    //constructor
    @Autowired
    public MovieService(MovieRepository movieRepository, ReviewRepository reviewRepository) {
        this.movieRepository = movieRepository;
        this.reviewRepository = reviewRepository;
    }



    //searchMovies
    public Collection<Movie> getMovies(String name)
    {
        if (name.isEmpty()) {
            return movieRepository.findAll();
        }
        else {
            return movieRepository.findAllByMovieTitle(name);
        }


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



    //Get all the reviews of the movie_Id
    public Iterable<Review> getReviews(long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            return movie.get().getReviews();
        } else {
            throw new RecordNotFoundException();
        }
    }

    //get the average rating of the movie
    public double getAverageRating(long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            //list of review of the movie
            List <Review> reviews = movie.get().getReviews();
            //rating of movie from movieDataBaseApi else 0
            double apiRatingValue=movie.get().getMovieRating();
            //list to add all the ratings
            List<Double> ratings=new ArrayList<>();
            //total of ratings
            double sum=0;
                sum+=apiRatingValue;
                ratings.add(apiRatingValue);
            //loop over reviewslist and add each rating to the ratingslist
            for (int i = 0; i < reviews.size(); i++) {
                double number=(reviews.get(i).getRating());
                ratings.add(number);
                sum+=number;
            }
            //divide sum of reviews
            return sum/ratings.size();

        } else {
            throw new RecordNotFoundException();
        }
    }
}