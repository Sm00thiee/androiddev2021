package vn.edu.usth.weather;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

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
    private Toolbar mTopToolbar;

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
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
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

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_refresh:
                Toast toast = Toast.makeText(this, "Refresh", Toast.LENGTH_SHORT);
                toast.show();
                super.onRestart();

            case R.id.action_setting:
                Intent intent = new Intent(this, PrefActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
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

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
