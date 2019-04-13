package com.greenwheel.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Vehicle implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6867334042548362864L;
    private Integer vinNumber;
    private String name;
    private String color;
    private List<Component> components;
    private TypeVehicle type;

    public Vehicle(Integer vinNumber, TypeVehicle type, String name, String color) {
        this.vinNumber = vinNumber;
        this.name = name;
        this.type = type;
        this.color = color;
    }

    public void addCompent(Component component) {
        if (components == null) {
            components = new ArrayList<Component>();
        }
        components.add(component);
    }

    public void addCompent(Vehicle origin, TypeCompent type) {
        if (origin == null) {
            throw new IllegalArgumentException("The vehicle origin cant not be null");
        }

        if (type == null) {
            throw new IllegalArgumentException("The type cant not be null");
        }

        List<Component> existing = getCompoents(origin);
        if (existing.size() >= 2) {
            throw new IllegalArgumentException("A new vehicle cannot use more than two components from any one existing car");
        }

        Component compnont = origin.getCompoent(type);

        Component newComponent = new Component(compnont, origin);

        if (components == null) {
            components = new ArrayList<Component>();
        }

        components.add(newComponent);
    }

    public Component getCompoent(TypeCompent type) {
        if (components != null) {
            for (Component component : components) {
                if (component.getType().equals(type)) {
                    return component;
                }
            }
        }
        throw new IllegalArgumentException("The vehicle doen't have this component");
    }

    public List<Component> getCompoents(Vehicle origin) {
        List<Component> list = new ArrayList<>();
        if (components != null) {
            components.stream().filter((component) -> (component.isFrom(origin))).forEach((component) -> {
                list.add(component);
            });
        }
        return list;
    }

    public String getName() {
        return name + "(vin:" + vinNumber + ")";
    }

    public List<Component> getComponents() {
        return components;
    }

    public TypeVehicle getType() {
        return type;
    }

    public String toLine() {
        return "vehicle;" + vinNumber + ";" + type + ";" + name + ";" + color + "|"
                + components.stream().map(x -> x.toLine()).collect(Collectors.joining(";"));
    }

    @Override
    public String toString() {

        return getName() + " " + components.stream().map(x -> x.getName()).collect(Collectors.joining(" ")) + " in "
                + color+"\n\n";
    }

    public Integer getVinNumber() {
        return vinNumber;
    }

}
