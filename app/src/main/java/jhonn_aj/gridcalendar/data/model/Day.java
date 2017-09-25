package jhonn_aj.gridcalendar.data.model;

/**
 * Created by jhonn_aj on 23/09/2017.
 */

public class Day {

    private String weekToDay;
    private int day;
    private int status;
    private int mode; // 1 normal 2 back 3 next

    public Day(String weekToDay, int day, int status, int mode) {
        this.weekToDay = weekToDay;
        this.day = day;
        this.status = status;
        this.mode = mode;
    }

    public String getWeekToDay() {
        return weekToDay;
    }

    public void setWeekToDay(String weekToDay) {
        this.weekToDay = weekToDay;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }
}
