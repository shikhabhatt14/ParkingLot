package com.example.ParkingLot;

public abstract class Vehicle {

    protected String licensePlate;
    protected int spotNeeded;
    protected VehicleSize size;

    public Vehicle(String licensePlate, int spotNeeded, VehicleSize size) {
        this.licensePlate = licensePlate;
        this.spotNeeded = spotNeeded;
        this.size = size;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getSpotNeeded() {
        return spotNeeded;
    }

    public VehicleSize getSize() {
        return size;
    }

    public abstract boolean canFitInSpot(ParkingSpot spot);


}
