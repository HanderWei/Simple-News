package chen_wei.me.simple_news;

import android.os.Bundle;

import chen_wei.me.simple_news.fragments.DummyFragment;
import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.elements.MaterialSection;


public class MainActivity extends MaterialNavigationDrawer {


    @Override
    public void init(Bundle bundle) {
        setDrawerHeaderImage(R.drawable.net_easy_logo);
        MaterialSection netEasySec = newSection(getString(R.string.net_easy), new DummyFragment());
        addSection(netEasySec);
    }
}
