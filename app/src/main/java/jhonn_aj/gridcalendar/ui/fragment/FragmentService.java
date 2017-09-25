package jhonn_aj.gridcalendar.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import jhonn_aj.gridcalendar.R;
import jhonn_aj.gridcalendar.ui.activity.MainActivity;
import jhonn_aj.gridcalendar.util.Constans;

/**
 * Created by jhonn_aj on 23/09/2017.
 */

public class FragmentService extends Fragment {

    private Unbinder unbinder;

    public static FragmentService newInstance(){
        return new FragmentService();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_service, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;

    }

    @OnClick(R.id.button)
    public void handleNext(){
        MainActivity.mViewPager.setCurrentItem(Constans.FRAGMENT_WEEK);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
