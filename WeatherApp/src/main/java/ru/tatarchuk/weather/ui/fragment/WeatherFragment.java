package ru.tatarchuk.weather.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ru.tatarchuk.weather.R;
import ru.tatarchuk.weather.WeatherApp;
import ru.tatarchuk.weather.viewmodel.WeatherViewModel;

/**
 * @author tatarchukilya@gmail.com
 */
public class WeatherFragment extends BaseFragment {

    Pair<Float, Float> Donetsk = new Pair<>(48.302697f, 39.925032f);
    Pair<Float, Float> London = new Pair<>(51.48043852736254f, -0.1387073133762785f);
    Pair<Float, Float> Milan = new Pair<>(45.466805855344084f, 9.182193282875776f);

    private WeatherViewModel viewModel;

    public static WeatherFragment newInstance() {
        return new WeatherFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity(), getComponent()
                .getWeatherViewModelFactory()).get(WeatherViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weather, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        view.findViewById(R.id.current).setOnClickListener(v ->
                viewModel.getCurrent(48.302697f, 39.925032f));
        view.findViewById(R.id.hourly_forecast).setOnClickListener(v ->
                viewModel.getHourly(48.302697f, 39.925032f));
        view.findViewById(R.id.call).setOnClickListener(v ->
                viewModel.call(London.first, London.second));
        view.findViewById(R.id.daily).setOnClickListener(v ->
                viewModel.getDaily(Milan.first, Milan.second));
    }
}
