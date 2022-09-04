package com.jassonkm.nasapp.data.repository.landsat;

import com.jassonkm.nasapp.domain.Landsat;

import retrofit2.Call;

public interface LandsatRepository {

    Call<Landsat> getLandsatFromRemote(String lon, String lat, String date);
    Landsat getLandsatFromLocal();
    void insertAllLandsat(Landsat landsat);
}
