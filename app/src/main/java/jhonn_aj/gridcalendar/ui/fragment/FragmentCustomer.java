package jhonn_aj.gridcalendar.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jhonn_aj.gridcalendar.R;

/**
 * Created by jhonn_aj on 23/09/2017.
 */

public class FragmentCustomer extends Fragment{

    public static FragmentCustomer newInstance(){
        return new FragmentCustomer();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_service, container, false);
        return view;
    }
}
