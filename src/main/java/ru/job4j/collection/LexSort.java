package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int leftNumber = Integer.parseInt(left.split("\\.\\s*")[0]);
        int rightNuber = Integer.parseInt(right.split("\\.\\s*")[0]);
        return Integer.compare(leftNumber, rightNuber);
    }
}