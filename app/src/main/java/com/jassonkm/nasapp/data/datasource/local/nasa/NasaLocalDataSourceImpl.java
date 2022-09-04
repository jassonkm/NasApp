package com.jassonkm.nasapp.data.datasource.local.nasa;

import com.jassonkm.nasapp.data.datasource.local.dao.AppDao;
import com.jassonkm.nasapp.data.datasource.local.nasa.NasaLocalDataSource;
import com.jassonkm.nasapp.domain.Nasa;
import javax.inject.Inject;

public class NasaLocalDataSourceImpl implements NasaLocalDataSource {

    private final AppDao appDao;

    @Inject
    public NasaLocalDataSourceImpl(AppDao appDao) {
        this.appDao = appDao;
    }

    @Override
    public Nasa getAllNasa() {
        return appDao.getAllNasa();
    }

    @Override
    public void insertAll(Nasa nasaList) {
        appDao.insertAllNasa(nasaList);
    }
}