package com.greenwheel.model;

import java.io.Serializable;

public class Component implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2528208849600799588L;
    private String value;
    private TypeCompent type;
    private Vehicle origin;

    public Component(TypeCompent type, String value) {
        this.value = value;
        this.type = type;
    }

    public Component(TypeCompent type, String value, Vehicle origin) {
        this.value = value;
        this.type = type;
        this.origin = origin;
    }

    public Component(Component component, Vehicle origin) {
        if (component == null) {
            throw new IllegalArgumentException("The component origin cant not be null");
        }
        if (origin == null) {
            throw new IllegalArgumentException("The vehicle origin cant not be null");
        }
        this.value = component.value;
        this.type = component.type;
        this.origin = origin;
    }

    public String getName() {
        return origin == null ? value : value + " (" + origin.getName() + ")";
    }

    public boolean isFrom(Vehicle vehicle) {
        return isFrom(vehicle.getVinNumber());
    }

    public boolean isFrom(Integer vin) {
        return origin != null && origin.getVinNumber().equals(vin);
    }

    public String toLine() {
        if (origin == null) {
            return type + "=" + value;
        }
        return type + "=(vin:" + origin.getVinNumber() + ")";
    }

    public Vehicle getOrigin() {
        return origin;
    }

    @Override
    public String toString() {
        return getName();
    }

    public TypeCompent getType() {
        return type;
    }
}
