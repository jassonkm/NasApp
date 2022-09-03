package com.jassonkm.nasapp.data.datasource.remote.network;

import com.jassonkm.nasapp.domain.Nasa;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NasaApi {

    @GET("apod")
    Call<Nasa> getNasa(@Query("api_key") String apiKey);
}