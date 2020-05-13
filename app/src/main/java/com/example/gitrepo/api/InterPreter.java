package com.example.gitrepo.api;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface InterPreter {
    @GET("repositories/19438/issues")
    Observable<List<GitRepoResponse>> getIssues();
}
