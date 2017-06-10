package com.example.android.android_project_6;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by es013620 on 2017-06-05.
 */

public class HistoricalSitesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_list);

        final ArrayList<Content> restaurants = new ArrayList<Content>();

        restaurants.add(new Content("La Copita", "Allégatan 63, 503 37 Borås"));
        restaurants.add(new Content("Byblos pizzeria", "Åsbogatan 9, 503 36 Borås"));
        restaurants.add(new Content("Vinacciolo", "Österlånggatan 23, 503 31 Borås"));
        restaurants.add(new Content("Spice'n Rice", "Allégatan 49, 503 37 Borås"));
        restaurants.add(new Content("Borås Kebab", "Lilla Brogatan 7, 503 30 Borås"));
        restaurants.add(new Content("Masaki", "Hallbergsgatan 10, 503 30 Borås"));
        restaurants.add(new Content("SUBWAY Borås", "Stora Brogatan 5. 503 30 Borås"));

        ContentAdapter itemsAdapter = new ContentAdapter(this, restaurants, R.color.restaurants);
        ListView listView = (ListView) findViewById(R.id.restaurant_list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Content restaurant = restaurants.get(position);

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(restaurant.getGeoLocation()));
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}
