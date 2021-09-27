package com.example.Moviestars.controller;

import com.example.Moviestars.model.Review;
import com.example.Moviestars.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping(value = "/reviews")
    public ResponseEntity getReviews() {
        Iterable<Review> reviews;
        reviews = reviewService.getReviews();
        return ResponseEntity.ok(reviews);
    }

    @GetMapping(value = "/reviews/{id}")
    public ResponseEntity getSpeler(@PathVariable long id) {
        Review review = reviewService.findById(id);
        return ResponseEntity.ok(review);
    }

    @PostMapping(value = "/reviews")
    public ResponseEntity addReview(@RequestBody Review review) {
        reviewService.save(review);
        return ResponseEntity.ok("Toegevoegd");
    }

    @DeleteMapping(value = "/reviews/{id}")
    public ResponseEntity deleteReview(@PathVariable long id) {
        reviewService.deleteById(id);
        return ResponseEntity.ok("Verwijderd");
    }

    @PutMapping(value = "/reviews/{id}")
    public ResponseEntity updateReview(@PathVariable long nr, @RequestBody Review review) {
        return ResponseEntity.ok("Aangepast");
    }








}
