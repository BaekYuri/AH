package com.example.jh.mycalendar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    // Count number of tabs
    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        // Returning the current tabs
        switch (position) {
            case 0:
                CalendarActivity tabFragment1 = new CalendarActivity();
                return tabFragment1;
            case 1:
                ScheduleManagementActivity tabFragment2 = new ScheduleManagementActivity();
                return tabFragment2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}