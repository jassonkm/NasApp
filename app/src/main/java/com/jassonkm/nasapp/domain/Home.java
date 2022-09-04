package com.jassonkm.nasapp.domain;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "home_table")
public class Home {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idLocal")
    private int id;

  /*  @SerializedName("id")
    @ColumnInfo(name = "idRemote")
    private String idHome;*/

    @SerializedName("year")
    @ColumnInfo(name = "year")
    private String year;

    @SerializedName("measurement")
    @ColumnInfo(name = "measurement")
    private String measurement;

    @SerializedName("unc")
    @ColumnInfo(name = "unc")
    private String unc;

    @SerializedName("unit")
    @ColumnInfo(name = "unit")
    private String unit;

    public Home() {
        super();
    }

    public Home(int id /*String idHome*/, String year, String measurement, String unc, String unit) {
        this.id = id;
       // this.idHome = idHome;
        this.year = year;
        this.measurement = measurement;
        this.unc = unc;
        this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  /*  public String getIdHome() {
        return idHome;
    }

    public void setIdHome(String idHome) {
        this.idHome = idHome;
    }*/

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public String getUnc() {
        return unc;
    }

    public void setUnc(String unc) {
        this.unc = unc;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
