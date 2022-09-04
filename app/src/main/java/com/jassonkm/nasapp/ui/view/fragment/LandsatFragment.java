package com.jassonkm.nasapp.ui.view.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.jassonkm.nasapp.R;
import com.jassonkm.nasapp.databinding.FragmentLandsatBinding;
import com.jassonkm.nasapp.ui.viewmodel.LandsatViewModel;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LandsatFragment extends Fragment {

    private FragmentLandsatBinding binding;
    private LandsatViewModel landsatViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLandsatBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        landsatViewModel = new ViewModelProvider(this).get(LandsatViewModel.class);
        onQuery();
    }

    private void onQuery() {
        binding.buttonSearch.setOnClickListener(view -> {
            setObservers();
        });
    }

    private void setObservers() {
        requireActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String lat = binding.editTextLat.getText().toString();
                String lon = binding.editTextLon.getText().toString();
                String date = binding.editTextDate.getText().toString();

                if (!lat.isEmpty() && !lon.isEmpty() && !date.isEmpty()) {
                    landsatViewModel.getLandsat(lon, lat, date).observe(getViewLifecycleOwner(), landsat -> {
                        try {
                            Bitmap bitmap = BitmapFactory.decodeFile(landsat.getUrl());
                            binding.imageViewUrl.setImageBitmap(bitmap);
                        }catch (Exception exception) {
                            Log.e("Error", "Bitmap: "+exception.getMessage());
                        }
                    });
                } else {
                    Toast.makeText(requireContext(), "Ningun Campo puede estar vacio", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}