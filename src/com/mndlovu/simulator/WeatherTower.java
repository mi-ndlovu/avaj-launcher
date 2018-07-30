package com.mndlovu.simulator;

import com.mndlovu.weather.Coordinates;
import com.mndlovu.weather.WeatherProvider;

/**
 * @author mndlovu
 * @since 13-06-2018
 */
public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather() {
        super.conditionsChanged();
    }
}
