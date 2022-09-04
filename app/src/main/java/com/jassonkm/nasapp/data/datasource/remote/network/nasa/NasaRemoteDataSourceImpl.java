package com.jassonkm.nasapp.data.datasource.remote.network.nasa;

import static com.jassonkm.nasapp.utils.Constants.API_KEY;
import static com.jassonkm.nasapp.utils.Constants.BASE_URL_NASA;

import com.jassonkm.nasapp.domain.Nasa;
import javax.inject.Inject;
import retrofit2.Call;

public class NasaRemoteDataSourceImpl implements NasaRemoteDataSource {

    private final NasaApi nasaApi;

    @Inject
    public NasaRemoteDataSourceImpl(NasaApi nasaApi) {
        this.nasaApi = nasaApi;
    }

    @Override
    public Call<Nasa> getNasaFromApi() {
        return nasaApi.getNasa(BASE_URL_NASA, API_KEY);
    }
}