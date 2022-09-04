package com.jassonkm.nasapp.data.datasource.local.home;

import com.jassonkm.nasapp.domain.Home;
import com.jassonkm.nasapp.domain.Nasa;

import java.util.List;

public interface HomeLocalDataSource {

    List<Home> getAllHome();
    void insertAll(List<Home> homeList);
}
