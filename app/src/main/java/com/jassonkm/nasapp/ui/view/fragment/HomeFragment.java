package com.jassonkm.nasapp.ui.view.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.jassonkm.nasapp.R;
import com.jassonkm.nasapp.databinding.FragmentHomeBinding;
import com.jassonkm.nasapp.ui.adapter.PagerAdapter;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private MenuItem previewBottomSelected;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpBottomNavigationBar();
        setupViewPager(getPagerAdapter());
    }

    private PagerAdapter getPagerAdapter() {
        PagerAdapter pagerAdapter = new PagerAdapter(getActivity().getSupportFragmentManager());
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
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            @Override
            public void onPageScrollStateChanged(int state) {}

            @Override
            public void onPageSelected(int position) {
                if (previewBottomSelected != null) {
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
        binding.bottomNavigation.setOnNavigationItemSelectedListener( item -> {
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
            }
            return false;
        });
    }
}