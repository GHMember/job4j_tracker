package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int y) {
        return x * y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(5);
        System.out.println(result);
        result = Calculator.minus(5);
        System.out.println(result);
        Calculator calc = new Calculator();
        result = calc.multiply(5);
        System.out.println(result);
        result = calc.divide(5);
        System.out.println(result);
        result = calc.sumAllOperation(5);
        System.out.println(result);
    }
}