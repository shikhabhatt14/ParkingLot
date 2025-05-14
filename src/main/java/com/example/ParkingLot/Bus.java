package com.example.ParkingLot;

public class Bus extends Vehicle {
    public Bus(String licensePlate) {
        super(licensePlate, 3, VehicleSize.LARGE);
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSpotSize() == VehicleSize.LARGE;
    }
}
