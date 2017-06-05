package com.example.android.android_project_6;

/**
 * Created by es013620 on 2017-06-05.
 */

public class Location {
    private String mStreetName, mPostCode, mStreetNumber, mAdress;
    private double mLatitude, mLongitude;

    // Location by street name and postal code
    public Location(String streetName, String streetNumber, String postCode)
    {
        mStreetName = streetName;
        mStreetNumber = streetNumber;
        mPostCode = postCode;

    }

    // Location by coordinates
    public Location(double latitude, double longitude)
    {
        mLatitude = latitude;
        mLongitude = longitude;
    }

    // Location by adress
    public Location(String adress)
    {
        mAdress = adress;
    }

    public String getLocationByAdress()
    {
        return mAdress;
    }

    public String getLocationByStreetName()
    {
        return (mStreetName + mStreetNumber + "," + mPostCode);
    }
    public String getLocationByGPS()
    {
        return("geo:" + mLatitude + "," + mLongitude);
    }
}
