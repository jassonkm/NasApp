package com.jassonkm.nasapp.domain;

import static com.jassonkm.nasapp.utils.Constants.API_KEY;

import android.util.Log;
import androidx.annotation.NonNull;
import com.jassonkm.nasapp.data.repository.NasaRepository;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NasaUseCase {

    private final NasaRepository nasaRepository;

    @Inject
    public NasaUseCase(NasaRepository nasaRepository) {
        this.nasaRepository = nasaRepository;
    }

    public void getAllNasa() {
        List<Nasa> nasaLocal = nasaRepository.getNasaFromLocal();

        if (nasaLocal.isEmpty()) {
           nasaRepository.getNasaFromRemote(API_KEY).enqueue(new Callback<Nasa>() {

                @Override
                public void onResponse(@NonNull Call<Nasa> call, @NonNull Response<Nasa> response) {
                    if (response.isSuccessful()) {
                        nasaRepository.insertAll(response.body());
                    } else {
                        nasaRepository.getNasaFromLocal();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<Nasa> call, @NonNull Throwable throwable) {
                    Log.e("Hola", "Error" +throwable.getMessage());
                }
            });
        }
    }
}

/* MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txtString.setText(myResponse);
                    }
                });*/
