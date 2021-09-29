package com.example.Moviestars.controller;

import com.example.Moviestars.model.Review;
import com.example.Moviestars.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService)
    {
        this.reviewService = reviewService;
    }

    @GetMapping(value = "/reviews")
    public ResponseEntity <Object>getReviews() {
        return ResponseEntity.ok().body(reviewService.getReviews());
    }

    @GetMapping(value = "/reviews/{id}")
    public ResponseEntity getReview(@PathVariable long id) {
        return ResponseEntity.ok().body(reviewService.findById(id));
    }

    @PostMapping(value = "/reviews")
    public ResponseEntity<Object> createReview(@RequestBody Review review) {
        long newId=reviewService.createReview(review);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();
        return ResponseEntity.created(location).build();
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
