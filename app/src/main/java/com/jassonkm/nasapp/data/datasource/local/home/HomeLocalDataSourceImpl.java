package com.jassonkm.nasapp.data.datasource.local.home;


import com.jassonkm.nasapp.data.datasource.local.dao.AppDao;
import com.jassonkm.nasapp.domain.Home;

import java.util.List;

import javax.inject.Inject;

public class HomeLocalDataSourceImpl implements HomeLocalDataSource {

    private final AppDao appDao;

    @Inject
    public HomeLocalDataSourceImpl(AppDao appDao) {
        this.appDao = appDao;
    }

    @Override
    public List<Home> getAllHome() {
        return appDao.getAllHome();
    }

    @Override
    public void insertAll(List<Home> homeList) {
        appDao.insertAllHome(homeList);
    }
}
