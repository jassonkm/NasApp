package com.jassonkm.nasapp.data.datasource.remote.network.home;

import com.jassonkm.nasapp.domain.Home;

import java.util.List;

import retrofit2.Call;

public interface HomeRemoteDataSource {

    Call<List<Home>> getHomeFromApi();
}
