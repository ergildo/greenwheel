/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.greenwheel;

import com.greenwheel.model.Component;
import com.greenwheel.model.Dealership;
import com.greenwheel.model.TypeCompent;
import com.greenwheel.model.TypeVehicle;
import com.greenwheel.model.Vehicle;

/**
 *
 * @author jose-ecd
 */
public class Main {

    public static void main(String[] args) {

        Dealership dealership = new Dealership(1, "Gerry’s GreenWheel Dealership", "123 my road, my street, my County");

        // Exemple to add old car
        Vehicle greenWheelX1 = new Vehicle(1, TypeVehicle.OLD, "GreenWheelX1", "cherry red");
        Component gearbox = new Component(TypeCompent.engineSize.gearbox, "8 speed");
        Component transmission = new Component(TypeCompent.transmission, "automatic");
        Component engineType = new Component(TypeCompent.engineType, "diesel");
        Component engineSize = new Component(TypeCompent.engineSize, "4.0 liter ");
        Component numberOfDoors = new Component(TypeCompent.numberOfDoors, "5");
        Component wheelSize = new Component(TypeCompent.wheelSize, "16");

        greenWheelX1.addCompent(gearbox);
        greenWheelX1.addCompent(transmission);
        greenWheelX1.addCompent(engineType);
        greenWheelX1.addCompent(engineSize);
        greenWheelX1.addCompent(numberOfDoors);
        greenWheelX1.addCompent(wheelSize);

        dealership.addVehicle(greenWheelX1);
        dealership.addVehicle(greenWheelX1);
        dealership.addVehicle(greenWheelX1);

        System.out.println(dealership);
        System.out.println("------------------------------------------------------------------------");
        System.out.println(dealership.toLine());
    }
}
