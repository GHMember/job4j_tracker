package ru.job4j.lamda;

import java.net.Proxy;
import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        for (int num : number) {
            int finalTotal = total;
            total = add(
                    () -> finalTotal + num
            );
        }
        System.out.println(total);
        double a = 4.0D;
        int b = 2;
        a = a / b;
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}
