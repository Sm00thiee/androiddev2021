package vn.edu.usth.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import vn.edu.usth.weather.HomeFragmentPagerAdapter;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Log.d("Weether", "onCreate");
        PagerAdapter adapter = new HomeFragmentPagerAdapter(getSupportFragmentManager(), 1);
        ViewPager pager = findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);
        pager.setCurrentItem(1);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Weether", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Weether", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Weether", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Weether","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Weether", "onDestroy");
    }
}
