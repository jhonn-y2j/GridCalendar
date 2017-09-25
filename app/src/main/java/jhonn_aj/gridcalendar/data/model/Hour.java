package jhonn_aj.gridcalendar.data.model;

import java.util.ArrayList;
import java.util.List;

import jhonn_aj.gridcalendar.R;

/**
 * Created by jhonn_aj on 23/09/2017.
 */

public class Hour {

    private int hour;
    private boolean header;
    private int imageHeader;
    private int modeDay; // 1 tomorrow 2 late 3 night
    private int status;

    public static List<Hour> hours;

    static {
        hours = new ArrayList<>();
        hours.add(new Hour(0, true, R.mipmap.ic_launcher, 1, 0));
        hours.add(new Hour(10, false, 0, 1, 0));
        hours.add(new Hour(11, false, 0, 1, 0));
        hours.add(new Hour(12, false, 0, 1, 1));

        hours.add(new Hour(0, true, R.mipmap.ic_launcher, 2, 0));
        hours.add(new Hour(2, false, 0, 2, 0));
        hours.add(new Hour(3, false, 0, 2, 0));
        hours.add(new Hour(4, false, 0, 2, 1));
        hours.add(new Hour(5, false, 0, 2, 0));
        hours.add(new Hour(6, false, 0, 2, 0));

        hours.add(new Hour(0, true, R.mipmap.ic_launcher, 3, 0));
        hours.add(new Hour(7, false, 0, 3, 0));
        hours.add(new Hour(8, false, 0, 3, 0));
        hours.add(new Hour(9, false, 0, 3, 1));
    }

    public Hour(int hour, boolean header, int imageHeader, int modeDay, int status) {
        this.hour = hour;
        this.header = header;
        this.imageHeader = imageHeader;
        this.modeDay = modeDay;
        this.status = status;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public boolean isHeader() {
        return header;
    }

    public void setHeader(boolean header) {
        this.header = header;
    }

    public int getImageHeader() {
        return imageHeader;
    }

    public void setImageHeader(int imageHeader) {
        this.imageHeader = imageHeader;
    }

    public int getModeDay() {
        return modeDay;
    }

    public void setModeDay(int modeDay) {
        this.modeDay = modeDay;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
