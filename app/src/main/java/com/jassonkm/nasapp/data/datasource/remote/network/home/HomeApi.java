package com.jassonkm.nasapp.data.datasource.remote.network.home;

import com.jassonkm.nasapp.domain.Home;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface HomeApi {

    @GET
    Call<List<Home>> getHome(@Url String urlHome);
}
