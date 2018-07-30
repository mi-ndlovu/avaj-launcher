package com.mndlovu.vehicles;

import com.mndlovu.simulator.WeatherTower;

/**
 * @author mndlovu
 * @since 13-06-2018
 */
public interface Flyable {

    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}
