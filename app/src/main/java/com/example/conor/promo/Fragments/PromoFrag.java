package com.example.conor.promo.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.conor.promo.CustomAdapter;
import com.example.conor.promo.Promotion;
import com.example.conor.promo.R;

import java.util.ArrayList;

/**
 * Created by conor on 23/10/2016.
 */
public class PromoFrag extends Fragment {

    // Declare UI elements
    ListView listView;
    CustomAdapter customAdapter;

    // Declare data structures
    ArrayList<Promotion> promotionList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.promo_frag_layout, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();

        // DUMMY OBJECT
        Promotion dummyPromotion1 = new Promotion("Diceys $2 drinks!");
        Promotion dummyPromotion2 = new Promotion("Coppers is shite!");
        Promotion dummyPromotion3 = new Promotion("The George tho ;)");

        promotionList = new ArrayList<Promotion>();
        promotionList.add(dummyPromotion1);
        promotionList.add(dummyPromotion2);
        promotionList.add(dummyPromotion3);



        listView = (ListView) getView().findViewById(R.id.listView);
        customAdapter = new CustomAdapter(getActivity(), promotionList);
        listView.setAdapter(customAdapter);
    }
}
