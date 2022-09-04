package com.jassonkm.nasapp.ui.view.fragment;

import static com.jassonkm.nasapp.utils.Constants.BASE_URL_NASA;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jassonkm.nasapp.R;
import com.jassonkm.nasapp.databinding.FragmentHomeBinding;
import com.jassonkm.nasapp.ui.view.activity.MainActivity;
import com.jassonkm.nasapp.ui.viewmodel.HomeViewModel;

import java.util.Objects;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        loadImage();
        setObservers();

    }

    private void loadImage() {
        Bundle bundle = requireActivity().getIntent().getExtras();
        String imageUrl = bundle.getString("imageUrl");
        Glide.with(requireContext())
                .load(imageUrl)
                .centerCrop()
                .error(R.drawable.ic_launcher_background)
                .into(binding.imageViewEarth);
    }

    private void setObservers() {
        requireActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                homeViewModel.getHome().observe(getViewLifecycleOwner(), home -> {
                    try {
                        for (int i = 0; i < home.size(); i++) {
                            String levelCO2 = "En "+ home.get(i).getYear() + " " + home.get(i).getMeasurement() + " " + home.get(i).getUnit();
                            binding.textViewLevel.setText(levelCO2);
                        }
                    } catch (Exception exception) {
                        Toast.makeText(requireContext(), "Sin conexión a Internet", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        homeViewModel.isLoading.observe(getViewLifecycleOwner(), isLoading -> {
            if (isLoading) {
                binding.progressBar.setVisibility(View.VISIBLE);
            } else {
                binding.progressBar.setVisibility(View.GONE);
            }
        });
    }
}