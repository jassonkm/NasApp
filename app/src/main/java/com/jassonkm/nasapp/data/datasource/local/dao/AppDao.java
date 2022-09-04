package com.jassonkm.nasapp.data.datasource.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.jassonkm.nasapp.domain.Home;
import com.jassonkm.nasapp.domain.Landsat;
import com.jassonkm.nasapp.domain.Nasa;

import java.util.List;

@Dao
public interface AppDao {

    @Query("SELECT * FROM nasa_table ORDER BY idNasa ASC")
    Nasa getAllNasa();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllNasa(Nasa nasa);

    @Query("SELECT * FROM home_table ORDER BY idLocal ASC")
    List<Home> getAllHome();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllHome(List<Home> homeList);

    @Query("SELECT * FROM landsat_table ORDER BY idLandsat ASC")
    Landsat getAllLandsat();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllLandsat(Landsat landsat);
}