package com.jassonkm.nasapp.ui.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.jassonkm.nasapp.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHomeBinding binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}