package com.greenwheel.repository;

import java.util.ArrayList;
import java.util.List;

import com.greenwheel.model.Dealership;
import com.greenwheel.model.Vehicle;
import com.greenwheel.util.FileUtils;
import java.io.FileNotFoundException;
import java.util.stream.Collectors;

public class DealershipRepository implements Reposity<Dealership, Integer> {

    List<Dealership> dealerships = new ArrayList<>();

    @Override
    public void save(Dealership vehicle) throws Exception {

        if (vehicle.getInventory().size() < 5 ) {
            throw new Exception("Incomplete car stock. The minimum limit is 5");
        }

        String line = vehicle.toLine();
        String filePath = FileUtils.getGreenWheelFilePath();
        FileUtils.writeLine(filePath, line);
    }

    @Override
    public Dealership get(Integer vinNumber) throws Exception {
        dealerships = list();
        return get(dealerships, vinNumber);
    }

    public Dealership get(List<Dealership> vehicles, Integer vinNumber) throws Exception {
        return vehicles.stream().filter(v -> v.getDeshNumber().equals(vinNumber)).findFirst()
                .orElseThrow(() -> new Exception("Dealership (vin:" + vinNumber + ") not found"));
    }

    @Override
    public List<Dealership> list() throws Exception {
        dealerships = new ArrayList<>();
        String filePath = FileUtils.getGreenWheelFilePath();
        try {

            List<String> lines = FileUtils.readAllLines(filePath);

            List<String> dealershipLines = lines.stream().filter(l -> l.startsWith("delership")).collect(Collectors.toList());

            return readFileLines(dealershipLines);
        } catch (FileNotFoundException e) {
            return dealerships;
        } catch (Exception e) {
            throw new RuntimeException("could not read file " + filePath+"\n"+e.getMessage(), e);
        }
    }

    private List<Dealership> readFileLines(List<String> lines) throws Exception {

        for (String line : lines) {
            Dealership vehicle = getDealershipByFileLine(line);

            dealerships.add(vehicle);

        }
        return dealerships;
    }

    public void importLinhes(List<String> lines) throws Exception {

        List<Dealership> newDealerships = readFileLines(lines);

        newDealerships.forEach((v) -> {
            try {
                save(v);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public Dealership getDealershipByFileLine(String line) throws Exception {
        String[] properties = line.split("\\|");
        String dealerShipPart = properties[0];
        String inventoryPart = properties[1];

        String[] dealerShipProperties = dealerShipPart.split(";");

        Integer vinNumber = Integer.valueOf(dealerShipProperties[1]);

        String name = dealerShipProperties[2];

        String address = dealerShipProperties[3];

        Dealership dealerShip = new Dealership(vinNumber, name, address);

        String[] dealerInventory = inventoryPart.split(";");

        VehicleRepository vehicleRepository = new VehicleRepository();

        for (String vin : dealerInventory) {
            Integer vehicleVinNumber = Integer.valueOf(vin);
            Vehicle vehicle = vehicleRepository.get(vehicleVinNumber);
            dealerShip.addVehicle(vehicle);
        }

        return dealerShip;
    }

}
