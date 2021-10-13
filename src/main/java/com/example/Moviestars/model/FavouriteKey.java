package com.example.Moviestars.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FavouriteKey implements Serializable {

    @Column(name = "user_id")
    String userName;

    @Column(name = "movie_id")
    Long id;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FavouriteKey(String userName, Long id) {
        this.userName = userName;
        this.id = id;
    }

    public FavouriteKey() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavouriteKey that = (FavouriteKey) o;
        return userName.equals(that.userName) && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, id);
    }
}
