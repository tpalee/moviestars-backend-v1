package com.example.Moviestars.commandLineRunner;
import com.example.Moviestars.model.*;
import com.example.Moviestars.repository.FavouriteRepository;
import com.example.Moviestars.repository.MovieRepository;
import com.example.Moviestars.repository.ReviewRepository;

import com.example.Moviestars.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FavouriteRepository favouriteRepository;

    @Override
    public void run(String... args) throws Exception {


        User user1=new User("Harrie","Zult", "harriezult@gmail.com");
        User user2=new User("Peter","Loefen", "frietjemet@gmail.com");
        userRepository.save(user1);
        userRepository.save(user2);



        Movie movie1=new Movie("Terminator", "action", "Arnold shoots all the bad-guys and malfunctions sometimes", "http://trailer.com", "image",6.5, true, user1);
        movieRepository.save(movie1);
        Movie movie2=new Movie("Hollowman", "action", "nothing to see", "http://trailer.com", "image",5.6, true,user1);
        movieRepository.save(movie2);
/*        Movie movie3=new Movie("Hollowman3", "action", "nothing to see again", "http://trailer.com", "image",3.2, false,user2);
        movieRepository.save(movie3);
        Movie movie4=new Movie("Sound of Music", "musical", "woman in clothes made of curtains singing", "http://trailer.com", "image",0, false,user2);
        movie4.setMovieRating(8.6);
        movieRepository.save(movie4);*/

        Review review1=new Review("This movie sucks!!", 3.2,movie1);
        reviewRepository.save(review1);

        Review review2=new Review("nice movie", 6.0, movie1);
        reviewRepository.save(review2);


        Favourite favourite = new Favourite();
        FavouriteKey favouriteKey = new FavouriteKey();
        favouriteKey.setUserName(user1.getUserName());
        favouriteKey.setId(movie1.getId());


        favourite.setUser(user2);
        favourite.setMovie(movie1);
        favourite.setId(favouriteKey);
        favouriteRepository.save(favourite);

        //Test remove movie

        List<Favourite> favourites = favouriteRepository.findAllByMovie(movie1);
        favouriteRepository.deleteAll(favourites);
        movieRepository.delete(movie1);




    }
}
