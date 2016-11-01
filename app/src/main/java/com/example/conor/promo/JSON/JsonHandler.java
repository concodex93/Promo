package com.example.conor.promo.JSON;

import com.example.conor.promo.Promotion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.util.ArrayList;

/**
 * Created by conor on 27/10/2016.
 */
public class JsonHandler {

    // We will pass Promotion objects from response here
    ArrayList<Promotion> arrayList;

    public JsonHandler () {
        arrayList = new ArrayList<Promotion>();
    }

    public ArrayList<Promotion> parseJson (String json) {

        try {

            /*
             SOURCE FOR CODE: http://javabeat.net/parsing-json-using-java-and-gson-library/
             */

            // Parse json string and store inside jsonArray
            JsonParser jsonParser = new JsonParser();
            JsonArray jsonArray = jsonParser.parse(json).getAsJsonArray();

            // Iterate through array
            for (int i = 0; i <= jsonArray.size(); i++) {
                // Make message object and store in list
                Gson gson = new GsonBuilder().create();
                Promotion promotionObj = gson.fromJson(json, Promotion.class);
                // Add to list
                arrayList.add(promotionObj);
            }

        } catch (Exception e ){
            // Pass for now
        }

        return arrayList;
    }
}
