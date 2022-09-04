package com.jassonkm.nasapp.data.datasource.local.nasa;

import com.jassonkm.nasapp.domain.Nasa;

public interface NasaLocalDataSource {
    Nasa getAllNasa();
    void insertAll(Nasa nasaList);
}