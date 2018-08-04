package com.example.Pop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Rescue {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 5, max = 20)
    private String username;

    @Email
    private String email;

    @NotNull
    @Size(min = 6, max = 25)
    private String password;

    //@OneToMany
    //@JoinColumn(name = "user_id")
    //private List<animal> animals;

    public Rescue() {

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
}