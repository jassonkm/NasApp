package com.jassonkm.nasapp.data.datasource.local;

import androidx.room.RoomDatabase;
import com.jassonkm.nasapp.data.datasource.local.dao.AppDao;
import com.jassonkm.nasapp.domain.Home;
import com.jassonkm.nasapp.domain.Nasa;

@androidx.room.Database(entities = {Nasa.class, Home.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract AppDao appDao();
}