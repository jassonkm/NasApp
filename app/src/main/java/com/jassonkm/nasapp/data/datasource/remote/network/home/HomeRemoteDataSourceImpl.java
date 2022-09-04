package com.jassonkm.nasapp.data.datasource.remote.network.home;

import static com.jassonkm.nasapp.utils.Constants.BASE_URL_HOME;
import static com.jassonkm.nasapp.utils.Constants.ENDPOINT_CO2;

import com.jassonkm.nasapp.domain.Home;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;

public class HomeRemoteDataSourceImpl implements HomeRemoteDataSource {

    private final HomeApi homeApi;

    @Inject
    public HomeRemoteDataSourceImpl(HomeApi homeApi) {
        this.homeApi = homeApi;
    }

    @Override
    public Call<List<Home>> getHomeFromApi() {
        return homeApi.getHome(BASE_URL_HOME+ENDPOINT_CO2);
    }
}
