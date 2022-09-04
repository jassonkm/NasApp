package com.jassonkm.nasapp.di;

import static com.jassonkm.nasapp.utils.Constants.NAME_NASA_DATABASE;
import android.content.Context;
import androidx.room.Room;

import com.jassonkm.nasapp.data.datasource.local.AppDatabase;
import com.jassonkm.nasapp.data.datasource.local.dao.AppDao;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RoomModule {

    @Singleton
    @Provides
    public static AppDatabase provideRoom(@ApplicationContext Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, NAME_NASA_DATABASE).allowMainThreadQueries().build();
    }

    @Singleton
    @Provides
    public static AppDao provideNasaDatabase(AppDatabase appDatabase) {
        return appDatabase.appDao();
    }
}