package ru.tatarchuk.weather.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.IdRes;
import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import ru.tatarchuk.weather.R;
import ru.tatarchuk.weather.ui.fragment.SearchFragment;
import ru.tatarchuk.weather.ui.fragment.SettingsFragment;
import ru.tatarchuk.weather.ui.fragment.WeatherFragment;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;
import static ru.tatarchuk.weather.ui.activity.MainActivity.ScreenType.SEARCH;
import static ru.tatarchuk.weather.ui.activity.MainActivity.ScreenType.SETTINGS;
import static ru.tatarchuk.weather.ui.activity.MainActivity.ScreenType.WEATHER;


public class MainActivity extends AppCompatActivity {

    private final static int PAGE_COUNT = 3;
    private final static String KEY_POSITION = "position";

    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int position = savedInstanceState != null
                ? savedInstanceState.getInt(KEY_POSITION, WEATHER) : WEATHER;
        setUpViewPager(position);
        setUpBottomNavigation(position);

       // bottomNavigationView.getMenu().getItem(1).setIcon(R.drawable.stub);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt(KEY_POSITION, viewPager.getCurrentItem());
    }

    private void setUpBottomNavigation(int position) {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(screenTypeToIdRes(position));
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            viewPager.setCurrentItem(resIdToType(item.getItemId()), false);
            return true;
        });
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setUpViewPager(int position) {
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(),
                BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT));
        viewPager.setCurrentItem(position, false);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setOnTouchListener((v, event) -> true); // disable swipe
    }

    @IntDef({SEARCH, WEATHER, SETTINGS})
    @Retention(RetentionPolicy.SOURCE)
    @interface ScreenType {
        int SEARCH = 0;
        int WEATHER = 1;
        int SETTINGS = 2;
    }

    @IdRes
    private int screenTypeToIdRes(@ScreenType int type) {
        switch (type) {
            case SEARCH:
                return R.id.action_search;
            case WEATHER:
                return R.id.action_weather;
            case SETTINGS:
                return R.id.action_settings;
            default:
                throw new IllegalArgumentException("WTF???");
        }
    }

    @ScreenType
    private int resIdToType(@IdRes int resId) {
        switch (resId) {
            case R.id.action_search:
                return SEARCH;
            case R.id.action_weather:
                return WEATHER;
            case R.id.action_settings:
                return SETTINGS;
            default:
                throw new IllegalArgumentException("WTF???");

        }
    }

    @NonNull
    private Fragment createFragmentByPosition(int position) {
        switch (position) {
            case SEARCH:
                return SearchFragment.newInstance();
            case WEATHER:
                return WeatherFragment.newInstance();
            case SETTINGS:
                return SettingsFragment.newInstance();
            default:
                throw new IllegalArgumentException("WTF!!!");
        }
    }

    private final class PagerAdapter extends FragmentStatePagerAdapter {

        public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return createFragmentByPosition(position);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT - 1;
        }
    }

//    public static void animate(Drawable d) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && d instanceof AnimatedVectorDrawable) {
//            AnimatedVectorDrawable avd = (AnimatedVectorDrawable) d;
//            avd.start();
//        } else if (d instanceof AnimatedVectorDrawableCompat) {
//            AnimatedVectorDrawableCompat avd = (AnimatedVectorDrawableCompat) d;
//            avd.start();
//        }
//    }
}
