package com.example.Moviestars.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "movie_title")
    private String movieTitle;

    @Column(name = "movie_genre")
    private String movieGenre;

    @Column(name = "movie_description")
    private String movieDescription;

    @Column(name = "movie_trailer")
    private String movieTrailer;

    @Column(name = "movie_image")
    private String movieImage;

    @Column(name = "movie_rating")
    private double movieRating;

    @Column(name = "movie_is_rated")
    private boolean movieIsRated;


    //relations

    //Movie to Review relation
    @OneToMany(
            mappedBy = "movie",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JsonBackReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Review> reviews;

    //Movies to User relation
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonManagedReference
    private User user;


    //constructors
    public Movie() {
    }


    public Movie(String movieTitle, String movieGenre, String movieDescription, String movieTrailer, String movieImage, double movieRating, boolean movieIsRated, User user) {
        this.movieTitle = movieTitle;
        this.movieGenre = movieGenre;
        this.movieDescription = movieDescription;
        this.movieTrailer = movieTrailer;
        this.movieImage = movieImage;
        this.movieRating = movieRating;
        this.movieIsRated = movieIsRated;
        this.user=user;
    }



    //getters and setters
    public String getMovieDescription() {
        return movieDescription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public String getMovieTrailer() {
        return movieTrailer;
    }

    public void setMovieTrailer(String movieTrailer) {
        this.movieTrailer = movieTrailer;
    }

    public String getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(String movieImage) {
        this.movieImage = movieImage;
    }

    public double getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(double movieRating) {
        this.movieRating = movieRating;
    }

    public boolean isMovieIsRated() {
        return movieIsRated;
    }

    public void setMovieIsRated(boolean movieIsRated) {
        this.movieIsRated = movieIsRated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public List<Review>getReviews(){
        return reviews;
    }

    public void setReviews(List<Review> reviews){
        this.reviews=reviews;
    }

    //methods
    void addReview(Review review){
        this.reviews.add(review);
    }
}


