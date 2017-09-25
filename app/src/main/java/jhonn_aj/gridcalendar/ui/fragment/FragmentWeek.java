package jhonn_aj.gridcalendar.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jhonn_aj.gridcalendar.R;
import jhonn_aj.gridcalendar.data.model.Day;
import jhonn_aj.gridcalendar.data.model.Week;
import jhonn_aj.gridcalendar.ui.activity.MainActivity;
import jhonn_aj.gridcalendar.ui.adapter.WeekAdapter;
import jhonn_aj.gridcalendar.util.Constans;

/**
 * Created by jhonn_aj on 23/09/2017.
 */

public class FragmentWeek extends Fragment implements WeekAdapter.OnWeekToDayListener{

    @BindView(R.id.tviWeek) TextView tviWeek;
    @BindView(R.id.rviWeek) RecyclerView rviWeek;

    private WeekAdapter adapter;
    private List<Week> weeks = new ArrayList<>();
    public static int position = 0;

    public static FragmentWeek newInstance(){
        return new FragmentWeek();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_week, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initUi();
        initArray();
        loadData();
    }

    private void initUi(){
        rviWeek.setLayoutManager(new GridLayoutManager(getActivity(), 3));
    }

    private void initArray(){
        List<Day> days = new ArrayList<>();
        days.add(new Day("miércoles", 28, 1, 1));
        days.add(new Day("jueves", 29, 2, 1));
        days.add(new Day("viernes", 30, 1, 1));
        days.add(new Day("sábado", 01, 3, 1));
        days.add(new Day("domingo", 02, 2, 1));
        days.add(new Day("lunes", 03, 2, 1));
        days.add(new Day("martes", 04, 1, 1));

        weeks.add(new Week("SEMANA 1", days));

        List<Day> days1 = new ArrayList<>();
        days1.add(new Day("miércoles", 05, 1, 1));
        days1.add(new Day("jueves", 6, 1, 1));
        days1.add(new Day("viernes", 7, 1, 1));
        days1.add(new Day("sábado", 8, 3, 1));
        days1.add(new Day("domingo", 9, 2, 1));
        days1.add(new Day("lunes", 10, 3, 1));
        days1.add(new Day("martes", 11, 3, 1));

        weeks.add(new Week("SEMANA 2", days1));

        List<Day> days2 = new ArrayList<>();
        days2.add(new Day("miércoles", 12, 3, 1));
        days2.add(new Day("jueves", 13, 1, 1));
        days2.add(new Day("viernes", 14, 2, 1));
        days2.add(new Day("sábado", 15, 3, 1));
        days2.add(new Day("domingo", 16, 2, 1));
        days2.add(new Day("lunes", 17, 1, 1));
        days2.add(new Day("martes", 18, 3, 1));

        weeks.add(new Week("SEMANA 3", days2));

    }

    private void loadData(){
        adapter = new WeekAdapter(getActivity());
        adapter.setListener(this);
        rviWeek.setAdapter(adapter);

        //load default first week
        if (weeks.size() > 0){
            adapter.setWeeks(weekToDays(position));
        }
    }

    private List<Day> weekToDays(int position){
        List<Day> days = weeks.get(position).getDays();
        tviWeek.setText(weeks.get(position).getName());
        if (days.size() % 7 == 0){
            Day aux = days.get(days.size() - 1);
            days.remove(aux);
            days.add(new Day(null, 0, 0, 2));
            days.add(aux);
            days.add(new Day(null, 0, 0, 3));
        }
        return days;
    }

    @Override
    public void weekToDayClick(Object o) {
        if (o != null){
            // next Fragment
            Day day = (Day) o;
            if (day.getMode() == 1 && day.getStatus() == 2){
                MainActivity.mViewPager.setCurrentItem(Constans.FRAGMENT_HOUR);
            }
        }
    }

    @Override
    public void backWeekToDay(View v) {
        position --;
        if (position < 0) position = 0;
        else adapter.setWeeks(weekToDays(position));
        if (position == 0){
            ImageView back = (ImageView) v;
            back.setAlpha(0.5f);
        }
    }

    @Override
    public void nextWeekToDay(View v, View v1) {
        position ++;
        if (position >= weeks.size()) position = weeks.size() - 1;
        else adapter.setWeeks(weekToDays(position));
        if (position == weeks.size() - 1){
            ImageView next = (ImageView) v;
            next.setAlpha(0.5f);
        }
        // se pasa a la siguiente semana habilitamos el regreso
        if (position != 0){
            ImageView back = (ImageView) v1;
            back.setAlpha(1.0f);
        }
    }

}
