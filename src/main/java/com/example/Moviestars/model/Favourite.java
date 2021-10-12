package com.example.Moviestars.model;

import javax.persistence.*;

@Entity
public class Favourite {

    @EmbeddedId
    FavouriteKey Id;


    @ManyToOne
    @MapsId("userName")
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "movie_id")
    Movie movie;


    public Favourite(FavouriteKey id, User user, Movie movie) {
        Id = id;
        this.user = user;
        this.movie = movie;
    }

    public Favourite() {
    }


    public FavouriteKey getId() {
        return Id;
    }

    public void setId(FavouriteKey id) {
        Id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
