package com.mndlovu.weather;

/**
 * @author mndlov
 * @since 13-06-2018
 */

public class WeatherProvider {

    private static WeatherProvider weatherProvider = new WeatherProvider();
    private String[] weather = {"RAIN","FOG","SUN","SNOW"};

    public WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int i = 0;
        if (coordinates.getLongitude() > 25)
            i++;
        if (coordinates.getLatitude() > 20)
            i++;
        if (coordinates.getHeight() > 35)
            i++;
        return weather[i];
    }
}
