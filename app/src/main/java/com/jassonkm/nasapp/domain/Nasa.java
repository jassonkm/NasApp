package com.jassonkm.nasapp.domain;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "nasa_table")
public class Nasa {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idNasa")
    private int id;

    @SerializedName("hdurl")
    @ColumnInfo(name = "image")
    private String image;

    @SerializedName("url")
    @ColumnInfo(name = "url")
    private String imageUrl;

    @SerializedName("title")
    @ColumnInfo(name = "title")
    private String title;

    @SerializedName("explanation")
    @ColumnInfo(name = "metadata")
    private String metadata;

    public Nasa() {
        super();
    }

    public Nasa(int id, String image, String imageUrl, String title, String metadata) {
        this.id = id;
        this.image = image;
        this.imageUrl = imageUrl;
        this.title = title;
        this.metadata = metadata;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }
}