package com.mndlovu.weather;

import com.mndlovu.vehicles.Aircraft;

/**
 * @author mndlovu
 * @since 13-06-2018
 */

public class Coordinates extends Aircraft{

    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height) {
        this.longitude = setLongitude(longitude);
        this.latitude = setLatitude(latitude);
        this.height = setHeight(height);
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    private int setLongitude(int longitude) {
        if (longitude > 0)
            return longitude;
        return 0;
    }

    private int setLatitude(int latitude) {
        if (latitude > 0)
            return latitude;
        return  0;
    }

    private int setHeight(int height) {
        if (height > 0 && height <= 100)
            return height;
        else {
            if (height < 0)
                return 0;
            else
                return 100;
        }
    }
}
