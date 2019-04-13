package com.greenwheel.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.greenwheel.model.Component;
import com.greenwheel.model.TypeCompent;
import com.greenwheel.model.TypeVehicle;
import com.greenwheel.model.Vehicle;
import com.greenwheel.util.FileUtils;
import java.io.FileNotFoundException;

public class VehicleRepository implements Reposity<Vehicle, Integer> {

    List<Vehicle> vehicles = null;

    @Override
    public void save(Vehicle vehicle) throws Exception {
        String line = vehicle.toLine();
        String filePath = FileUtils.getGreenWheelFilePath();
        FileUtils.writeLine(filePath, line);
    }

    @Override
    public Vehicle get(Integer vinNumber) throws Exception {
        vehicles = list();
        return get(vehicles, vinNumber);
    }

    public Vehicle get(List<Vehicle> vehicles, Integer vinNumber) throws Exception {
        return vehicles.stream().filter(v -> v.getVinNumber().equals(vinNumber)).findFirst()
                .orElseThrow(() -> new Exception("Vehicle (vin:" + vinNumber + ") not found"));
    }

    public List<Vehicle> listExistingVehicles() throws Exception {
        vehicles = list();
        return listByType(TypeVehicle.OLD, vehicles);
    }

    public List<Vehicle> listNewsVehicles() throws Exception {
        vehicles = list();
        return listByType(TypeVehicle.NEW, vehicles);
    }

    private List<Vehicle> listByType(TypeVehicle type, List<Vehicle> vehicles) {
        return vehicles.stream().filter(v -> v.getType().equals(type)).collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> list() throws Exception {
        vehicles = new ArrayList<>();
        String filePath = FileUtils.getGreenWheelFilePath();
        try {

            List<String> lines = FileUtils.readAllLines(filePath);
            
            List<String> vehicleLines = lines.stream().filter(l->l.startsWith("vehicle")).collect(Collectors.toList());

            return readFileLines(vehicleLines);
        } catch (FileNotFoundException e) {
            return vehicles;
        } catch (Exception e) {
            throw new RuntimeException("could not read file " + filePath, e);
        }
    }

    private List<Vehicle> readFileLines(List<String> lines) throws Exception {

        for (String line : lines) {
            Vehicle vehicle = getVehicleByFileLine(line);

            vehicles.add(vehicle);

        }
        return vehicles;
    }

    public void importLinhes(List<String> lines) throws Exception {

        vehicles = list();
        List<Vehicle> newVehicles = readFileLines(lines);

        newVehicles.forEach((v) -> {
            try {
                save(v);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public Vehicle getVehicleByFileLine(String line) throws Exception {
        try {
             String[] properties = line.split("\\|");
        String vehiclePart = properties[0];
        String ComponentsPart = properties[1];

        String[] vehicleProperties = vehiclePart.split(";");

        Integer vinNumber = Integer.valueOf(vehicleProperties[1]);

        TypeVehicle typeVehicle = TypeVehicle.valueOf(vehicleProperties[2]);

        String name = vehicleProperties[3];

        String color = vehicleProperties[4];

        Vehicle vehicle = new Vehicle(vinNumber, typeVehicle, name, color);

        String[] componentsProperties = ComponentsPart.split(";");

        for (String componentProperty : componentsProperties) {
            String[] vehicleComponent = componentProperty.split("=");
            TypeCompent type = TypeCompent.valueOf(vehicleComponent[0]);
            String value = vehicleComponent[1];
            final Pattern pattern = Pattern.compile("\\(vin:(.+?)\\)");
            final Matcher matcher = pattern.matcher(value);
            if (matcher.find()) {
                String vin = matcher.group(1);
                Integer originVinNumber = Integer.valueOf(vin);
                Vehicle origin = get(vehicles, originVinNumber);

                vehicle.addCompent(origin, type);
            } else {
                Component component = new Component(type, value);
                vehicle.addCompent(component);
            }
            
        }
        return vehicle;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
       
        
    }

}
