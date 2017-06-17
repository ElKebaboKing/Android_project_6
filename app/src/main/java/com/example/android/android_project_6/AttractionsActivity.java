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

public class AttractionsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_list);

        final ArrayList<Content> attractions = new ArrayList<Content>();

        attractions.add(new Content(getString(R.string.boras_zoo),getString(R.string.boras_zoo_address)));
        attractions.add(new Content(getString(R.string.boras_museum),getString(R.string.boras_museum_address)));
        attractions.add(new Content(getString(R.string.stadsparksbadet),getString(R.string.stadsparksbadet_address)));
        attractions.add(new Content(getString(R.string.boras_textile_museum),getString(R.string.boras_textile_museum_address)));
        attractions.add(new Content(getString(R.string.boras_art_museum),getString(R.string.boras_art_museum_address)));
        attractions.add(new Content(getString(R.string.abecita_art_museum),getString(R.string.abecita_art_museum_address)));

        ContentAdapter itemsAdapter = new ContentAdapter(this, attractions, R.color.attractions);
        ListView listView = (ListView) findViewById(R.id.content_list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Content attraction = attractions.get(position);

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(attraction.getGeoLocation()));
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}
