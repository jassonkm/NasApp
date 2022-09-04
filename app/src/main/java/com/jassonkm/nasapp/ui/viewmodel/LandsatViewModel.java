package com.jassonkm.nasapp.ui.viewmodel;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.jassonkm.nasapp.data.repository.landsat.LandsatRepository;
import com.jassonkm.nasapp.domain.Landsat;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class LandsatViewModel extends ViewModel {

    private final LandsatRepository landsatRepository;

    @Inject
    public LandsatViewModel(LandsatRepository landsatRepository) {
        this.landsatRepository = landsatRepository;
    }

    private final MutableLiveData<Boolean> _isLoading = new MutableLiveData<>();
    public LiveData<Boolean> isLoading = _isLoading;

    private final MutableLiveData<Landsat> _dataRemote = new MutableLiveData<>();

    public LiveData<Landsat> getLandsat(String lon, String lat, String date) {
        _isLoading.postValue(true);
       Landsat landsat = landsatRepository.getLandsatFromLocal();
       landsatRepository.getLandsatFromRemote(lon, lat, date).enqueue(new Callback<Landsat>() {
           @Override
           public void onResponse(@NonNull Call<Landsat> call, @NonNull Response<Landsat> response) {
               _isLoading.postValue(false);
               landsatRepository.insertAllLandsat(response.body());
               _dataRemote.postValue(response.body());
           }

           @Override
           public void onFailure(@NonNull Call<Landsat> call, @NonNull Throwable throwable) {
               _isLoading.postValue(false);
               _dataRemote.postValue(landsat);
               Log.e("Error", "throwable" + throwable.getMessage());
           }
       });

        return _dataRemote;
    }
}
