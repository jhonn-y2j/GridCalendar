package jhonn_aj.gridcalendar.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jhonn_aj.gridcalendar.ui.activity.MainActivity;
import jhonn_aj.gridcalendar.R;
import jhonn_aj.gridcalendar.ui.adapter.HourAdapter;
import jhonn_aj.gridcalendar.data.model.Hour;
import jhonn_aj.gridcalendar.util.Constans;

/**
 * Created by jhonn_aj on 23/09/2017.
 */

public class FragmentHour extends Fragment implements HourAdapter.OnHourListener{

    @BindView(R.id.rviHour) RecyclerView rviHour;

    private List<Hour> hours = Hour.hours;
    private HourAdapter adapter;

    public static FragmentHour newInstance(){
        return new FragmentHour();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hour, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initUI();
        loadData();

    }

    private void initUI(){
        rviHour.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void loadData(){
        adapter = new HourAdapter(getActivity());
        adapter.setListener(this);
        rviHour.setAdapter(adapter);

        adapter.setHours(hours);
    }

    @Override
    public void hourListener(Object o) {
        if (o != null){
            Hour h = (Hour) o;
            if (!h.isHeader()) {
                // next fragment
                MainActivity.mViewPager.setCurrentItem(Constans.FRAGMENT_CUSTOMER);
            }
        }
    }
}
