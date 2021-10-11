package com.example.Moviestars.controller;


import com.example.Moviestars.model.Movie;
import com.example.Moviestars.model.User;
import com.example.Moviestars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;


    //get all users
    @GetMapping(value = "")
    public ResponseEntity<Object> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }


    //get one user
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }


    //create a new user
    @PostMapping(value = "")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        String newId = userService.createUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    //update an existing user
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable("id") String id, @RequestBody User user) {
        userService.updateUser(id, user);
        return ResponseEntity.noContent().build();
    }

    //delete a user
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


    //get added movies of the user
    @GetMapping(value = "/{id}/movies")
    public ResponseEntity getMovies(@PathVariable("id") String id) {
        Iterable<Movie> movies=userService.getMovies(id);
        return ResponseEntity.ok(movies);
    }

}
