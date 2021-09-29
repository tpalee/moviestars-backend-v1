package com.example.Moviestars.repository;
import com.example.Moviestars.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;



public interface ReviewRepository extends JpaRepository<Review, Long> {


}
