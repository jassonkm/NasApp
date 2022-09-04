package com.jassonkm.nasapp.data.datasource.local.landsat;

import com.jassonkm.nasapp.domain.Landsat;

public interface LandsatLocalDataSource {

    Landsat getAllLandsat();
    void insertAll(Landsat landsat);
}
