package com.waltonbd.retrofitpera;

import android.app.Application;

/**
 * Created by nayemuzzaman on 10/13/2018
 */
public class ResponseCreate extends Application {

    public static RetrofitClient retrofitClient;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = RetrofitClient.getInstance();

    }
}