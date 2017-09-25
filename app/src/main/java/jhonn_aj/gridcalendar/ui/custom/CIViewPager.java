package jhonn_aj.gridcalendar.ui.custom;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by jhonn_aj on 23/09/2017.
 */

public class CIViewPager extends ViewPager {

    private boolean enableScroll = false;

    public CIViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return enableScroll && super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return enableScroll && super.onInterceptTouchEvent(ev);
    }
}
