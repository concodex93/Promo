package com.example.conor.promo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

//test test

public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<Object> objectsToPopulateListView;

    // Set up with generic object so HOPEFULLY, we can reuse this adapter for something
    // else if we need to!

    public CustomAdapter (Context c, ArrayList<Object> arrayList){
            context = c;
            objectsToPopulateListView = new ArrayList<Object>();

            for (Object o : arrayList){
                try {

                    if (o instanceof Promotion){
                        // Add to list
                        objectsToPopulateListView.add(new Promotion(((Promotion) o).getPromoName(), ((Promotion) o).getDescription()
                                , ((Promotion) o).getDrink(), ((Promotion) o).getPrice(), ((Promotion) o).getVenue()));
                    }

                } catch(NullPointerException e){
                    // Pass
                }
            }
    }

    @Override
    public int getCount() {
        // Return number of elements to return
        return objectsToPopulateListView.size();
    }

    @Override
    public Object getItem(int position) {
        // returns object at position
        return objectsToPopulateListView.get(position);
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

        // Get Promo in question
        Promotion promoTemp = (Promotion) objectsToPopulateListView.get(position);

        // Set textView
        TextView textView = (TextView) row.findViewById(R.id.textView);
        textView.setText(promoTemp.getPromoName());
        //textView.setTypeface(typeface);

        // Return modified view
        return row;
    }
}
