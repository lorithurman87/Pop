package com.example.Pop.models;


//import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=5, max=20)
    private String username;

    @Email
    @Size(min=4)//, message = "Please add a valid email address")
    private String email;

    @NotNull
    @Size(min=6, max=25, message = "Please add a password between 6-25 characters")
    private String password;

    //@OneToMany  @Size(min=1, message = "Description must not be empty")
    //@JoinColumn(name = "user_id")
    //private List<animal> animals;

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //public List<animal> getAnimals() {return animals;}

}
