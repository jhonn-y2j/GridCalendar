package jhonn_aj.gridcalendar.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import jhonn_aj.gridcalendar.ui.fragment.FragmentCustomer;
import jhonn_aj.gridcalendar.ui.fragment.FragmentHour;
import jhonn_aj.gridcalendar.ui.fragment.FragmentService;
import jhonn_aj.gridcalendar.ui.fragment.FragmentWeek;
import jhonn_aj.gridcalendar.util.Constans;

/**
 * Created by jhonn_aj on 23/09/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter{

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case Constans.FRAGMENT_SERVICE: fragment = FragmentService.newInstance(); break;
            case Constans.FRAGMENT_WEEK: fragment = FragmentWeek.newInstance(); break;
            case Constans.FRAGMENT_HOUR: fragment = FragmentHour.newInstance(); break;
            case Constans.FRAGMENT_CUSTOMER: fragment = FragmentCustomer.newInstance(); break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
