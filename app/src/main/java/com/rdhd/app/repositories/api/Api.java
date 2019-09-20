package com.rdhd.app.repositories.api;

import com.rdhd.app.models.GetService;
import com.rdhd.app.models.Service;

import java.util.List;

import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("/service}")
    public Callback<List<GetService>> getGetService(@Query("id") String id);
}
