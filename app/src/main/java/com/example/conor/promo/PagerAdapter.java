package com.example.conor.promo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.conor.promo.Fragments.PromoFrag;


/**
 * Created by conor on 06/04/2016.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(android.support.v4.app.FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) { // create corresponding fragment object

        switch (position){
            case 0:
                return new PromoFrag();
            case 1:
                return new PromoFrag();
            case 2:
                return new PromoFrag();
            case 3:
                return new PromoFrag();
            case 4:
                return new PromoFrag();
            case 5:
                return new PromoFrag();
            case 6:
                return new PromoFrag();
            case 7:
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {  // This will generate the number of views for fragments
        return 7;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Mon";
            case 1:
                return "Tue";
            case 2:
                return "Wed";
            case 3:
                return "Thu";
            case 4:
                return "Fri";
            case 5:
                return "Sat";
            case 6:
                return "Sun";
        }

        return null;
    }
}
