package com.jassonkm.nasapp.ui.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.MenuItem;
import com.jassonkm.nasapp.R;
import com.jassonkm.nasapp.databinding.ActivityNasaBinding;
import com.jassonkm.nasapp.ui.view.adapter.PagerAdapter;
import com.jassonkm.nasapp.ui.view.fragment.HomeFragment;
import com.jassonkm.nasapp.ui.view.fragment.LandsatFragment;
import com.jassonkm.nasapp.ui.view.fragment.ReviewFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NasaActivity extends AppCompatActivity {

    private ActivityNasaBinding binding;
    private MenuItem previewBottomSelected = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNasaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setUpBottomNavigationBar();
        setupViewPager(getPagerAdapter());
    }

    private PagerAdapter getPagerAdapter() {
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new HomeFragment());
        pagerAdapter.addFragment(new LandsatFragment());
        pagerAdapter.addFragment(new ReviewFragment());
        return pagerAdapter;
    }

    private void setupViewPager(PagerAdapter pagerAdapter) {
        binding.viewPager.setAdapter(pagerAdapter);
        binding.viewPager.setOffscreenPageLimit(pagerAdapter.getCount());
        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }

            @Override
            public void onPageSelected(int position) {
                if (previewBottomSelected == null) {
                    binding.bottomNavigation.getMenu().getItem(0).setChecked(false);
                } else {
                    previewBottomSelected.setChecked(false);
                }
                binding.bottomNavigation.getMenu().getItem(position).setChecked(true);
                previewBottomSelected = binding.bottomNavigation.getMenu().getItem(position);
            }
        });
    }

    private void setUpBottomNavigationBar() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_nav_home : {
                    binding.viewPager.setCurrentItem(0);
                    return true;
                }
                case R.id.bottom_nav_landsat: {
                    binding.viewPager.setCurrentItem(1);
                    return true;
                }
                case R.id.bottom_nav_review: {
                    binding.viewPager.setCurrentItem(2);
                    return true;
                }
                default:
                    return false;
            }
        });
    }
}