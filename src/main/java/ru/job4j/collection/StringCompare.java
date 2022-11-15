package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        if (left.length() > right.length() && right.equals(left.substring(0, right.length()))) {
            rsl = 1;
        } else if (right.length() > left.length() && left.equals(right.substring(0, left.length()))) {
            rsl = -1;
        } else {
            for (int i = 0; i < left.length(); i++) {
                if (left.charAt(i) > right.charAt(i)) {
                    rsl = 1;
                    break;
                } else if (left.charAt(i) < right.charAt(i)) {
                    rsl = -1;
                    break;
                }
            }
        }
        return rsl;
    }
}