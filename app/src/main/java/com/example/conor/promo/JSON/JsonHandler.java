package com.example.conor.promo.JSON;
import com.example.conor.promo.Promotion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class JsonHandler {

    // We will pass Promotion objects from response here
    ArrayList<Object> arrayList;


    public JsonHandler () {
        arrayList = new ArrayList<>();
    }

    public ArrayList<Object> parseJson (String json) {

        try {

            // Now convert the JSON string back to your java object
            Type type = new TypeToken<ArrayList<Promotion>>(){}.getRawType();
            ArrayList<Promotion> jsonArray = new Gson().fromJson(json, type);
            // Iterate through each json string and create object using Gson
            for (int i = 0; i <= jsonArray.size(); i ++) {
                Gson gson = new GsonBuilder().create();
                Promotion promotion = gson.fromJson(String.valueOf(jsonArray.get(i)), Promotion.class);
                arrayList.add(promotion);

            }

        } catch (Exception e ){
            // Pass for now
        }

        return arrayList;
    }



}


