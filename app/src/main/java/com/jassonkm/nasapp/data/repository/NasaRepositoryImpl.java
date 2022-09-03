package com.jassonkm.nasapp.data.repository;

import com.jassonkm.nasapp.data.datasource.local.NasaLocalDataSource;
import com.jassonkm.nasapp.data.datasource.remote.network.NasaRemoteDataSource;
import com.jassonkm.nasapp.domain.Nasa;
import javax.inject.Inject;
import retrofit2.Call;

public class NasaRepositoryImpl implements NasaRepository {

    private final NasaRemoteDataSource nasaRemoteDataSource;
    private final NasaLocalDataSource nasaLocalDataSource;

    @Inject
    public NasaRepositoryImpl(NasaRemoteDataSource nasaRemoteDataSource, NasaLocalDataSource nasaLocalDataSource) {
        this.nasaRemoteDataSource = nasaRemoteDataSource;
        this.nasaLocalDataSource = nasaLocalDataSource;
    }

    @Override
    public Call<Nasa> getNasaFromRemote(String apiKey) {
        return nasaRemoteDataSource.getNasaFromApi(apiKey);
    }

    @Override
    public Nasa getNasaFromLocal() {
        return nasaLocalDataSource.getAllNasa();
    }

    @Override
    public void insertAll(Nasa nasaList) {
        nasaLocalDataSource.insertAll(nasaList);
    }
}