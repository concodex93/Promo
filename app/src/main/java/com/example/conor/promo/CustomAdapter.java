package com.example.conor.promo;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by conor on 24/10/2016.
 */
public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<Promotion> promotions;

    public CustomAdapter (Context c, ArrayList<Promotion> arrayList){
            context = c;
            promotions = new ArrayList<Promotion>();
            for (Promotion p : arrayList){
                try {
                    promotions.add(new Promotion(p.getPromoName()));
                } catch(NullPointerException e){
                    // Pass
                }
            }
    }

    @Override
    public int getCount() {
        // Return number of elements to return
        return promotions.size();
    }

    @Override
    public Object getItem(int position) {
        // returns object at position
        return promotions.get(position);
    }

    @Override
    public long getItemId(int position) {
        // Returns id of row of which is our array index itself
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get data, put data in view object and return view object
        // Creates new object each time
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View row = inflater.inflate(R.layout.single_row, parent, false);

        // Change Font Type
        //Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf");

        // Get Promo in question
        Promotion promoTemp = promotions.get(position);

        // Set textView
        TextView textView = (TextView) row.findViewById(R.id.textView);
        textView.setText(promoTemp.getPromoName());
        //textView.setTypeface(typeface);

        // Return modified view
        return row;
    }
}
