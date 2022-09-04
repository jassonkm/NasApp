package com.jassonkm.nasapp.domain;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "landsat_table")
public class Landsat {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idLandsat")
    private int id;

    @SerializedName("url")
    @ColumnInfo(name = "url")
    private String url;

    public Landsat() {
        super();
    }

    public Landsat(int id, String url) {
        this.id = id;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
