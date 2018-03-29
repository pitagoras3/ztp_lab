package com.marcinkiewicz.application;

import com.marcinkiewicz.delivery.Delivery;
import com.marcinkiewicz.vehicles.Airplane;
import com.marcinkiewicz.vehicles.Bus;
import com.marcinkiewicz.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args){

        Delivery<?> delivery1 = new Delivery();
        Delivery<? extends Vehicle> delivery2 = new Delivery();
        Delivery<? super  Vehicle> delivery3 = new Delivery<>();


        List<Vehicle> vehicles = new ArrayList<>();
        List<Airplane> airplanes = new ArrayList<>();
        List<Bus> buses = new ArrayList<>();

        Airplane airbus = new Airplane("Airbus", 100000d, 10);
        Airplane cesna = new Airplane("Cesna", 80000d, 12);

        Bus iveco = new Bus("Iveco", 1500d, 120);
        Bus vw = new Bus("VW", 2000d, 100);
        Bus opel = new Bus("Opel", 1000d, 150);

        vehicles.add(airbus);
        vehicles.add(cesna);
        vehicles.add(iveco);
        vehicles.add(vw);

        airplanes.add(airbus);
        airplanes.add(cesna);

        buses.add(iveco);
        buses.add(vw);
        buses.add(opel);

        // ===================================================== //
        // ======================= ? =========================== //
        // ===================================================== //

        delivery1.getCurrentTransportVehicle();
        delivery1.setCurrentTransportVehicle(opel);

        delivery1.getPreviousTransportVehicles();
        delivery1.setPreviousTransportVehicles(vehicles);

        delivery1.getAllAirplanes();
        delivery1.removePreviousTransportVehicles(vehicles);


        delivery1.getAllBuses();
        delivery1.getInfoAboutVehiclesFromList(vehicles);

        // ===================================================== //
        // ================== ? extends T ====================== //
        // ===================================================== //

        delivery2.getCurrentTransportVehicle();
        delivery2.setCurrentTransportVehicle(opel);

        delivery2.getPreviousTransportVehicles();
        delivery2.setPreviousTransportVehicles(vehicles);

        delivery2.getAllAirplanes();
        delivery2.removePreviousTransportVehicles(vehicles);


        delivery2.getAllBuses();
        delivery2.getInfoAboutVehiclesFromList(vehicles);

        // ===================================================== //
        // =================== ? super T ======================= //
        // ===================================================== //

        delivery3.getCurrentTransportVehicle();
        delivery3.setCurrentTransportVehicle(opel);

        delivery3.getPreviousTransportVehicles();
        delivery3.setPreviousTransportVehicles(vehicles);

        delivery3.getAllAirplanes();
        delivery3.removePreviousTransportVehicles(vehicles);

        delivery3.getAllBuses();
        delivery3.getInfoAboutVehiclesFromList(vehicles);

    }
}
