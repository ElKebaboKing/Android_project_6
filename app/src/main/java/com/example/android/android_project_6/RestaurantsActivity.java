package com.example.android.android_project_6;

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

public class RestaurantsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_list);

        final ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();

        restaurants.add(new Restaurant("La Copita", "Allégatan 63, 503 37 Borås"));
        restaurants.add(new Restaurant("Byblos pizzeria", "Åsbogatan 9, 503 36 Borås"));
        restaurants.add(new Restaurant("Vinacciolo", "Österlånggatan 23, 503 31 Borås"));
        restaurants.add(new Restaurant("Spice'n Rice", "Allégatan 49, 503 37 Borås"));
        restaurants.add(new Restaurant("Borås Kebab", "Lilla Brogatan 7, 503 30 Borås"));
        restaurants.add(new Restaurant("Masaki", "Hallbergsgatan 10, 503 30 Borås"));
        restaurants.add(new Restaurant("SUBWAY Borås", "Stora Brogatan 5. 503 30 Borås"));

        RestaurantAdapter itemsAdapter = new RestaurantAdapter(this, restaurants, R.color.restaurants);
        ListView listView = (ListView) findViewById(R.id.restaurant_list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Restaurant restaurant = restaurants.get(position);

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(restaurant.getLocation()));
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}
