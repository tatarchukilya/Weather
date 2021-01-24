package ru.tatarchuk.weather.ui.fragment;

import androidx.fragment.app.Fragment;

import ru.tatarchuk.weather.WeatherApp;
import ru.tatarchuk.weather.di.component.AppComponent;

/**
 * @author tatarchukilya@gmail.com
 */
public class BaseFragment extends Fragment {

    protected AppComponent getComponent() {
        return ((WeatherApp) requireActivity().getApplication()).getAppComponent();
    }
}
