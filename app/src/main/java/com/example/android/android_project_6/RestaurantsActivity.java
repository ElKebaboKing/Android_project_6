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
        setContentView(R.layout.content_list);

        final ArrayList<Content> restaurants = new ArrayList<Content>();

        restaurants.add(new Content(getString(R.string.la_copita),getString(R.string.la_copita_address)));
        restaurants.add(new Content(getString(R.string.byblos_pizzeria),getString(R.string.byblos_pizzeria_address)));
        restaurants.add(new Content(getString(R.string.vinacciolo),getString(R.string.vinacciolo_address)));
        restaurants.add(new Content(getString(R.string.spice_n_rice),getString(R.string.spice_n_rice_address)));
        restaurants.add(new Content(getString(R.string.boras_kebab),getString(R.string.boras_kebab_address)));
        restaurants.add(new Content(getString(R.string.masaki),getString(R.string.masaki_address)));
        restaurants.add(new Content(getString(R.string.subway),getString(R.string.subway_address)));

        ContentAdapter itemsAdapter = new ContentAdapter(this, restaurants, R.color.restaurants);
        ListView listView = (ListView) findViewById(R.id.content_list);
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
