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


public class WebServiceHandler implements IStorage {

    Context context;

    public WebServiceHandler (Context c) {context = c;}

    String unparsed_response = null;
//    String unparsed_response = "";

    @Override
    public void CREATE() {

    }


    public Object READ_STRING(Object url_in, final VolleyCallback callback) {
        String url = (String) url_in;
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);

        // Request a string response from the provided URL.
        //return string to the requestee



        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.onSuccess(response);
//                        ProcessResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String ErrorMessage = ("Connection error ... ");
                Toast.makeText(context, ErrorMessage, Toast.LENGTH_SHORT).show();
            }
        }
        );
        stringRequest.setRetryPolicy((new DefaultRetryPolicy(3000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)));
        // Add the request to the RequestQueue.
        queue.add(stringRequest);

        return null;
    }
    @Override
//    public Object READ(Object obj) {
    public Object READ(Object url_in) {
        String url = (String) url_in;
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);

        // Request a string response from the provided URL.
        //return string to the requestee
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

//                        ProcessResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String ErrorMessage = ("Connection error ... ");
                Toast.makeText(context, ErrorMessage, Toast.LENGTH_SHORT).show();
            }
            }
        );
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

    public interface VolleyCallback{
        void onSuccess(String result);
    }
}
