package com.jassonkm.nasapp.data.datasource.remote.network;

import com.jassonkm.nasapp.domain.Nasa;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;

public class NasaRemoteDataSourceImpl implements NasaRemoteDataSource {

    private final NasaApi nasaApi;

    @Inject
    public NasaRemoteDataSourceImpl(NasaApi nasaApi) {
        this.nasaApi = nasaApi;
    }

    @Override
    public Call<Nasa> getNasaFromApi(String apiKey) {
        return nasaApi.getNasa(apiKey);
    }
}