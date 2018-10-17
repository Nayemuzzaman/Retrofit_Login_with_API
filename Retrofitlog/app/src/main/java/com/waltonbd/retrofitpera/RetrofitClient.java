package com.waltonbd.retrofitpera;

/*import org.json.JSONObject;*/

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by nayemuzzaman on 10/13/2018
 */
public class RetrofitClient {

    private static Api service;
    private static RetrofitClient retrofitClient;

    private RetrofitClient(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://000.000.000.00:8080/") //put your api link
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(Api.class);
    }

    public static RetrofitClient getInstance() {
        if (retrofitClient == null) {
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }

    public void getUser(JSONObject login, Callback<User> callback) {
        Call<User> loginCall =  service.getUser( String.valueOf( login ) );
        loginCall.enqueue(callback);
    }
}
