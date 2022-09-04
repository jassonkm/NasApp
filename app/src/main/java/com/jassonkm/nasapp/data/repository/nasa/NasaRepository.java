package com.jassonkm.nasapp.data.repository.nasa;

import com.jassonkm.nasapp.domain.Nasa;
import retrofit2.Call;

public interface NasaRepository {

    Call<Nasa> getNasaFromRemote();
    Nasa getNasaFromLocal();
    void insertAll(Nasa nasa);
}