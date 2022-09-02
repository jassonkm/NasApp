package com.jassonkm.nasapp.data.datasource.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.jassonkm.nasapp.domain.Nasa;
import java.util.List;

@Dao
public interface NasaDao {

    @Query("SELECT * FROM nasa_table ORDER BY idNasa ASC")
    List<Nasa> getAllNasa();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Nasa nasa);
}