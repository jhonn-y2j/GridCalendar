package jhonn_aj.gridcalendar.util;

/**
 * Created by jhonn_aj on 23/09/2017.
 */

public class Util {

    public static String numberToDay(int value){
        if (value < 10) return "0" + String.valueOf(value);
        return String.valueOf(value);
    }

}
