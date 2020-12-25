package vn.edu.usth.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class WeatherActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    private void copyFileToExternalStorage(int resourceId, String resourceName) {
        try {
            File file = new File(getExternalFilesDir(null), resourceName);
            InputStream in = getApplicationContext().getResources().openRawResource(resourceId);
            OutputStream out = new FileOutputStream(file);
            byte[] buff = new byte[1024 * 2];
            int read = 0;
            try {
                while ((read = in.read(buff)) > 0) {
                    out.write(buff, 0, read);
                }
            }
            finally {
                in.close();
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
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

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(pager);


        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mediaPlayer.start();
        copyFileToExternalStorage(R.raw.music, "music.mp3");
        Log.i("Weether", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
        Log.i("Weether", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
        Log.i("Weether", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
        Log.i("Weether","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Weether", "onDestroy");
    }
}
