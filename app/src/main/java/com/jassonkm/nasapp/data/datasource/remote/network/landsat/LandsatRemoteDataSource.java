package com.jassonkm.nasapp.data.datasource.remote.network.landsat;

import com.jassonkm.nasapp.domain.Landsat;
import retrofit2.Call;

public interface LandsatRemoteDataSource {

    Call<Landsat> getLandsatFromApi(String lon, String lat, String date);
}
