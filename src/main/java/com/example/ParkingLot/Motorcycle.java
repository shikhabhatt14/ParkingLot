package com.example.ParkingLot;

public class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate) {
        super(licensePlate, 1, VehicleSize.MOTORCYCLE);
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return true; // Motorcycles can fit in any spot
    }
}
