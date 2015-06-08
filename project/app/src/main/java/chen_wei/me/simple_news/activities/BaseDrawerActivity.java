package chen_wei.me.simple_news.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;

import chen_wei.me.simple_news.R;
import chen_wei.me.simple_news.fragments.BaiduFragment;
import chen_wei.me.simple_news.fragments.NetEasyFragment;
import chen_wei.me.simple_news.fragments.TencentFragment;
import chen_wei.me.simple_news.utils.ScreenUtils;

/**
 * Created by Hander on 15/6/3.
 */
public abstract class BaseDrawerActivity extends AppCompatActivity {

    Context mContext;

    Toolbar           mToolbar;
    PrimaryDrawerItem mNetEasySection;
    PrimaryDrawerItem mBaiduSection;
    PrimaryDrawerItem mTencentSection;

    FrameLayout         mContainer;
    FragmentManager     fm;
    NetEasyFragment     mNetEasyFragment;
    BaiduFragment       mBaiduFragment;
    TencentFragment     mTencentFramgment;
    ArrayList<IDrawerItem> footItems = new ArrayList<>();
    PrimaryDrawerItem      settings  = new PrimaryDrawerItem();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        fm = getSupportFragmentManager();

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);


        mNetEasySection = new PrimaryDrawerItem();
        mNetEasySection.setIcon(getResources().getDrawable(R.drawable.ic_n));
        mBaiduSection = new PrimaryDrawerItem();
        mBaiduSection.setIcon(getResources().getDrawable(R.drawable.ic_b));
        mTencentSection = new PrimaryDrawerItem();
        mTencentSection.setIcon(getResources().getDrawable(R.drawable.ic_t));

        mContainer = (FrameLayout) findViewById(R.id.frame_container);


        settings.withName(R.string.settings);
        settings.setIcon(getResources().getDrawable(R.drawable.ic_settings));
        footItems.add(settings);

        init();
    }

    public abstract void init();

    public int dpToPx(int dp) {
        return ScreenUtils.convertDIPToPixels(mContext, dp);
    }
}
