package com.example.ParkingLot;

public class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, 1, VehicleSize.COMPACT);
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSpotSize() == VehicleSize.COMPACT || spot.getSpotSize() == VehicleSize.LARGE;
    }
}
