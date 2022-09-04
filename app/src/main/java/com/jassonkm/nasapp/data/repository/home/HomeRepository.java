package com.jassonkm.nasapp.data.repository.home;

import com.jassonkm.nasapp.domain.Home;

import java.util.List;

import retrofit2.Call;

public interface HomeRepository {

    Call<List<Home>> getHomeFromRemote(String endpoint);
    List<Home> getHomeFromLocal();
    void insertAllHome(List<Home> homeList);
}
