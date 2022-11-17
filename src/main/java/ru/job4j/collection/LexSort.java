package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] splitLeft = left.split("\\.");
        String[] splitRight = right.split("\\.");
        int numLeft = Integer.parseInt(splitLeft[0]);
        int numRight = Integer.parseInt(splitRight[0]);
        return Integer.compare(numLeft, numRight);
    }
}