package com.jassonkm.nasapp.data.datasource.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.jassonkm.nasapp.data.datasource.local.dao.NasaDao;
import com.jassonkm.nasapp.domain.Nasa;

@Database(entities = {Nasa.class}, version = 1)
public abstract class NasaDatabase extends RoomDatabase {

    public abstract NasaDao nasaDao();
}