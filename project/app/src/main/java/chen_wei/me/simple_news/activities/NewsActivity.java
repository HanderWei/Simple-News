package chen_wei.me.simple_news.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import chen_wei.me.simple_news.R;
import chen_wei.me.simple_news.fragments.BaiduFragment;
import chen_wei.me.simple_news.fragments.NetEasyFragment;
import chen_wei.me.simple_news.fragments.TencentFragment;

/**
 * Created by Hander on 15/6/3.
 */
public class NewsActivity extends BaseDrawerActivity {

    Fragment currentFragment;


    Drawer mDrawer;

    @Override
    public void init() {
        mDrawer = new DrawerBuilder(this)
                .withActivity(this)
                .withToolbar(mToolbar)
                .withDrawerWidthPx(dpToPx(250))
                .withDisplayBelowToolbar(true)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(
                        mNetEasySection.withName(R.string.net_easy)
                        , mBaiduSection.withName(R.string.baidu)
                        , mTencentSection.withName(R.string.tencent))
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(AdapterView<?> adapterView, View view, int i, long l,
                                               IDrawerItem iDrawerItem) {
                        switch (i) {
                            case 0:
                                if (null == mNetEasyFragment) {
                                    mNetEasyFragment = new NetEasyFragment();
                                }
                                switchFragment(mNetEasyFragment);
                                break;
                            case 1:
                                if (null == mBaiduFragment) {
                                    mBaiduFragment = new BaiduFragment();
                                }
                                switchFragment(mBaiduFragment);
                                break;
                            case 2:
                                if (null == mTencentFramgment) {
                                    mTencentFramgment = new TencentFragment();
                                }
                                switchFragment(mTencentFramgment);
                                break;
                        }
                        return false;
                    }
                })
                .withStickyDrawerItems(footItems)
                .withSelectedItem(0)
                .build();
        mDrawer.getActionBarDrawerToggle()
               .setDrawerIndicatorEnabled(true);
        mDrawer.setSelection(mNetEasySection);

        if (null == mNetEasyFragment) {
            mNetEasyFragment = new NetEasyFragment();
        }
        currentFragment = mNetEasyFragment;

        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frame_container, currentFragment);
        ft.commit();
    }

    public void switchFragment(Fragment to) {
        if (currentFragment != to) {
            FragmentTransaction ft = fm.beginTransaction();
            ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            if (!to.isAdded()) {
                ft.hide(currentFragment)
                  .add(R.id.frame_container, to)
                  .commit();
            } else {
                ft.hide(currentFragment)
                  .show(to)
                  .commit();
            }
            currentFragment = to;
        }
    }
}
