package com.example.gitrepo.daggers;

import android.app.Application;

public class MyApplication extends Application {
    private RetrofitComponent retrofitComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofitComponent = DaggerRetrofitComponent.builder()
                .retrofitModule(new RetrofitModule("https://api.github.com/"))
                .build();
    }

    public RetrofitComponent getRetrofitComponent() {
        return retrofitComponent;
    }
}
