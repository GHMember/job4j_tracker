package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("");
    }

    @Override
    public void passengers(int count) {
        System.out.println("");
    }

    @Override
    public int refuel(int fuel) {
        int price = 0;
        return price;
    }

}
