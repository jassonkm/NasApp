package com.jassonkm.nasapp.di;

import com.jassonkm.nasapp.data.datasource.local.nasa.NasaLocalDataSource;
import com.jassonkm.nasapp.data.datasource.local.nasa.NasaLocalDataSourceImpl;
import com.jassonkm.nasapp.data.datasource.remote.network.nasa.NasaRemoteDataSource;
import com.jassonkm.nasapp.data.datasource.remote.network.nasa.NasaRemoteDataSourceImpl;
import com.jassonkm.nasapp.data.repository.nasa.NasaRepository;
import com.jassonkm.nasapp.data.repository.nasa.NasaRepositoryImpl;
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