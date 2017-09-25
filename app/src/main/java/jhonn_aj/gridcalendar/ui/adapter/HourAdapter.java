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
import jhonn_aj.gridcalendar.data.model.Hour;

/**
 * Created by jhonn_aj on 23/09/2017.
 */

public class HourAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Hour> hours;
    private Context context;
    private OnHourListener listener;

    public HourAdapter(Context context){
        this.hours = new ArrayList<>();
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_hour, parent, false);
        RecyclerView.ViewHolder vh = new HourHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HourHolder){
            HourHolder hourHolder = (HourHolder) holder;
            Hour hour = hours.get(position);
            if (hour != null){

                hourHolder.itemView.setTag(hour);

                if (hour.isHeader()){
                    hourHolder.imgHour.setVisibility(View.VISIBLE);
                    hourHolder.tviHour.setVisibility(View.GONE);
                }else {
                    hourHolder.tviHour.setVisibility(View.VISIBLE);
                    hourHolder.imgHour.setVisibility(View.GONE);
                }

                    if (hour.getStatus() == 1){
                        hourHolder.tviHour.setTextColor(context.getResources().getColor((R.color.colorRed)));
                    }else if(hour.getStatus() == 0){
                        hourHolder.tviHour.setTextColor(context.getResources().getColor(R.color.colorBlack));
                    }

                    if (hour.getModeDay() == 1)
                        if (hour.getHour() == 12) hourHolder.tviHour.setText(String.valueOf(hour.getHour()) + context.getString(R.string.format_hour_late));
                        else hourHolder.tviHour.setText(String.valueOf(hour.getHour()) + context.getString(R.string.format_hour_day));
                    else
                        hourHolder.tviHour.setText(String.valueOf(hour.getHour()) + context.getString(R.string.format_hour_night));
                    }
            }
        }

    @Override
    public int getItemCount() {
        return hours.size();
    }

    public void setHours(List<Hour> hours) {
        this.hours = hours;
        this.notifyDataSetChanged();
    }

    public void setListener(OnHourListener listener) {
        this.listener = listener;
    }

    public OnHourListener getListener() {
        return listener;
    }

    public class HourHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tviHour) TextView tviHour;
        @BindView(R.id.imgHour) ImageView imgHour;

        public HourHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            init();
        }

        void init(){

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Hour h = (Hour) itemView.getTag();
                    listener.hourListener(h);
                }
            });

        }

    }

    public interface OnHourListener{
        void hourListener(Object o);
    }

}
