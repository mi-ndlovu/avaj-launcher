package com.mndlovu.vehicles;

import com.mndlovu.weather.Coordinates;

/**
 * @author mndlovu
 * @since 13-06-2018
 */
public class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected String FMT = "Tower says: %s#%s(%d) registered to weather tower.";
    protected String FMT_L = "%s#%s(%d) Landing";
    protected String FMT_UNR = "Tower says: %s#%s(%d) unregistered from weather tower.";
    private static long idCounter = 1;

    public Aircraft() {}

    public Aircraft(String name, Coordinates coordinates) {
        this.id = nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    protected String formattedMessage(String message, String className) {
        return String.format("%s#%s(%d): %s", className, name, id, message);
    }

    private long nextId() {
        return idCounter++;
    }
}
