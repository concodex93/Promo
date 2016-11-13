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
import com.example.conor.promo.WebServices.WebServiceHandler;
import com.google.gson.Gson;

import java.util.ArrayList;


public class PromoFrag extends Fragment {
    //###WARNING INCORRECT
    String displayPromos_url = "http://promo  dublin.dx.am/php/displayPromos.php";

    // Declare UI elements
    ListView listView;

    // Declare data structures
    ArrayList<Object> promoList;

    // DB
    //DatabaseHelper myDB;
    // aba


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

        // Dummy Json Object
        Drink drinkDummy1 = new Drink("Bud", "Beer");
        Venue venueDummy1 = new Venue("Coppers", "Dublin", "18:00", "02:00");
        Promotion promotionDummy1 = new Promotion("5 Euro Beers before 10 pm", "Not that great", drinkDummy1, "5 Euro", venueDummy1);

        // Convert Java Object to Json String
        Gson gson = new Gson();
        String jsonDummy = gson.toJson(promotionDummy);
        String jsonDummy1 = gson.toJson(promotionDummy1);

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(jsonDummy);
        arrayList.add(jsonDummy1);

        // Pass arraylist as json string to method
        String json = new Gson().toJson(arrayList);
        ProcessResponse(json);


    }

    //make a seperate class for retrieving data from Server. pass in Activity/context, url string
    //return data and format accordingly
    //make global url strings e.g "url.displayPromos_url"

//    public void GET_Promos(){
//
//        // Instantiate the RequestQueue.
//        RequestQueue queue = Volley.newRequestQueue(getActivity());
//
//        // Request a string response from the provided URL.
//        String url = displayPromos_url;
//
//        // Request a string response from the provided URL.
//
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        //connects to DB url, retreives response & passes to ProcessResponse method
//                        ProcessResponse(response);
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                String ErrorMessage = ("Connection error ... ");
//                Toast.makeText(getActivity(), ErrorMessage, Toast.LENGTH_SHORT).show();
//            }
//        });
//        stringRequest.setRetryPolicy((new DefaultRetryPolicy(3000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)));
//        // Add the request to the RequestQueue.
//        queue.add(stringRequest);
//    }

    public void GET_Promos_from_webservicesHandler() {

        // Instantiate the webServiceHandler, pass in context (getActivity?).
        WebServiceHandler webServiceHandler = new WebServiceHandler(getActivity());

        // Request a string response from the provided URL.
        String url = displayPromos_url;

        webServiceHandler.READ_STRING(url, new WebServiceHandler.VolleyCallback() {
            @Override
            public void onSuccess(String result) {
                //connects to DB url, retreives response & passes to ProcessResponse method
                ProcessResponse(result);
            }
        });
    }

        //You can also make VolleyCallback more robust, using generic types if you want to do
        // processing, or adding start(), failed(Exception e), complete(), etc methods to do a
        // little more fine-grained state checking.

        //Keep in mind this is an async call, so you will have to update views, etc when you get
        // the result back (inside success()).


        // Request a string response from the provided URL.




//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        //connects to DB url, retreives response & passes to ProcessResponse method
//                        ProcessResponse(response);
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                String ErrorMessage = ("Connection error ... ");
//                Toast.makeText(getActivity(), ErrorMessage, Toast.LENGTH_SHORT).show();
//            }
//        });
//        stringRequest.setRetryPolicy((new DefaultRetryPolicy(3000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)));
//        // Add the request to the RequestQueue.
//        queue.add(stringRequest);
//    }

    public void ProcessResponse(String result){
        // Make Class that handles JSON paring and convert into usable objects (JsonHadler)
        JsonHandler jsonHandler = new JsonHandler();
        // Populate list (May need to handle exception if nothing is returned?)
        promoList = jsonHandler.parseJson(result);
        // Send to adapter
        listView.setAdapter(new CustomAdapter(getActivity(), promoList));
    }
}
