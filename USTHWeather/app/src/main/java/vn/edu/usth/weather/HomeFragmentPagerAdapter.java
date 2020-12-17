package vn.edu.usth.weather;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
    private static final int PAGE_COUNT = 3;
    private final String[] titles = new String[] { "Hanoi", "Paris", "Toulouse" };

    public HomeFragmentPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT; // number of pages for a ViewPager
    }
    @Override
    public WeatherAndForecastFragment getItem(int page) {
        switch (page) {
            case 0: return WeatherAndForecastFragment.newInstance(titles[0]);
            case 1: return WeatherAndForecastFragment.newInstance(titles[1]);
            case 2: return WeatherAndForecastFragment.newInstance(titles[2]);
            default: return new WeatherAndForecastFragment();
        }
    }
    @Override
    public CharSequence getPageTitle(int page) {
        return titles[page];
    }
}