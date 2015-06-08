package chen_wei.me.simple_news.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

import chen_wei.me.simple_news.R;

/**
 * Created by Hander on 15/6/1.
 */
public class BaiduFragment extends Fragment {

    ViewPager            mPager;
    PagerSlidingTabStrip mTabs;

    @Override
    public void onResume() {
        super.onResume();
//        ((MaterialNavigationDrawer) getActivity()).changeToolbarColor(R.color.baidu_colorPrimary,
//                                                                      R.color.baidu_colorPrimaryDark);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_baidu, container, false);
        mTabs = (PagerSlidingTabStrip) rootView.findViewById(R.id.baidu_tabs);
        mPager = (ViewPager) rootView.findViewById(R.id.baidu_pager);
        mPager.setAdapter(new NetEasyFragmentAdapter(getFragmentManager()));
        mTabs.setViewPager(mPager);
        return rootView;
    }

    class NetEasyFragmentAdapter extends FragmentPagerAdapter {

        String[] newsCategories;

        public NetEasyFragmentAdapter(FragmentManager fm) {
            super(fm);
            newsCategories = getResources().getStringArray(R.array.dummy);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return newsCategories[position];
        }

        @Override
        public Fragment getItem(int position) {
            return DummyFragment.newInstance();
        }

        @Override
        public int getCount() {
            return newsCategories.length;
        }
    }
}
