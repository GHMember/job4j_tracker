package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle autobus = new Autobus();

        Vehicle[] vehicles = {airplane, train, autobus};
        for (Vehicle a : vehicles) {
            a.move();
        }
    }
}
