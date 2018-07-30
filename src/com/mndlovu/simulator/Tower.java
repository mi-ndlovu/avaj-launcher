package com.mndlovu.simulator;

import com.mndlovu.vehicles.Flyable;

import java.util.LinkedList;
import java.util.List;

/**
 * @author mndlovu
 * @since 13-06-2018
 */

public class Tower {

    private List<Flyable> observers = new LinkedList<>();

    /**
     * adds the flyable object in a list.
     * @param flyable any class that implements flyable interface
     */
    public void register(Flyable flyable) {
        if (!observers.contains(flyable))
            observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    public void conditionsChanged() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
        }
    }
}
