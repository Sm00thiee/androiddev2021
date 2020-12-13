package vn.usth.edu.usthweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class WeatherActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Log.i("App","onCreate");


    }
    @Override
    public void onStart(){
        super.onStart();
        Log.i("App","onStart");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.i("App","onResume");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.i("App","onPause");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.i("App","onStop");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i("App","onDestroy");
    }
}