package com.example.quest;

import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Story {
    private Situation start_story;
    public Situation current_situation;

    GameActivity activity;
    Story(final GameActivity activity) {
        this.activity = activity;
        Retrofit r = MyRetrofit.appServer();

        //загружается ситуация с номером i
        SituationsService s = r.create(SituationsService.class);
        Call<Situation> call = s.getBeginSituation();
        call.enqueue(new Callback<Situation>() {
            @Override
            public void onResponse(Call<Situation> call, Response<Situation> response) {
                start_story = response.body();
                current_situation=start_story;
                activity.apply();
            }

            @Override
            public void onFailure(Call<Situation> call, Throwable t) {
                Toast.makeText(activity, "Ошибка", Toast.LENGTH_SHORT).show();
            }
        });
        //Response BO
}

    public void go(int i) {
        //создается ретрофит
        Retrofit r = MyRetrofit.appServer();

        //загружается ситуация с номером i
        SituationsService s = r.create(SituationsService.class);
        Call<Situation> call = s.getSituation(i);
        call.enqueue(new Callback<Situation>() {
            @Override
            public void onResponse(Call<Situation> call, Response<Situation> response) {
               current_situation = response.body();
               Story.this.activity.apply();
            }

            @Override
            public void onFailure(Call<Situation> call, Throwable t) {
                Toast.makeText(activity, "Ошибка", Toast.LENGTH_SHORT).show();

            }
        });
        // на основе этих данных создается situation
    }
}
