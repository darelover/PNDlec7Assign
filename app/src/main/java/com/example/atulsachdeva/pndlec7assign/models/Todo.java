package com.example.atulsachdeva.pndlec7assign.models;

/**
 * Created by AtulSachdeva on 11/09/17.
 */

public class Todo {

    Integer id, userId;
    String title;
    Boolean checked;

    public Todo(Integer id, Integer userId, String title, Boolean checked) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.checked = checked;
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

    public Boolean getChecked() {
        return checked;
    }
}
