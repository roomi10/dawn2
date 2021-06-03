package com.example.quest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AnswerService {

    @GET ("/getanswers")
    Call<List<Answer>> getAnswers(@Query("main_id") int main_id);


}
