package com.example.Gads2020Project;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    private int tabNumbers;
    public PagerAdapter(@NonNull FragmentManager fm, int behaviorResumeOnlyCurrentFragment, int tabs) {
        super(fm);
        this.tabNumbers = tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new HoursFragment();
           case 1:
                return new SkillsFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return tabNumbers;
    }
}
