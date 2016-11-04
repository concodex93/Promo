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
import com.example.conor.promo.Drink;
import com.example.conor.promo.JSON.JsonHandler;
import com.example.conor.promo.Promotion;
import com.example.conor.promo.R;
import com.example.conor.promo.Venue;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by conor on 23/10/2016.
 */
public class PromoFrag extends Fragment {

    // Declare UI elements
    ListView listView;

    // Declare data structures
    ArrayList<Object> promoList;

    // DB
    //DatabaseHelper myDB;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.promo_frag_layout, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();

        listView = (ListView) getView().findViewById(R.id.listView);

        // Dummy Json Object
        Drink drinkDummy = new Drink("Bulmbers", "Beer");
        Venue venueDummy = new Venue("Diceys", "Dublin", "18:00", "02:00");
        Promotion promotionDummy = new Promotion("2 Euro Beers", "What you think", drinkDummy, "2 Euro", venueDummy);
        // Convert Java Object to Json String
        Gson gson = new Gson();
        String jsonDummy = gson.toJson(promotionDummy);
        // Begin Processing Method
        ProcessResponse(jsonDummy);

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
                String ErrorMessage = ("Connection error ... ");
                Toast.makeText(getActivity(), ErrorMessage, Toast.LENGTH_SHORT).show();
            }
        });
        stringRequest.setRetryPolicy((new DefaultRetryPolicy(3000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)));
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    public void ProcessResponse(String response){
        // Make Class that handles JSON paring and convert into usable objects (JsonHadler)
        JsonHandler jsonHandler = new JsonHandler();
        // Populate list (May need to handle exception if nothing is returned?)
        promoList = jsonHandler.parseJson(response);
        // Send to adapter
        listView.setAdapter(new CustomAdapter(getActivity(), promoList));
    }
}
