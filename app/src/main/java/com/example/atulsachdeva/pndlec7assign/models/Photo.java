package com.example.atulsachdeva.pndlec7assign.models;

/**
 * Created by AtulSachdeva on 11/09/17.
 */

public class Photo {

    Integer id;
    String tite, url;

    public Photo(Integer id, String tite, String url) {
        this.id = id;
        this.tite = tite;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public String getTite() {
        return tite;
    }

    public String getUrl() {
        return url;
    }
}
