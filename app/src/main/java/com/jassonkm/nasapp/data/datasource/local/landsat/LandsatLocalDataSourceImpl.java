package com.jassonkm.nasapp.data.datasource.local.landsat;

import com.jassonkm.nasapp.data.datasource.local.dao.AppDao;
import com.jassonkm.nasapp.domain.Landsat;
import javax.inject.Inject;

public class LandsatLocalDataSourceImpl implements LandsatLocalDataSource {

    private final AppDao appDao;

    @Inject
    public LandsatLocalDataSourceImpl(AppDao appDao) {
        this.appDao = appDao;
    }

    @Override
    public Landsat getAllLandsat() {
        return appDao.getAllLandsat();
    }

    @Override
    public void insertAll(Landsat landsat) {
        appDao.insertAllLandsat(landsat);
    }
}