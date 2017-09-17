package com.example.atulsachdeva.pndlec7assign.models;

/**
 * Created by AtulSachdeva on 11/09/17.
 */

public class Album {

    Integer id, userId;
    String title;

    public Album(Integer id, Integer userId, String title) {
        this.id = id;
        this.userId = userId;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }
}
