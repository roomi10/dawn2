package com.example.quest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SituationsService {
    @GET("/getsituation")
    Call<Situation> getSituation(@Query("main_id") int main_id);


    @GET ("/getbegin")
    Call<Situation> getBeginSituation();
}
