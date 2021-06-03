package com.example.quest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofit {
    public static Retrofit appServer() {
        return new Retrofit.Builder()
                .baseUrl("http://192.168.1.105:8009")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
