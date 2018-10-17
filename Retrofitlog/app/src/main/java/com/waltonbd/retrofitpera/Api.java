package com.waltonbd.retrofitpera;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by nayemuzzaman on 10/13/2018
 */
public interface Api {
    @Headers("Content-Type: application/json")
    @POST("/other/api/login") //ensure your url link 
    Call <User> getUser(@Body String login);

}
