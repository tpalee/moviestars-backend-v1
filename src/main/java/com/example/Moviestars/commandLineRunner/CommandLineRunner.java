package com.example.Moviestars.commandLineRunner;

import com.example.Moviestars.controller.MovieController;
import com.example.Moviestars.model.Movie;
import com.example.Moviestars.model.Review;
import com.example.Moviestars.repository.MovieRepository;
import com.example.Moviestars.repository.ReviewRepository;
import com.example.Moviestars.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ReviewRepository reviewRepository;


    @Override
    public void run(String... args) throws Exception {


        Movie movie1=new Movie("Terminator", "action", "Arnold shoots all the bad-guys and malfunctions sometimes", "http://trailer.com", "image", 6.3, true);
        movieRepository.save(movie1);
        Movie movie2=new Movie("Hollowman", "action", "nothing to see", "http://trailer.com", "image", 8.0, true);
        movieRepository.save(movie2);
        Movie movie3=new Movie("Hollowman3", "action", "nothing to see again", "http://trailer.com", "image", 8.0, false);
        movieRepository.save(movie3);


        Review review1=new Review("This movie sucks!!", 3.2);
        review1.setMovie(movie1);
        reviewRepository.save(review1);

        Review review2=new Review("nice movie", 6.0, movie1);
        reviewRepository.save(review2);






    }
}
