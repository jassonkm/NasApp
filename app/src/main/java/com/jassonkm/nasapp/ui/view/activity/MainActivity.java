package com.jassonkm.nasapp.ui.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.jassonkm.nasapp.R;
import com.jassonkm.nasapp.databinding.ActivityMainBinding;
import com.jassonkm.nasapp.ui.viewmodel.NasaViewModel;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private NasaViewModel nasaViewModel;
    private String imageUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        nasaViewModel = new ViewModelProvider(this).get(NasaViewModel.class);
        setObservers();

        binding.button.setOnClickListener(view -> {
            Intent intent = new Intent(this, NasaActivity.class);
            intent.putExtra("imageUrl", imageUrl);
            startActivity(intent);
        });
    }

    private void setObservers() {
        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                nasaViewModel.getNasa().observe(MainActivity.this, nasa -> {
                    try {
                        imageUrl = nasa.getImageUrl();
                        binding.textViewTitle.setText(nasa.getTitle());
                        binding.textViewMetadata.setText(nasa.getMetadata());
                        Glide.with(getApplication())
                                .load(nasa.getImage())
                                .centerCrop()
                                .error(R.drawable.ic_launcher_background)
                                .into(binding.imageView);
                    } catch (Exception exception) {
                        Toast.makeText(MainActivity.this, "Sin conexión a Internet", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        nasaViewModel.isLoading.observe(this, isLoading -> {
            if (isLoading) {
                binding.progressBar.setVisibility(View.VISIBLE);
            } else {
                binding.progressBar.setVisibility(View.GONE);
            }
        });
    }
}