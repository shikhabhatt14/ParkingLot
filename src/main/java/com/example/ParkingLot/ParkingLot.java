package com.example.ParkingLot;

import java.util.Arrays;
import java.util.HashMap;

public class ParkingLot {
    private ParkingLevel[] parkingLevels;
    HashMap<Integer, Ticket> ticketHistory = new HashMap<>();

    public ParkingLot(int numLevels, int numSpotsPerLevel) {
        parkingLevels = new ParkingLevel[numLevels];
        for (int i = 0; i < numLevels; i++) {
            parkingLevels[i] = new ParkingLevel(i + 1, numSpotsPerLevel);
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingLevel level : parkingLevels) {
            if (level.parkVehicle(vehicle)) {
                ParkingSpot spot = Arrays.stream(level.getSpots()).filter(s -> s.isOccupied() && s.getVehicle().getLicensePlate().equals(vehicle.getLicensePlate())).findFirst().orElse(null);
                if(spot != null)
                    ticketHistory.put(spot.getSpotNumber(), spot.getTicket());
                return true;
            }
        }
        System.out.println("No available spot for vehicle " + vehicle.getLicensePlate());
        return false;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        for (ParkingLevel level : parkingLevels) {
            Ticket ticket = level.removeVehicle(vehicle);
            if (ticket != null) {
                PaymentService paymentService = new PaymentService();
                System.out.println("Ticket ID: " + ticket.getTicketId());
                System.out.println("Entry Time: " + ticket.getIssueTime());
                System.out.println("Exit Time: " + ticket.getExitTime());
                System.out.println("Total Price: ₹" + paymentService.processPayment(ticket)); // Assuming ₹10 per minute
                return true;
            }
        }
        System.out.println("Vehicle not found!");
        return false;
    }
}
