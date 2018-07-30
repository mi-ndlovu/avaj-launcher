package com.mndlovu.vehicles;

import com.mndlovu.weather.Coordinates;

/**
 * AircraftFactory class creates aircraft
 * @author mndlovu
 * @since 13-06-2018
 */

public class AircraftFactory {

    public AircraftFactory() {}

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        if ("Baloon".equals(type)) {
            return new Baloon(name, coordinates);
        } else if ("Helicopter".equals(type)) {
            return new Helicopter(name, coordinates);
        } else if ("JetPlane".equals(type)) {
            return new JetPlane(name, coordinates);
        }
        return null;
    }
}
