package com.example.ParkingLot;

public class PaymentService {
    private double calculateFees(Ticket ticket){
        long duration = ticket.calculateDuration();
        //return duration/3600.0; // Assuming a rate of $1 per hour
        return duration * 0.25; // Assuming a rate of $0.25 per sec for testing purpose
    }

    public double processPayment(Ticket ticket) {
        double fees = calculateFees(ticket);
        //System.out.println("Processing payment of $" + fees + " for vehicle " + ticket.getVehicle().getLicensePlate());
        // Here you would integrate with a payment gateway
        // For simplicity, we'll just print the payment details
        return fees;
    }
}
