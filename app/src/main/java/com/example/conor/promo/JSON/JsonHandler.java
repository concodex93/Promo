package com.example.conor.promo.JSON;

import com.example.conor.promo.Drink;
import com.example.conor.promo.Promotion;
import com.example.conor.promo.Venue;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.security.Policy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by conor on 27/10/2016.
 */
public class JsonHandler {

    // We will pass Promotion objects from response here
    ArrayList<Object> arrayList;


    public JsonHandler () {
        arrayList = new ArrayList<>();
    }

    public ArrayList<Object> parseJson (String json) {

        try {

            Gson gson = new GsonBuilder().create();
            Promotion promotion1 = gson.fromJson(json, Promotion.class);
            arrayList.add(promotion1);


        } catch (Exception e ){
            // Pass for now
        }

        return arrayList;
    }
}
