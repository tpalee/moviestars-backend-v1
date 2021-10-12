package com.example.Moviestars.repository;

import com.example.Moviestars.model.Favourite;
import com.example.Moviestars.model.FavouriteKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, FavouriteKey> {



}
