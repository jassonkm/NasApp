package com.jassonkm.nasapp.data.datasource.remote.network.nasa;

import com.jassonkm.nasapp.domain.Nasa;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface NasaApi {

    @GET
    Call<Nasa> getNasa(@Url String urlNasa, @Query("api_key") String apiKey);
}