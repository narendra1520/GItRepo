package com.example.gitrepo.daggers;

import android.app.Application;

import com.example.gitrepo.MainActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {RetrofitModule.class})
public interface RetrofitComponent {

    void inject(MainActivity mainActivity);
}