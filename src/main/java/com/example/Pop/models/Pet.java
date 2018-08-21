package com.example.Pop.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.soap.Text;
import java.util.List;

/**
 * Created by LaunchCode
 */
@Entity
public class Pet {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    //@Size(min=3, message = "Please fill out name")
    private String name;

    @NotNull
    //@Size(min=1, message = "Please fill out age")
    private String age;

    @NotNull
    //@Size(min=1, message = "Please fill out size")
    private String size;

    @NotNull
    //@Size(min=1, message = "Please fill out all fixed")
    private String fixed;

    @NotNull
    //@Size(min=1, message = "Please fill out all family")
    private String idealFamily;

    @NotNull
    //@Size(min=1, message = "Please fill out all personality")
    private String personality;

    @NotNull
    //@Size(min=1, message = "Please fill out all vocal")
    private String vocal;

    @NotNull
    //@Size(min=1, message = "Please fill out all species")
    private String species;

    @NotNull
    //@Size(min=1, message = "Please fill out all breed")
    private String breed;

    @NotNull
    //@Size(min=1, message = "Please fill out all status")
    private String adoptionStatus;

    @NotNull
    //@Size(min=1, message = "Please fill out all pottytrained")
    private String pottyTrained;

    @NotNull
    //@Size(min=1, message = "Please fill out all color")
    private String color;

    @NotNull
    //@Size(min=1, message = "Please fill out all gender")
    private String gender;

    @NotNull
    //@Size(min=1, message = "Please fill out all training")
    private String training;

    @NotNull
    //@Size(min=1, message = "Please fill out all children")
    private String children;

    @NotNull
    //@Size(min=1, message = "Please fill out all cats")
    private String cats;

    @NotNull
    //@Size(min=1, message = "Please fill out all dogfriendly")
    private String dogFriendly;

    @NotNull
    //@Size(min=1, message = "Please fill out all rescue")
    private String rescue;

    @NotNull
    //@Size(min=1, message = "Please fill out all location")
    private String location;

    @NotNull
    //@Size(min=1, message = "Please fill out all interests")
    private String interests;

    @NotNull
    //@Size(min=1, message = "Please fill out about")
    private String about;


    /*@ManyToOne
    private Rescue Rescue; */

    public int getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFixed() {
        return fixed;
    }

    public void setFixed(String fixed) {
        this.fixed = fixed;
    }

    public String getIdealFamily() {
        return idealFamily;
    }

    public void setIdealFamily(String idealFamily) {
        this.idealFamily = idealFamily;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public String getVocal() {
        return vocal;
    }

    public void setVocal(String vocal) {
        this.vocal = vocal;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getAdoptionStatus() {
        return adoptionStatus;
    }

    public void setAdoptionStatus(String adoptionStatus) {
        this.adoptionStatus = adoptionStatus;
    }

    public String getPottyTrained() {
        return pottyTrained;
    }

    public void setPottyTrained(String pottyTrained) {
        this.pottyTrained = pottyTrained;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getCats() {
        return cats;
    }

    public void setCats(String cats) {
        this.cats = cats;
    }

    public String getDogFriendly() {
        return dogFriendly;
    }

    public void setDogFriendly(String dogFriendly) {
        this.dogFriendly = dogFriendly;
    }

    public String getRescue() {
        return rescue;
    }

    public void setRescue(String rescue) {
        this.rescue = rescue;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

}


