package com.marcinkiewicz.delivery;

import com.marcinkiewicz.vehicles.Airplane;
import com.marcinkiewicz.vehicles.Bus;
import com.marcinkiewicz.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Delivery<T> {

    private T currentTransportVehicle;
    private List<T> previousTransportVehicles;

    public T getCurrentTransportVehicle(){
        return currentTransportVehicle;
    }

    public void setCurrentTransportVehicle(T currentTransportVehicle){
        this.currentTransportVehicle = currentTransportVehicle;
    }

    public List<T> getPreviousTransportVehicles(){
        return previousTransportVehicles;
    }

    public void setPreviousTransportVehicles(List<T> previousTransportVehicles){
        this.previousTransportVehicles = previousTransportVehicles;
    }

    public List<? extends T> getAllAirplanes(){
        List<Airplane> allAirplanes = new ArrayList<>();
        if(currentTransportVehicle instanceof Airplane){
            allAirplanes.add((Airplane) currentTransportVehicle);
        }

        for (int i=0; i<previousTransportVehicles.size(); i++) {
            if (previousTransportVehicles.get(i) instanceof Airplane){
                allAirplanes.add((Airplane)previousTransportVehicles.get(i));
            }
        }
        return (List<? extends T>) allAirplanes;
    }

    public void removePreviousTransportVehicles(List<? extends T> vehiclesToRemove){
        previousTransportVehicles.removeAll(vehiclesToRemove);
    }

    public List<? super T> getAllBuses(){
        List<Bus> allBuses = new ArrayList<>();
        if(currentTransportVehicle instanceof Bus){
            allBuses.add((Bus)currentTransportVehicle);
        }

        for(int i = 0; i < previousTransportVehicles.size(); i++){
            if(previousTransportVehicles.get(i) instanceof Bus){
                allBuses.add((Bus) previousTransportVehicles.get(i));
            }
        }

        return (List<? super T>) allBuses;
    }

    public void getInfoAboutVehiclesFromList(List<? super T> vehicleList){
        for(int i = 0; i < vehicleList.size(); i++){
            if(vehicleList.get(i) instanceof Vehicle){
                vehicleList.get(i).toString();
            }
        }
    }

}
