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

        final ArrayList<Content> historicalSites = new ArrayList<Content>();

        historicalSites.add(new Content(getString(R.string.water_tower),getString(R.string.water_tower_address)));
        historicalSites.add(new Content(getString(R.string.statue),getString(R.string.statue_address)));
        historicalSites.add(new Content(getString(R.string.museum_history),getString(R.string.museum_history)));
        historicalSites.add(new Content(getString(R.string.gustav_church),getString(R.string.gustav_church_address)));
        historicalSites.add(new Content(getString(R.string.caroli_church),getString(R.string.caroli_church_address)));

        ContentAdapter itemsAdapter = new ContentAdapter(this, historicalSites, R.color.historical_sites);
        ListView listView = (ListView) findViewById(R.id.content_list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Content historicalSite = historicalSites.get(position);

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(historicalSite.getGeoLocation()));
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}
