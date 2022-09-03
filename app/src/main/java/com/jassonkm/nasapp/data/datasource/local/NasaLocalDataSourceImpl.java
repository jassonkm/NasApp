package com.jassonkm.nasapp.data.datasource.local;

import com.jassonkm.nasapp.data.datasource.local.dao.NasaDao;
import com.jassonkm.nasapp.domain.Nasa;
import javax.inject.Inject;

public class NasaLocalDataSourceImpl implements NasaLocalDataSource {

    private final NasaDao nasaDao;

    @Inject
    public NasaLocalDataSourceImpl(NasaDao nasaDao) {
        this.nasaDao = nasaDao;
    }

    @Override
    public Nasa getAllNasa() {
        return nasaDao.getAllNasa();
    }

    @Override
    public void insertAll(Nasa nasaList) {
        nasaDao.insertAll(nasaList);
    }
}