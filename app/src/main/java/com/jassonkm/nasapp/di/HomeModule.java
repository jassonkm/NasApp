package com.jassonkm.nasapp.di;

import static com.jassonkm.nasapp.utils.Constants.BASE_URL_HOME;
import com.jassonkm.nasapp.data.datasource.local.home.HomeLocalDataSource;
import com.jassonkm.nasapp.data.datasource.local.home.HomeLocalDataSourceImpl;
import com.jassonkm.nasapp.data.datasource.remote.network.home.HomeApi;
import com.jassonkm.nasapp.data.datasource.remote.network.home.HomeRemoteDataSource;
import com.jassonkm.nasapp.data.datasource.remote.network.home.HomeRemoteDataSourceImpl;
import com.jassonkm.nasapp.data.repository.home.HomeRepository;
import com.jassonkm.nasapp.data.repository.home.HomeRepositoryImpl;
import com.skydoves.sandwich.adapters.ApiResponseCallAdapterFactory;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class HomeModule {

    @Singleton
    @Provides
    public static HomeRemoteDataSource provideHomeRemoteDataSource(HomeRemoteDataSourceImpl homeRemoteDataSourceImpl) {
        return homeRemoteDataSourceImpl;
    }

    @Singleton
    @Provides
    public static HomeRepository provideHomeRepository(HomeRepositoryImpl homeRepositoryIml) {
        return homeRepositoryIml;
    }

    @Singleton
    @Provides
    public static HomeLocalDataSource provideHomeDao(HomeLocalDataSourceImpl homeLocalDataSourceImpl) {
        return homeLocalDataSourceImpl;
    }

    @Singleton
    @Provides
    public static HomeApi provideApiService(Retrofit retrofit) {
        return retrofit.create(HomeApi.class);
    }
}
