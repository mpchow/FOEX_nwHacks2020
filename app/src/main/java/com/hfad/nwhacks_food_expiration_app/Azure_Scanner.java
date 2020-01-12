package com.hfad.nwhacks_food_expiration_app;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Azure_Scanner extends AppCompatActivity {

    private static Set<String> validItems = new HashSet<>(Arrays.asList("banana", "apple"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azure__scanner);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public static FoodItem jsonToFood(JsonObject jsonObject) throws InstantiationException {
        String foregroundC = "";
        String backgroundC = "";
        List<String> dominantC = new ArrayList<>();
        List<String> tags = new ArrayList<>();
        try {
            JsonObject JsonDesc = jsonObject.getAsJsonObject("description");
            JsonArray JsonTags = JsonDesc.getAsJsonArray("tags");
            for (int i = 0; i < JsonTags.size(); i++) {
                tags.add(JsonTags.get(i).getAsString());
            }
            JsonObject JsonColor = jsonObject.getAsJsonObject("color");
            JsonArray JsonDomColours = JsonColor.getAsJsonArray("dominantColors");
            for (int i = 0; i < JsonDomColours.size(); i++) {
                dominantC.add(JsonDomColours.get(i).getAsString());
            }
            foregroundC = JsonColor.get("dominantColorForeground").getAsString();
            backgroundC = JsonColor.get("dominantColorBackground").getAsString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new FoodItem(foregroundC, backgroundC, dominantC, tags, validItems);
    }

}
