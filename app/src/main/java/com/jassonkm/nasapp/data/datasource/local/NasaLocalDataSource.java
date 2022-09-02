package com.jassonkm.nasapp.data.datasource.local;

import com.jassonkm.nasapp.domain.Nasa;
import java.util.List;

public interface NasaLocalDataSource {

    List<Nasa> getAllNasa();
    void insertAll(Nasa nasaList);
}