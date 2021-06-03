package com.example.periodtracker;

public class User {

    int id;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name){
        //this.id=id;
        this.name=name;
    }
}
