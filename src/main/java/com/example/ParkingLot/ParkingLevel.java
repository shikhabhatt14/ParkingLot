package com.example.ParkingLot;

public class ParkingLevel {
    private int levelNumber;
    private ParkingSpot[] spots;

    public ParkingLevel(int levelNumber, int numSpots) {
        this.levelNumber = levelNumber;
        this.spots = new ParkingSpot[numSpots];

        for (int i = 0; i < numSpots; i++) {
            VehicleSize size;
            int rowNumber;
            if (i % 3 == 0) {
                size = VehicleSize.LARGE;
                rowNumber = 3;
            } else if (i % 2 == 0) {
                size = VehicleSize.COMPACT;
                rowNumber = 2;
            } else {
                size = VehicleSize.MOTORCYCLE;
                rowNumber = 1;
            }
            spots[i] = new ParkingSpot(size, i, rowNumber, levelNumber);
        }
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public ParkingSpot[] getSpots() {
        return spots;
    }

    public boolean parkVehicle(Vehicle vehicle){
        for(ParkingSpot spot : spots){
            if(spot.canFitVehicle(vehicle)){
                if(spot.park(vehicle)){
                    System.out.println("Vehicle " + vehicle.getLicensePlate() + " parked at level " + levelNumber + ", spot " + spot.getSpotNumber());
                    return true;
                }
            }
        }
        System.out.println("No available spot for vehicle " + vehicle.getLicensePlate() + " at level " + levelNumber);
        return false;
    }

    public Ticket removeVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied() && spot.getVehicle().getLicensePlate().equals(vehicle.getLicensePlate())) {
                System.out.println("Vehicle " + vehicle.getLicensePlate() + " removed from level " + levelNumber + ", spot " + spot.getSpotNumber());
                return spot.remove();
            }
        }
        System.out.println("Vehicle " + vehicle.getLicensePlate() + " not found in level " + levelNumber);
        return null;
    }
}
