package com.jassonkm.nasapp.data.repository;

import com.jassonkm.nasapp.domain.Nasa;
import retrofit2.Call;

public interface NasaRepository {

    Call<Nasa> getNasaFromRemote(String apiKey);
    Nasa getNasaFromLocal();
    void insertAll(Nasa nasa);
}