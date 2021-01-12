package vn.edu.usth.weather;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeatherAndForecastFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeatherAndForecastFragment extends Fragment {
    private static final String ARG_PARAM1 = "Hanoi";

    private String city;

    public WeatherAndForecastFragment() {
        // Required empty public constructor
    }

    public static WeatherAndForecastFragment newInstance(String city) {
        WeatherAndForecastFragment fragment = new WeatherAndForecastFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, city);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            city = getArguments().getString(ARG_PARAM1);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_and_forecast, container, false);

//        TextView cityName = view.findViewById(R.id.city_name);
//        cityName.setText(city);

        return view;
    }
}