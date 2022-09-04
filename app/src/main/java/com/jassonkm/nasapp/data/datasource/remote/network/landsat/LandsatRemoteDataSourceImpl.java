package com.jassonkm.nasapp.data.datasource.remote.network.landsat;

import static com.jassonkm.nasapp.utils.Constants.*;
import com.jassonkm.nasapp.domain.Landsat;
import javax.inject.Inject;
import retrofit2.Call;

public class LandsatRemoteDataSourceImpl implements LandsatRemoteDataSource {

    private final LandsatApi landsatApi;

    @Inject
    public LandsatRemoteDataSourceImpl(LandsatApi landsatApi) {
        this.landsatApi = landsatApi;
    }

    @Override
    public Call<Landsat> getLandsatFromApi(String lon, String lat, String date) {
        return landsatApi.getLandsat(BASE_URL_LANDSAT+QUERY_LON+lon+QUERY_LAT+lat+QUERY_DATE+date+QUERY_API_KEY+API_KEY);
    }
}
