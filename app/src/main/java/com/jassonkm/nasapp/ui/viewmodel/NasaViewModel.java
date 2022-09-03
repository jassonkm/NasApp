package com.jassonkm.nasapp.ui.viewmodel;

import static com.jassonkm.nasapp.utils.Constants.API_KEY;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.jassonkm.nasapp.data.repository.NasaRepository;
import com.jassonkm.nasapp.domain.Nasa;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class NasaViewModel extends ViewModel {

    private final NasaRepository nasaRepository;

    @Inject
    public NasaViewModel(NasaRepository nasaRepository) {
        this.nasaRepository = nasaRepository;
    }

    private final MutableLiveData<Boolean> _isLoading = new MutableLiveData<>();
    public LiveData<Boolean> isLoading = _isLoading;

    private final MutableLiveData<Nasa> _dataRemote = new MutableLiveData<>();

    public LiveData<Nasa> getNasa() {
        _isLoading.postValue(true);
        Nasa nasa = nasaRepository.getNasaFromLocal();
        nasaRepository.getNasaFromRemote(API_KEY).enqueue(new Callback<Nasa>() {
            @Override
            public void onResponse(@NonNull Call<Nasa> call, @NonNull Response<Nasa> response) {
                _isLoading.postValue(false);
                nasaRepository.insertAll(response.body());
                _dataRemote.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<Nasa> call, @NonNull Throwable throwable) {
                _isLoading.postValue(false);
                _dataRemote.postValue(nasa);
                Log.e("Error", "throwable" + throwable.getMessage());
            }
        });

        return _dataRemote;
    }
}