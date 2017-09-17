package com.example.atulsachdeva.pndlec7assign.models;

/**
 * Created by AtulSachdeva on 11/09/17.
 */

public class Post {

    Integer id, userId;
    String title, body;

    public Post(Integer id, Integer userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
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

    public String getBody() {
        return body;
    }
}
