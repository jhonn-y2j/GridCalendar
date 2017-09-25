package jhonn_aj.gridcalendar.data.model;

import java.util.ArrayList;
import java.util.List;

import jhonn_aj.gridcalendar.data.model.Day;

/**
 * Created by jhonn_aj on 23/09/2017.
 */

public class Week {

    private String name;
    private List<Day> days = new ArrayList<>();

    public Week(String name, List<Day> days) {
        this.name = name;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }
}
