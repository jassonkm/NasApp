package com.jassonkm.nasapp.di;

import com.jassonkm.nasapp.data.datasource.local.NasaLocalDataSource;
import com.jassonkm.nasapp.data.datasource.local.NasaLocalDataSourceImpl;
import com.jassonkm.nasapp.data.datasource.local.dao.NasaDao;
import com.jassonkm.nasapp.data.datasource.remote.network.NasaRemoteDataSource;
import com.jassonkm.nasapp.data.datasource.remote.network.NasaRemoteDataSourceImpl;
import com.jassonkm.nasapp.data.repository.NasaRepository;
import com.jassonkm.nasapp.data.repository.NasaRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class NasaModule {

    @Singleton
    @Provides
    public static NasaRemoteDataSource provideNasaRemoteDataSource(NasaRemoteDataSourceImpl nasaRemoteDataSourceIml) {
        return nasaRemoteDataSourceIml;
    }

    @Singleton
    @Provides
    public static NasaRepository provideNasaRepository(NasaRepositoryImpl nasaRepositoryIml) {
        return nasaRepositoryIml;
    }

    @Singleton
    @Provides
    public static NasaLocalDataSource provideNasaDao(NasaLocalDataSourceImpl nasaLocalDataSourceImpl) {
        return nasaLocalDataSourceImpl;
    }
}
