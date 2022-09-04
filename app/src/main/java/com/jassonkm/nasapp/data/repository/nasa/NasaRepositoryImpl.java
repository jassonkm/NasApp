package com.jassonkm.nasapp.data.repository.nasa;

import com.jassonkm.nasapp.data.datasource.local.nasa.NasaLocalDataSource;
import com.jassonkm.nasapp.data.datasource.remote.network.nasa.NasaRemoteDataSource;
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
    public Call<Nasa> getNasaFromRemote() {
        return nasaRemoteDataSource.getNasaFromApi();
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