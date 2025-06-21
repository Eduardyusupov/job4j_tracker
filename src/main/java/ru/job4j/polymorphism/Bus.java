package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("В движении");
    }

    @Override
    public void passengers() {
        System.out.println("Загрузка пассажиров");

    }

    @Override
    public int refuel(int fuel) {
        return fuel * 60;
    }
}
