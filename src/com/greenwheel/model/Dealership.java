package com.greenwheel.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dealership implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -881891995223399157L;
    private Integer deshNumber;
    private String name;
    private String address;
    private List<Vehicle> inventory;

    public Dealership(Integer vinNumber, String name, String address) {
        this.deshNumber = vinNumber;
        this.name = name;
        this.address = address;
    }

    public void addVehicle(Vehicle vehicle) {
        if (inventory == null) {
            inventory = new ArrayList<Vehicle>();
        }
        final int newStock = inventory.size() + 1;
        if (newStock > 20) {
            throw new IllegalArgumentException("Car inventory limit exceeded. The maximum limit is 20");
        }
        inventory.add(vehicle);
    }

    public Vehicle getVehicle(Integer vin) throws Exception {
        return inventory.stream().filter(v -> v.getVinNumber().equals(vin)).findFirst().orElseThrow(() -> new Exception("Vehicle(vin:" + vin + ") not found in Dealership(desh:" + deshNumber + ")"));
    }

    public String toLine() {
        return "delership;" + deshNumber + ";" + name + ";" + address + "|"
                + inventory.stream().map(x -> x.getVinNumber().toString()).collect(Collectors.joining(";"));
    }

    @Override
    public String toString() {
        return name + "(desh:" + deshNumber + ") of " + address + "\nPresents:\n" + inventory.stream().map(x -> x.toString()).collect(Collectors.joining("\n")) + "\n\n";
    }

    public Integer getDeshNumber() {
        return deshNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Vehicle> getInventory() {
        return inventory;
    }

}
