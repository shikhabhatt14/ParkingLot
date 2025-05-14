package com.example.ParkingLot;

import java.util.Date;

public class Ticket {

    private static int counter = 1;
    private int ticketId = 0;
    private Vehicle vehicle;
    private Date issueTime;
    private Date exitTime;

    public Ticket(Vehicle vehicle) {
        this.ticketId = counter++;
        this.vehicle = vehicle;
        this.issueTime = new Date();
        this.exitTime = null;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    public Date getIssueTime() {
        return issueTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public long calculateDuration() {
        if (exitTime == null) {
            return 0; // Vehicle is still parked
        }
        long durationInMillis = exitTime.getTime() - issueTime.getTime();
        return durationInMillis / (1000); // Duration in seconds
    }
}
