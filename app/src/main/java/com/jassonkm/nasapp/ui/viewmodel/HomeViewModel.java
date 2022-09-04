package com.jassonkm.nasapp.ui.viewmodel;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.jassonkm.nasapp.data.repository.home.HomeRepository;
import com.jassonkm.nasapp.domain.Home;
import java.util.List;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class HomeViewModel extends ViewModel {

    private final HomeRepository homeRepository;

    @Inject
    public HomeViewModel(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    private final MutableLiveData<Boolean> _isLoading = new MutableLiveData<>();
    public LiveData<Boolean> isLoading = _isLoading;

    private final MutableLiveData<List<Home>> _dataRemote = new MutableLiveData<>();

    public LiveData<List<Home>> getHome() {
        _isLoading.postValue(true);
        List<Home> home = homeRepository.getHomeFromLocal();
        homeRepository.getHomeFromRemote().enqueue(new Callback<List<Home>>() {
            @Override
            public void onResponse(@NonNull Call<List<Home>> call, @NonNull Response<List<Home>> response) {
                _isLoading.postValue(false);
                homeRepository.insertAllHome(response.body());
                _dataRemote.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<Home>> call, @NonNull Throwable throwable) {
                _isLoading.postValue(false);
                _dataRemote.postValue(home);
                Log.e("Error", "throwable" + throwable.getMessage());
            }
        });
        return _dataRemote;
    }
}

/* homeRepository.getHomeFromRemote().enqueue(new Callback<Home>() {
            @Override
            public void onResponse(@NonNull Call<Home> call, @NonNull Response<Home> response) {
                _isLoading.postValue(false);
                homeRepository.insertAllHome(response.body());
                _dataRemote.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<Home> call, @NonNull Throwable throwable) {
                _isLoading.postValue(false);
                _dataRemote.postValue(home);
                Log.e("Error", "throwable" + throwable.getMessage());
            }
        });*/
