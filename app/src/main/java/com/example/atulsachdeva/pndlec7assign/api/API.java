package com.example.atulsachdeva.pndlec7assign.api;

import com.example.atulsachdeva.pndlec7assign.models.Album;
import com.example.atulsachdeva.pndlec7assign.models.Comment;
import com.example.atulsachdeva.pndlec7assign.models.Photo;
import com.example.atulsachdeva.pndlec7assign.models.Post;
import com.example.atulsachdeva.pndlec7assign.models.Todo;
import com.example.atulsachdeva.pndlec7assign.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by AtulSachdeva on 14/09/17.
 */

public interface API {

    @GET("/users")
    Call<ArrayList<User>> getUsers();

    @GET("/posts")
    Call<ArrayList<Post>> getPosts();

    @GET("/albums")
    Call<ArrayList<Album>> getAlbums();

    @GET("/todos")
    Call<ArrayList<Todo>> getTodos();




    @GET("/comments")
    Call<ArrayList<Comment>> getCommentsOfPost(@Query("postId") int postId);



    @GET("/photos")
    Call<ArrayList<Photo>> getPhotosOfAlbum(@Query("albumId") int albumId);




    @GET("/posts")
    Call<ArrayList<Post>> getPostsOfUser(@Query("userId") int userId);

    @GET("/todos")
    Call<ArrayList<Todo>> getTodosOfUser(@Query("userId") int userId);

    @GET("/albums")
    Call<ArrayList<Album>> getAlbumsOfUser(@Query("userId") int userId);


}
