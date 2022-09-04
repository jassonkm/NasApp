package com.jassonkm.nasapp.data.repository.home;

import com.jassonkm.nasapp.data.datasource.local.home.HomeLocalDataSource;
import com.jassonkm.nasapp.data.datasource.local.nasa.NasaLocalDataSource;
import com.jassonkm.nasapp.data.datasource.remote.network.home.HomeRemoteDataSource;
import com.jassonkm.nasapp.domain.Home;

import java.util.List;

import javax.inject.Inject;
import retrofit2.Call;

public class HomeRepositoryImpl implements HomeRepository {

    private final HomeRemoteDataSource homeRemoteDataSource;
    private final HomeLocalDataSource homeLocalDataSource;

    @Inject
    public HomeRepositoryImpl(HomeRemoteDataSource homeRemoteDataSource, HomeLocalDataSource homeLocalDataSource) {
        this.homeRemoteDataSource = homeRemoteDataSource;
        this.homeLocalDataSource = homeLocalDataSource;
    }

    @Override
    public Call<List<Home>> getHomeFromRemote(String endpoint) {
        return homeRemoteDataSource.getHomeFromApi(endpoint);
    }

    @Override
    public List<Home> getHomeFromLocal() {
        return homeLocalDataSource.getAllHome();
    }

    @Override
    public void insertAllHome(List<Home> homeList) {
        homeLocalDataSource.insertAll(homeList);
    }
}
