package com.jassonkm.nasapp.ui.view.fragment;

import static com.jassonkm.nasapp.utils.Constants.ENDPOINT_CO2;
import static com.jassonkm.nasapp.utils.Constants.ENDPOINT_N2O;
import static com.jassonkm.nasapp.utils.Constants.ENDPOINT_SF6;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.jassonkm.nasapp.databinding.FragmentHomeBinding;
import com.jassonkm.nasapp.ui.viewmodel.HomeViewModel;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        setObservers();
    }

    private void setObservers() {
        requireActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                homeViewModel.getHomeCO2(ENDPOINT_CO2).observe(getViewLifecycleOwner(), homeCO2 -> {
                    try {
                        for (int i = 0; i < homeCO2.size(); i++) {
                            String levelCO2 = "En "+ homeCO2.get(i).getYear() + " " + homeCO2.get(i).getMeasurement() + " " + homeCO2.get(i).getUnit();
                            binding.textViewLevel.setText(levelCO2);
                        }
                    } catch (Exception exception) {
                        Toast.makeText(requireContext(), "Sin conexión a Internet", Toast.LENGTH_SHORT).show();
                    }
                });

                homeViewModel.getHomeN2O(ENDPOINT_N2O).observe(getViewLifecycleOwner(), homeN20 -> {
                    try {
                        for (int i = 0; i < homeN20.size(); i++) {
                            String levelN20 = "En "+ homeN20.get(i).getYear() + " " + homeN20.get(i).getMeasurement() + " " + homeN20.get(i).getUnit();
                            binding.textViewNitrato.setText(levelN20);
                        }
                    } catch (Exception exception) {
                        Toast.makeText(requireContext(), "Sin conexión a Internet", Toast.LENGTH_SHORT).show();
                    }
                });

                homeViewModel.getHomeSF6(ENDPOINT_SF6).observe(getViewLifecycleOwner(), homeSF6 -> {
                    try {
                        for (int i = 0; i < homeSF6.size(); i++) {
                            String levelSF6 = "En "+ homeSF6.get(i).getYear() + " " + homeSF6.get(i).getMeasurement() + " " + homeSF6.get(i).getUnit();
                            binding.textViewAzufre.setText(levelSF6);
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