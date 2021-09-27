package com.example.Moviestars.service;

import com.example.Moviestars.exception.RecordNotFoundException;
import com.example.Moviestars.model.Review;
import com.example.Moviestars.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;

    //constructor
    @Autowired
    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository=reviewRepository;
    }


    
    //get all the reviews
    public Iterable<Review> getReviews() {
        return reviewRepository.findAll();
    }


    public Review findById(long nr) {
        Optional<Review> review = reviewRepository.findById(nr);
        if (review.isPresent()) {
            return review.get();
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    public void save(Review review) {
        reviewRepository.save(review);
    }

    public void deleteById(long nr) {
        try {
            reviewRepository.deleteById(nr);
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println(ex);
            throw new RecordNotFoundException();
        }
    }



}
