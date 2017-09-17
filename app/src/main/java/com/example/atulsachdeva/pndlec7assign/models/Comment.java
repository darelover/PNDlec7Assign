package com.example.atulsachdeva.pndlec7assign.models;

/**
 * Created by AtulSachdeva on 11/09/17.
 */

public class Comment {

    Integer id;
    String name, email, body;

    public Comment(Integer id, String name, String email, String body) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}
