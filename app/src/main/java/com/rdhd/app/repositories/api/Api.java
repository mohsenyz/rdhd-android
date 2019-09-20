package com.rdhd.app.repositories.api;

import com.rdhd.app.models.MyGetService;

import java.util.List;

import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("/service}")
    public Callback<List<MyGetService>> getGetService(@Query("id") String id);
}
