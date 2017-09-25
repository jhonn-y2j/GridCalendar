package jhonn_aj.gridcalendar.ui.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import jhonn_aj.gridcalendar.R;
import jhonn_aj.gridcalendar.ui.adapter.ViewPagerAdapter;
import jhonn_aj.gridcalendar.ui.custom.CIViewPager;

// https://marvelapp.com/930329j/screen/30017090
public class MainActivity extends AppCompatActivity {

    public static CIViewPager mViewPager;
    private View buttonBack;
    private TextView headerPager;
    private int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.viewPager);
        headerPager = findViewById(R.id.header_pager);
        buttonBack = findViewById(R.id.buttonBack);

        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

        // escuchamos el cambio de posicin del viewpager
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                String [] title = getResources().getStringArray(R.array.header_flow_pager);
                headerPager.setText(title[position]);
                pos = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pos > 0 && pos < 4) mViewPager.setCurrentItem(pos - 1);
            }
        });

    }
}
