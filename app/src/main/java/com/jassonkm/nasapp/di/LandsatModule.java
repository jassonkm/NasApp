package com.jassonkm.nasapp.di;


import com.jassonkm.nasapp.data.datasource.local.landsat.LandsatLocalDataSource;
import com.jassonkm.nasapp.data.datasource.local.landsat.LandsatLocalDataSourceImpl;
import com.jassonkm.nasapp.data.datasource.remote.network.landsat.LandsatApi;
import com.jassonkm.nasapp.data.datasource.remote.network.landsat.LandsatRemoteDataSource;
import com.jassonkm.nasapp.data.datasource.remote.network.landsat.LandsatRemoteDataSourceImpl;
import com.jassonkm.nasapp.data.repository.landsat.LandsatRepository;
import com.jassonkm.nasapp.data.repository.landsat.LandsatRepositoryImpl;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;

@Module
@InstallIn(SingletonComponent.class)
public class LandsatModule {

    @Singleton
    @Provides
    public static LandsatRemoteDataSource provideLandsatRemoteDataSource(LandsatRemoteDataSourceImpl landsatRemoteDataSourceImpl) {
        return landsatRemoteDataSourceImpl;
    }

    @Singleton
    @Provides
    public static LandsatRepository provideLandsatRepository(LandsatRepositoryImpl landsatRepositoryImpl) {
        return landsatRepositoryImpl;
    }

    @Singleton
    @Provides
    public static LandsatLocalDataSource provideLandsatDao(LandsatLocalDataSourceImpl landsatLocalDataSourceImpl) {
        return landsatLocalDataSourceImpl;
    }

    @Singleton
    @Provides
    public static LandsatApi provideApiService(Retrofit retrofit) {
        return retrofit.create(LandsatApi.class);
    }
}
