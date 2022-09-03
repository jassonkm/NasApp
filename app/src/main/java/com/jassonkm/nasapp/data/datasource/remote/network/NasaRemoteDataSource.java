package com.jassonkm.nasapp.data.datasource.remote.network;

import com.jassonkm.nasapp.domain.Nasa;
import retrofit2.Call;

public interface NasaRemoteDataSource {

    Call<Nasa> getNasaFromApi(String apiKey);
}
