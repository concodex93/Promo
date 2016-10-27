package com.example.conor.promo.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.conor.promo.CustomAdapter;
import com.example.conor.promo.Database.DatabaseHelper;
import com.example.conor.promo.MainActivity;
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

    // DB
    //DatabaseHelper myDB;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.promo_frag_layout, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();

        // CREATES DB INSTANCE
        //myDB = new DatabaseHelper(getActivity());

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

    public void GET_Promos(){

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(getActivity());

        // Request a string response from the provided URL.
        String url = "";

        // Request a string response from the provided URL.

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        ProcessResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String ErrorMessage = ("Server Error. Check your internet connenction");
                Toast.makeText(getActivity(), ErrorMessage, Toast.LENGTH_SHORT).show();
            }
        });
        stringRequest.setRetryPolicy((new DefaultRetryPolicy(3000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)));
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    public void ProcessResponse(String response){
        // Make Class that handles JSON paring and convert into usable objects (JsonHadler)
    }
}
