package com.example.atulsachdeva.pndlec7assign.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by AtulSachdeva on 14/09/17.
 */

public class ApiService {

    private ApiService() {}

    private static API api = null;

    public static API getApi() {
        if(api == null){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://www.jsonplaceholder.typicode.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            api = retrofit.create(API.class);
        }

        return api;
    }
}
