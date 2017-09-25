package jhonn_aj.gridcalendar.ui.adapter;

import android.content.Context;
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
import jhonn_aj.gridcalendar.ui.fragment.FragmentWeek;
import jhonn_aj.gridcalendar.util.Util;

/**
 * Created by jhonn_aj on 23/09/2017.
 */

public class WeekAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Day> days;
    private Context context;
    private OnWeekToDayListener listener;

    public WeekAdapter(Context context){
        this.days = new ArrayList<>();
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_date, parent, false);
        RecyclerView.ViewHolder vh = new WeekHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof WeekHolder){
            WeekHolder wHolder = (WeekHolder) holder;

            Day day = days.get(position);
            if (day != null){
                wHolder.itemView.setTag(day);

                if (day.getMode() == 1){
                    wHolder.llaDate.setVisibility(View.VISIBLE);
                    wHolder.buttonNext.setVisibility(View.GONE);
                    wHolder.buttonBack.setVisibility(View.GONE);
                    wHolder.tviDay.setText(String.valueOf(Util.numberToDay(day.getDay())));
                    wHolder.tviDayWeek.setText(day.getWeekToDay());

                    if (day.getStatus() == 1){
                        wHolder.llaDate.setBackgroundResource(R.drawable.shape_week_day_black);
                        wHolder.tviDay.setTextColor(context.getResources().getColor(R.color.colorBlack));
                        wHolder.tviDayWeek.setTextColor(context.getResources().getColor(R.color.colorBlack));
                    }else if (day.getStatus() == 2){
                        wHolder.llaDate.setBackgroundResource(R.drawable.shape_week_day_gray);
                        wHolder.tviDay.setTextColor(context.getResources().getColor(R.color.colorGray));
                        wHolder.tviDayWeek.setTextColor(context.getResources().getColor(R.color.colorGray));
                    }else{
                        wHolder.llaDate.setBackgroundResource(R.drawable.shape_week_day_red);
                        wHolder.tviDay.setTextColor(context.getResources().getColor(R.color.colorRed));
                        wHolder.tviDayWeek.setTextColor(context.getResources().getColor(R.color.colorRed));
                    }

                }else if (day.getMode() == 2){
                    wHolder.buttonBack.setVisibility(View.VISIBLE);
                    if (FragmentWeek.position == 0) wHolder.buttonBack.setAlpha(0.5f);
                    else wHolder.buttonBack.setAlpha(1.0f);
                }else if (day.getMode() == 3){
                    wHolder.buttonNext.setVisibility(View.VISIBLE);
                }
            }

        }
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public void setListener(OnWeekToDayListener listener) {
        this.listener = listener;
    }

    public OnWeekToDayListener getListener() {
        return listener;
    }

    public void setWeeks(List<Day> days) {
        this.days = days;
        this.notifyDataSetChanged();
    }

    public class WeekHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.llaDate) View llaDate;
        @BindView(R.id.tviDay) TextView tviDay;
        @BindView(R.id.tviDayWeek) TextView tviDayWeek;
        @BindView(R.id.buttonBack) ImageView buttonBack;
        @BindView(R.id.buttonNext) ImageView buttonNext;

        public WeekHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            init();
        }

        void init(){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Day day = (Day) itemView.getTag();
                    if (day.getMode() == 1){
                        listener.weekToDayClick(day);
                    }
                }
            });


            buttonBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.backWeekToDay(buttonBack);
                }
            });

            buttonNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.nextWeekToDay(buttonNext, buttonBack);
                }
            });
        }
    }

    public interface OnWeekToDayListener{
        void weekToDayClick(Object o);
        void backWeekToDay(View v);
        void nextWeekToDay(View v, View v1);
    }

}
