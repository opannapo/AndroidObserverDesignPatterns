package com.napodev.androidobserver.observables;

import java.util.Observable;

/**
 * Created by opannapo on 11/4/17.
 */

public class UserEntity extends Observable {
    private String name;
    private int age;
    private String music;
    private String country;
    private String city;
    private String bio;

    private static UserEntity INSTANCE;

    public static UserEntity getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserEntity();
        }

        return INSTANCE;
    }


    public String getName() {
        return name;
    }

    public UserEntity setName(String name) {
        this.name = name;
        setChanged();
        return this;
    }

    public int getAge() {
        return age;
    }

    public UserEntity setAge(int age) {
        this.age = age;
        setChanged();
        return this;
    }

    public String getMusic() {
        return music;
    }

    public UserEntity setMusic(String music) {
        this.music = music;
        setChanged();
        return this;
    }

    public String getCountry() {
        return country;
    }

    public UserEntity setCountry(String country) {
        this.country = country;
        setChanged();
        return this;
    }

    public String getCity() {
        return city;
    }

    public UserEntity setCity(String city) {
        this.city = city;
        setChanged();
        return this;
    }

    public String getBio() {
        return bio;
    }

    public UserEntity setBio(String bio) {
        this.bio = bio;
        setChanged();
        return this;
    }
}
