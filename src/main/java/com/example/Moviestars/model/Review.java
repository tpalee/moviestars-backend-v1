package com.example.Moviestars.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="review")
    private String review;

    @Column(name="rating")
    private double rating;



 @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "movie_id", nullable = false)
    @JsonManagedReference
    private Movie movie;



    public Review(String review, double rating) {
        this.review = review;
        this.rating = rating;
    }

    public Review(String review, double rating, Movie movie) {

        this.review = review;
        this.rating = rating;
        this.movie = movie;
    }

    public Review() {
    }

    //getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }


    public Movie getMovie() { return movie; }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}



