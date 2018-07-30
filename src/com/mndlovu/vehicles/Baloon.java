package com.mndlovu.vehicles;

import com.mndlovu.simulator.Simulator;
import com.mndlovu.simulator.WeatherTower;
import com.mndlovu.weather.Coordinates;

/**
 * @author mndlovu
 * @since 13-06-2018
 */

public class Baloon extends Aircraft implements Flyable{

    private WeatherTower weatherTower;
    private String className = this.getClass().getSimpleName();

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    private void conditions() {
        String message;
        String weatherType = weatherTower.getWeather(coordinates);
        if (weatherType.equals("SUN")) {
            coordinates = new Coordinates(coordinates.getLongitude() + 2,
                    coordinates.getLatitude(), coordinates.getHeight() + 4);
            message = formattedMessage("It's too damn hot", className);
            Simulator.writeToAFile(message , Simulator.getFileName());
        } else if (weatherType.equals("RAIN")) {
            coordinates = new Coordinates(coordinates.getLongitude(),
                    coordinates.getLatitude(), coordinates.getHeight() - 5);
            message = formattedMessage("It's raining. Better watch out for lightings.", className);
            Simulator.writeToAFile(message , Simulator.getFileName());
        } else if (weatherType.equals("FOG")) {
            coordinates = new Coordinates(coordinates.getLongitude(),
                    coordinates.getLatitude(), coordinates.getHeight() - 3);
            message = formattedMessage("OMG! Winter is coming!", className);
            Simulator.writeToAFile(message , Simulator.getFileName());
        } else if (weatherType.equals("SNOW")) {
            coordinates = new Coordinates(coordinates.getLongitude(),
                    coordinates.getLatitude(), coordinates.getHeight() - 15);
            message = formattedMessage("It's snowing. We're  gonna crash.", className);
            Simulator.writeToAFile(message , Simulator.getFileName());
        }
    }

    @Override
    public void updateConditions() {
        conditions();
        if (coordinates.getHeight() == 0) {
            Simulator.writeToAFile(String.format(FMT_L, className, name, id), Simulator.getFileName());
            weatherTower.unregister(this);
            Simulator.writeToAFile(String.format(FMT_UNR, className, name, id), Simulator.getFileName());
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        String message = String.format(FMT, className, name, id);
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.writeToAFile(message, Simulator.getFileName());
    }
}
