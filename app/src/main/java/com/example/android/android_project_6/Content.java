package com.example.android.android_project_6;

import android.util.Log;

/**
 * Created by es013620 on 2017-06-05.
 */

public class Content {

    private String mName;
    private Location mLocation;
    private int mImageResourceId;

    public Content(String name, String adress)
    {
        mName = name;
        mLocation = new Location(adress);
    }

    public Content(String name, String adress, int imageResourceId)
    {
        mName = name;
        mLocation = new Location(adress);
        mImageResourceId = imageResourceId;
    }

    public String getName()
    {
        return mName;
    }

    public int getImageResourceId() {return mImageResourceId;}

    public String getLocation()
    {
        return mLocation.getLocationByAdress();
    }

    public String getGeoLocation()
    {
        return mLocation.getGeoLocationByAdress();
    }
}
