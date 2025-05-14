package com.example.ParkingLot;

import java.util.Date;

public class ParkingSpot {
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int spotNumber;
    private int rowNumber;
    private int levelNumber;
    private Ticket ticket;

    public ParkingSpot(VehicleSize spotSize, int spotNumber, int rowNumber, int levelNumber) {
        this.spotSize = spotSize;
        this.spotNumber = spotNumber;
        this.rowNumber = rowNumber;
        this.levelNumber = levelNumber;
        this .ticket = null;
        this.vehicle = null;
    }
    public VehicleSize getSpotSize() {
        return spotSize;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return isAvailable() && vehicle.size == this.spotSize;
    }

    public boolean isOccupied() {
        return vehicle != null;
    }

    public boolean park(Vehicle vehicle) {
        if (canFitVehicle(vehicle)) {
            this.vehicle = vehicle;
            this.ticket = new Ticket(vehicle);
            this.ticket.setIssueTime(new Date());
            return true;
        }
        return false;
    }

    public Ticket remove() {
        Ticket issued = this.ticket;
        issued.setExitTime(new Date());
        this.vehicle = null;
        this.ticket = null;
        return issued;
    }

}
