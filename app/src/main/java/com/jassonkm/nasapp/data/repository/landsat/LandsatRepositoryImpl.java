package com.jassonkm.nasapp.data.repository.landsat;

import com.jassonkm.nasapp.data.datasource.local.landsat.LandsatLocalDataSource;
import com.jassonkm.nasapp.data.datasource.remote.network.landsat.LandsatRemoteDataSource;
import com.jassonkm.nasapp.domain.Landsat;
import javax.inject.Inject;
import retrofit2.Call;

public class LandsatRepositoryImpl implements LandsatRepository {

    private final LandsatRemoteDataSource landsatRemoteDataSource;
    private final LandsatLocalDataSource landsatLocalDataSource;

    @Inject
    public LandsatRepositoryImpl(LandsatRemoteDataSource landsatRemoteDataSource, LandsatLocalDataSource landsatLocalDataSource) {
        this.landsatRemoteDataSource = landsatRemoteDataSource;
        this.landsatLocalDataSource = landsatLocalDataSource;
    }

    @Override
    public Call<Landsat> getLandsatFromRemote(String lon, String lat, String date) {
        return landsatRemoteDataSource.getLandsatFromApi(lon, lat, date);
    }

    @Override
    public Landsat getLandsatFromLocal() {
        return landsatLocalDataSource.getAllLandsat();
    }

    @Override
    public void insertAllLandsat(Landsat landsat) {
        landsatLocalDataSource.insertAll(landsat);
    }
}
