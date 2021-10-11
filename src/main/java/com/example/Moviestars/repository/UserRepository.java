package com.example.Moviestars.repository;

import com.example.Moviestars.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface UserRepository extends JpaRepository <User, String>{

    public Collection<User>findAllByUserName(String name);
}
