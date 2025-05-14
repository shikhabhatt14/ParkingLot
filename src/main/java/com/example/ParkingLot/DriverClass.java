package com.example.ParkingLot;

public class DriverClass {

    public static void main(String[] args) throws InterruptedException {
        ParkingLot parkingLot = new ParkingLot(3, 10); // 10 compact spots, 5 large spots, 2 motorcycle spots

        Vehicle car = new Car("ABC123");
        Vehicle bus = new Bus("BUS456");
        Vehicle motorcycle = new Motorcycle("MOTO789");

        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(bus);
        parkingLot.parkVehicle(motorcycle);

        Thread.sleep(3000); // Simulate time delay (3 seconds)

        parkingLot.removeVehicle(car);
        parkingLot.removeVehicle(bus);
        parkingLot.removeVehicle(motorcycle);


    }
}
