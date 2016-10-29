package com.example.conor.promo.WebServices;

import android.content.Context;
import android.widget.Toast;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.conor.promo.Database.IStorage;

/**
 * Created by conor on 29/10/2016.
 *
 * This is where we will preform REST calls to our mySQL db
 * Hopefully we can use this to make our calls instead of putting the Volley method
 * directly into the Activity we want to use it in!
 */

public class WebServiceHandler implements IStorage {

    Context context;
    String url;

    public WebServiceHandler (Context c) {context = c;}

    @Override
    public void CREATE() {

    }

    @Override
    public Object READ(Object obj) {

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);

        // Request a string response from the provided URL.
        String url = (String) obj;

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
                Toast.makeText(context, ErrorMessage, Toast.LENGTH_SHORT).show();
            }
        });
        stringRequest.setRetryPolicy((new DefaultRetryPolicy(3000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)));
        // Add the request to the RequestQueue.
        queue.add(stringRequest);

        return null;
    }

    @Override
    public void UPDATE(Object obj) {

    }

    @Override
    public void DELETE(Object obj) {

    }

    public void ProcessResponse (String response) {
        // Process response and convert into usable objects
    }
}
