package com.example.conor.promo;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.example.conor.promo.SlidingTabs.SlidingTabLayout;

public class PromoSwipeMain extends FragmentActivity {

    // Declare UI elements
    ViewPager viewPager;
    SlidingTabLayout slidingTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo_swipe_main);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(pagerAdapter);

        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tab);
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setViewPager(viewPager);

        slidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return Color.parseColor("#FFFFFF");
            }

        });

    }
}
