package com.example.android.android_project_6;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by es013620 on 2017-06-05.
 */

public class ContentAdapter extends ArrayAdapter<Content> {

    private int mColor;

    public ContentAdapter(Activity context, ArrayList<Content> restaurants, int color)
    {
        super(context, 0, restaurants);
        mColor = color;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null)
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        // Get the object located at this position in the list
        Content content = getItem(position);

        // Find the restaurant name TextView
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        // Set restaurant name
        nameTextView.setText(content.getName());

        // Find the restaurant adress TextView
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location_text_view);
        // Set restaurant location
        locationTextView.setText(content.getLocation());

        // Find the ImageView
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Set the image
        imageView.setImageResource(content.getImageResourceId());

        if (content.getImageResourceId()>0)
            // Make image visible
            imageView.setVisibility(View.VISIBLE);
        else
            // Make image disappear
            imageView.setVisibility(View.GONE);

        // Set the theme color for the list item
        View itemContainer = listItemView.findViewById(R.id.list_item_container);

        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColor);

        // Set the background color of the text container View
        itemContainer.setBackgroundColor(color);
        return listItemView;
    }
}
