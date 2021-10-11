package com.example.Moviestars.service;

import com.example.Moviestars.exception.IdAlreadyExistException;
import com.example.Moviestars.exception.RecordNotFoundException;
import com.example.Moviestars.model.Movie;
import com.example.Moviestars.model.Review;
import com.example.Moviestars.model.User;
import com.example.Moviestars.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;



    @Service
    public class UserService {

        private UserRepository userRepository;


        //constructor
        @Autowired
        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }


        //getAllUsers
        public Collection<User> getUsers() {
            return userRepository.findAll();
        }


        //create a new user
        public String createUser(User user) {
            if(userRepository.existsById(user.getUserName())){
                throw new IdAlreadyExistException();
            }
            User newUser = userRepository.save(user);
            return newUser.getUserName();
        }


        //update an existing user
        public void updateUser(String id, User newUser) {
            if (!userRepository.existsById(id)) throw new RecordNotFoundException();
            User user = userRepository.findById(id).get();
            user.setUserName(newUser.getUserName());
            user.setPassword(newUser.getPassword());
            user.setEmail(newUser.getEmail());
            userRepository.save(user);
        }

        //delete a user by id
        public void deleteUser(String id) {
            if (!userRepository.existsById(id)) throw new RecordNotFoundException();
            userRepository.deleteById(id);
        }

        //find a user by id
        public Optional<User> getUserById(String id) {
            if (!userRepository.existsById(id)) throw new RecordNotFoundException();
            return userRepository.findById(id);
        }

        //Get all the movies of the user_Id
        public Iterable<Movie> getMovies(String id) {
            Optional<User> user = userRepository.findById(id);
            if (user.isPresent()) {
                return user.get().getMovies();
            } else {
                throw new RecordNotFoundException();
            }
        }


    }

