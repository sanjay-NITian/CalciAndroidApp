package com.example.calci.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.calci.fragments.AreaFragment;
import com.example.calci.fragments.DataFragment;
import com.example.calci.fragments.LengthFragment;
import com.example.calci.fragments.MassFragment;
import com.example.calci.fragments.SpeedFragment;
import com.example.calci.fragments.TemperatureFragment;
import com.example.calci.fragments.TimeFragment;
import com.example.calci.fragments.VolumeFragment;

public class FragmentAdapter extends FragmentPagerAdapter {
    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AreaFragment();
            case 1:
                return new LengthFragment();
            case 2:
                return new TemperatureFragment();
            case 3:
                return new VolumeFragment();
            case 4:
                return new MassFragment();
            case 5:
                return new DataFragment();
            case 6:
                return new SpeedFragment();
            case 7:
                return new TimeFragment();
            default:
                return new AreaFragment();
        }
    }

    @Override
    public int getCount() {
        return 8;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        switch (position) {
            case 0:
                title = "Area";
                break;
            case 1:
                title = "Length";
                break;
            case 2:
                title = "Temperature";
                break;
            case 3:
                title = "Volume";
                break;
            case 4:
                title = "Mass";
                break;
            case 5:
                title = "Data";
                break;
            case 6:
                title = "Speed";
                break;
            case 7:
                title = "Time";
                break;
            default:
                title = "Default";
        }
        return title;
    }
}
