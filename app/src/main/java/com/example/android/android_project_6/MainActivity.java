package com.example.android.android_project_6;

import android.app.usage.UsageEvents;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the TextViews in the main menu
        final TextView restaurants = (TextView) findViewById(R.id.restaurants);
        TextView attractions = (TextView) findViewById(R.id.attractions);
        TextView events = (TextView) findViewById(R.id.events);
        TextView historicalSites = (TextView) findViewById(R.id.historical_sites);

        // Set a click listener on the Restaurant View
        restaurants.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the menu item is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link RestaurantsActivity}
                Intent restaurantsIntent = new Intent(MainActivity.this, RestaurantsActivity.class);

                // Start the new activity
                startActivity(restaurantsIntent);
            }
        });

        // Set a click listener on the Attractions View
        attractions.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the menu item is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link AttractionsActivity}
                Intent attractionsIntent = new Intent(MainActivity.this, AttractionsActivity.class);

                // Start the new activity
                startActivity(attractionsIntent);
            }
        });

        // Set a click listener on the Events View
        events.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the menu item is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link EventsActivity}
                Intent eventsIntent = new Intent(MainActivity.this, EventsActivity.class);

                // Start the new activity
                startActivity(eventsIntent);
            }
        });

        // Set a click listener on the Historical sites View
        historicalSites.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the menu item is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link HistoricalSitesActivity}
                Intent historicalSitesIntent = new Intent(MainActivity.this, HistoricalSitesActivity.class);

                // Start the new activity
                startActivity(historicalSitesIntent);
            }
        });
    }
}
