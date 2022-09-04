package com.jassonkm.nasapp.data.datasource.remote.network.landsat;

import com.jassonkm.nasapp.domain.Landsat;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface LandsatApi {

    @GET
    Call<Landsat> getLandsat(@Url String urlLandsat);
}
