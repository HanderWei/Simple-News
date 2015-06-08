package chen_wei.me.simple_news.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Hander on 15/5/31.
 */
public class DummyFragment extends Fragment {

    public static DummyFragment newInstance(){
        DummyFragment fragment = new DummyFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView tv = new TextView(inflater.getContext());
        tv.setText("Dummy Fragment:" + Integer.toHexString(hashCode()));
        tv.setGravity(Gravity.CENTER);
        return tv;
    }
}
