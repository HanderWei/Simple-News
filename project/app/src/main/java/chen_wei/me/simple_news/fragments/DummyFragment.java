package chen_wei.me.simple_news.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Hander on 15/5/31.
 */
public class DummyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView tv = new TextView(inflater.getContext());
        tv.setText("Dummy Fragment:" + Integer.toHexString(hashCode()));
        tv.setGravity(Gravity.CENTER);
        return tv;
    }
}
