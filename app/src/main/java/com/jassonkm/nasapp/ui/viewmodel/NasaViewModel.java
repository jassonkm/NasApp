package com.jassonkm.nasapp.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jassonkm.nasapp.domain.Nasa;
import com.jassonkm.nasapp.domain.NasaUseCase;
import com.jassonkm.nasapp.utils.Resource;

import javax.inject.Inject;

public class NasaViewModel extends ViewModel {

    private final NasaUseCase nasaUseCase;

    @Inject
    public NasaViewModel(NasaUseCase nasaUseCase) {
        this.nasaUseCase = nasaUseCase;
    }

    private MutableLiveData<Resource<Nasa>> _nasa;
    public LiveData<Resource<Nasa>> nasa = _nasa;

    public void getNasa() {

    }
}
