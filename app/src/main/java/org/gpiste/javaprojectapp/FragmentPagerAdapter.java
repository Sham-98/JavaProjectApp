package org.gpiste.javaprojectapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.gpiste.javaprojectapp.fragments.BattleFragment;
import org.gpiste.javaprojectapp.fragments.HomeFragment;
import org.gpiste.javaprojectapp.fragments.TrainingFragment;

public class FragmentPagerAdapter extends FragmentStateAdapter {

    public FragmentPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new TrainingFragment();
            case 2:
                return new BattleFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
