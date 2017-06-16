package com.example.android.android_project_6;

/**
 * Created by es013620 on 2017-06-05.
 */

public class Location {
    private String  mAdress;

    // Location by adress
    public Location(String adress)
    {
        mAdress = adress;
    }

    public String getGeoLocationByAdress()
    {
        return ("geo:0,0?q=" + mAdress);
    }

    public String getLocationByAdress()
    {
        return (mAdress);
    }
}
