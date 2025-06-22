package ru.job4j.cast;

public class VehicleParking {

    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle airplane = new Airplane();

        Vehicle[] vehicles = {bus, train, airplane};

        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}
